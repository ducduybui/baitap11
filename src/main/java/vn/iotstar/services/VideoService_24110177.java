package vn.iotstar.services;

import java.util.List;
import vn.iotstar.entity.Video_24110177;

public interface VideoService_24110177 {
    void insert(Video_24110177 video);
    void update(Video_24110177 video);
    void delete(String id);
    Video_24110177 getById(String id);
    List<Video_24110177> getAll();
    List<Video_24110177> findAllPaginate(int page, int pageSize);
    long count();
    List<Video_24110177> findByCategoryIdPaginate(int categoryId, int page, int pageSize);
    long countByCategoryId(int categoryId);
}