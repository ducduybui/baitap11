package vn.iotstar.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Orders") // Dùng 'Orders' vì 'Order' là từ khóa nhạy cảm trong SQL
public class Order_24110177 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private int orderId;

    // Liên kết với bảng User cũ của bạn
    @ManyToOne
    @JoinColumn(name = "UserId")
    private User_24110177 user;

    @Column(name = "OrderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    // Trạng thái đơn hàng: "Mới", "Đã xác nhận", "Vận chuyển"...
    @Column(name = "Status", columnDefinition = "NVARCHAR(50)")
    private String status;

    @Column(name = "TotalAmount")
    private double totalAmount;

    @Column(name = "PaymentMethod", length = 50)
    private String paymentMethod;

    // Getters & Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public User_24110177 getUser() { return user; }
    public void setUser(User_24110177 user) { this.user = user; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}