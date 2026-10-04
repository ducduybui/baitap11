package vn.iotstar.services.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import vn.iotstar.configs.JPAConfig_24110177;
import vn.iotstar.entity.Video_24110177;
import vn.iotstar.services.VideoService_24110177;

public class VideoServiceImpl_24110177 implements VideoService_24110177 {

    @Override
    public void insert(Video_24110177 video) {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            en.getTransaction().begin();
            en.persist(video);
            en.getTransaction().commit();
        } catch (Exception e) {
            en.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            en.close();
        }
    }

    @Override
    public void update(Video_24110177 video) {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            en.getTransaction().begin();
            en.merge(video);
            en.getTransaction().commit();
        } catch (Exception e) {
            en.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            en.close();
        }
    }

    @Override
    public void delete(String id) {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            en.getTransaction().begin();
            Video_24110177 video = en.find(Video_24110177.class, id);
            if (video != null) {
                en.remove(video);
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
    public Video_24110177 getById(String id) {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            return en.find(Video_24110177.class, id);
        } finally {
            en.close();
        }
    }

    @Override
    public List<Video_24110177> getAll() {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            return en.createQuery("SELECT v FROM Video_24110177 v", Video_24110177.class).getResultList();
        } finally {
            en.close();
        }
    }

    @Override
    public List<Video_24110177> findAllPaginate(int page, int pageSize) {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            TypedQuery<Video_24110177> query = en.createQuery("SELECT v FROM Video_24110177 v", Video_24110177.class);
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        } finally {
            en.close();
        }
    }

    @Override
    public long count() {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            return en.createQuery("SELECT count(v) FROM Video_24110177 v", Long.class).getSingleResult();
        } finally {
            en.close();
        }
    }

    @Override
    public List<Video_24110177> findByCategoryIdPaginate(int categoryId, int page, int pageSize) {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            TypedQuery<Video_24110177> query = en.createQuery(
                "SELECT v FROM Video_24110177 v WHERE v.categoryid = :cid", Video_24110177.class);
            query.setParameter("cid", categoryId);
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        } finally {
            en.close();
        }
    }

    @Override
    public long countByCategoryId(int categoryId) {
        EntityManager en = JPAConfig_24110177.getEntityManager();
        try {
            TypedQuery<Long> query = en.createQuery(
                "SELECT count(v) FROM Video_24110177 v WHERE v.categoryid = :cid", Long.class);
            query.setParameter("cid", categoryId);
            return query.getSingleResult();
        } finally {
            en.close();
        }
    }
}