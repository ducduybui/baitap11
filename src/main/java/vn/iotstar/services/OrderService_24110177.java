package vn.iotstar.services;

import vn.iotstar.entity.Order_24110177;
import vn.iotstar.entity.User_24110177;
import vn.iotstar.model.CartItem_24110177;
import java.util.List;

public interface OrderService_24110177 {
    void saveOrder(User_24110177 user, List<CartItem_24110177> cartItems);
    List<Order_24110177> findByUserId(String username);
    
    // THÊM HÀM MỚI LỌC THEO TRẠNG THÁI
    List<Order_24110177> findByUserIdAndStatus(String username, String status);
}