package com.zhunzhong.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhunzhong.demo.mapper.TOrderItemMapper;
import com.zhunzhong.demo.mapper.TOrderMapper;
import com.zhunzhong.demo.pojo.entity.TOrder;
import com.zhunzhong.demo.pojo.entity.TOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhunzhong
 * @datetime 2022/6/17 15:08
 * @description
 */
@RestController
@RequestMapping("/shadingTest")
@RefreshScope
public class ShardingTestController {

    @Autowired
    private TOrderMapper tOrderMapper;

    @Autowired
    private TOrderItemMapper tOrderItemMapper;

    //https://shardingsphere.apache.org/document/current/cn/overview/
    @GetMapping("/testReadWrite")
    public String testReadWrite() throws JsonProcessingException {
        TOrder tOrder = new TOrder(null, 1L, "创建");
        tOrderMapper.insert(tOrder);
        QueryWrapper<TOrder> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("order_id", 1);
        TOrder order = tOrderMapper.selectOne(orderQueryWrapper);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(order);
        System.out.println(jsonStr);
        return "ok";
    }

    @GetMapping("/testSharding")
    public String testSharding(@RequestParam("userId") Long userId) throws JsonProcessingException {
        //IdWorker.getId();
        //写入订单数据.
        TOrder tOrder = new TOrder(null, userId, "创建");
        tOrderMapper.insert(tOrder);
        Long orderId = tOrder.getOrderId();

        TOrderItem orderItem = new TOrderItem();
        orderItem.setOrderId(orderId);
        orderItem.setStatus("open");
        orderItem.setUserId(userId);
        tOrderItemMapper.insert(orderItem);

        //查询订单数据。
        ObjectMapper objectMapper = new ObjectMapper();

        QueryWrapper<TOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.eq("order_id", tOrder.getOrderId());
        System.out.println(objectMapper.writeValueAsString(tOrderMapper.selectOne(wrapper)));

        QueryWrapper<TOrderItem> queryItem = new QueryWrapper<>();
        queryItem.eq("user_id", userId);
        queryItem.eq("order_id", tOrder.getOrderId());
        queryItem.eq("order_item_id", orderItem.getOrderItemId());
        System.out.println(objectMapper.writeValueAsString(tOrderItemMapper.selectOne(queryItem)));
        return "ok";
    }
}
