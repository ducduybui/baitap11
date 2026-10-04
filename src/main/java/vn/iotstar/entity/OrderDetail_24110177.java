package vn.iotstar.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "OrderDetails")
public class OrderDetail_24110177 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailId")
    private int orderDetailId;

    @ManyToOne
    @JoinColumn(name = "OrderId")
    private Order_24110177 order;

    // Liên kết với bảng Video (sản phẩm) của bạn
    @ManyToOne
    @JoinColumn(name = "VideoId")
    private Video_24110177 video;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Price")
    private double price;

    // Getters & Setters
    public int getOrderDetailId() { return orderDetailId; }
    public void setOrderDetailId(int orderDetailId) { this.orderDetailId = orderDetailId; }

    public Order_24110177 getOrder() { return order; }
    public void setOrder(Order_24110177 order) { this.order = order; }

    public Video_24110177 getVideo() { return video; }
    public void setVideo(Video_24110177 video) { this.video = video; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}