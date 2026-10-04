package vn.iotstar.model;

import vn.iotstar.entity.Video_24110177;
import java.io.Serializable;

public class CartItem_24110177 implements Serializable {
    
    private Video_24110177 video;
    private int quantity;

    public CartItem_24110177() {}

    public CartItem_24110177(Video_24110177 video, int quantity) {
        this.video = video;
        this.quantity = quantity;
    }

    public Video_24110177 getVideo() { return video; }
    public void setVideo(Video_24110177 video) { this.video = video; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}