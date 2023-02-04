package com.zhunzhong.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhunzhong.demo.dao.OrderDao;
import com.zhunzhong.demo.pojo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * //https://mvnrepository.com/
 * Created by root on 2019/4/28.
 */
@RestController
@RequestMapping("/demo")
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @RequestMapping(value = "/add", method = GET)
    @ResponseBody
    public String add(){
        IService<Thread> a;
//        for(int i=0;i<10;i++){
//            Order order = new Order();
//            order.setOrderId((long) i);
//            order.setUserId((long) i);
//            orderDao.saveToOne(order);
//        }
        Order order = new Order();
        order.setUserId(13L);
        order.setOrderId(IdWorker.getId());
        orderDao.saveToOne(order);
        return "success";
    }

    @RequestMapping("/query")
    public List<Order> queryAll(){
        List<Order> res = orderDao.findAllData();
        return res;
    }


}
