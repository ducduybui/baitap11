package vn.iotstar.services.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig_24110177;
import vn.iotstar.entity.User_24110177;
import vn.iotstar.services.UserService_24110177;

public class UserServiceImpl_24110177 implements UserService_24110177 {

    @Override
    public User_24110177 login(String username, String password) {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            TypedQuery<User_24110177> query = en.createQuery(
                "SELECT u FROM User_24110177 u WHERE u.username = :username AND u.password = :password", 
                User_24110177.class
            );
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            en.close();
        }
    }

    @Override
    public void insert(User_24110177 user) {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            en.getTransaction().begin();
            en.persist(user);
            en.getTransaction().commit();
        } catch (Exception e) {
            en.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            en.close();
        }
    }
}