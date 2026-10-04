package vn.iotstar.services.impl;

import jakarta.persistence.EntityManager;
import java.util.List;
import vn.iotstar.configs.JPAConfig_24110177;
import vn.iotstar.entity.Category_24110177;
import vn.iotstar.services.CategoryService_24110177;

public class CategoryServiceImpl_24110177 implements CategoryService_24110177 {
    @Override
    public List<Category_24110177> getAll() {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            return en.createQuery("SELECT c FROM Category_24110177 c", Category_24110177.class).getResultList();
        } finally {
            en.close();
        }
    }

    @Override
    public Category_24110177 getById(int id) {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            return en.find(Category_24110177.class, id);
        } finally {
            en.close();
        }
    }
}