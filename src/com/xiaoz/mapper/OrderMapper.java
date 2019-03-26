package com.xiaoz.mapper;

import com.xiaoz.model.Orders;
import com.xiaoz.model.OrdersExt;
import com.xiaoz.model.User;
import com.xiaoz.vo.UserQueryVO;
import org.apache.logging.log4j.core.config.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    OrdersExt findOrderById(int id);
    Orders findOrderById2(int id);
    Orders findOrderById3(int id);


}
