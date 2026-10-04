package vn.iotstar.services;

import vn.iotstar.entity.User_24110177;

public interface UserService_24110177 {
    User_24110177 login(String username, String password);
    void insert(User_24110177 user);
}