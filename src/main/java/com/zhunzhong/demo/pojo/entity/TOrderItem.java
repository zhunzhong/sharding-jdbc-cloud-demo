package com.zhunzhong.demo.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhunzhong
 * @since 2022-06-17
 */
@Getter
@Setter
@TableName("t_order_item")
public class TOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value="order_item_id",type = IdType.AUTO)
    private Long orderItemId;

    @TableField("order_id")
    private Long orderId;

    @TableField("user_id")
    private Long userId;

    @TableField("status")
    private String status;


    @Override
    public String toString() {
        return "TOrderItem{" +
            "orderItemId=" + orderItemId +
            ", orderId=" + orderId +
            ", userId=" + userId +
            ", status=" + status +
        "}";
    }
}
