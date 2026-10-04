package vn.iotstar.services.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig_24110177;
import vn.iotstar.entity.Order_24110177;
import vn.iotstar.entity.OrderDetail_24110177;
import vn.iotstar.entity.User_24110177;
import vn.iotstar.model.CartItem_24110177;
import vn.iotstar.services.OrderService_24110177;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl_24110177 implements OrderService_24110177 {

    @Override
    public void saveOrder(User_24110177 user, List<CartItem_24110177> cartItems) {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            en.getTransaction().begin();

            Order_24110177 order = new Order_24110177();
            order.setUser(user);
            order.setOrderDate(new Date());
            order.setStatus("Mới"); 
            order.setPaymentMethod("COD"); 

            double total = 0;
            for (CartItem_24110177 item : cartItems) {
                total += (item.getQuantity() * 1000); 
            }
            order.setTotalAmount(total);

            en.persist(order);

            for (CartItem_24110177 item : cartItems) {
                OrderDetail_24110177 detail = new OrderDetail_24110177();
                detail.setOrder(order);
                detail.setVideo(item.getVideo());
                detail.setQuantity(item.getQuantity());
                detail.setPrice(1000); 
                en.persist(detail);
            }

            en.getTransaction().commit();
        } catch (Exception e) {
            en.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            en.close();
        }
    }

    @Override
    public List<Order_24110177> findByUserId(String username) {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            TypedQuery<Order_24110177> query = en.createQuery(
                "SELECT o FROM Order_24110177 o WHERE o.user.username = :username", Order_24110177.class);
            query.setParameter("username", username);
            return query.getResultList();
        } finally {
            en.close();
        }
    }
}