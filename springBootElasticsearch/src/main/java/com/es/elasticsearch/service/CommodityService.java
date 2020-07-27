package com.es.elasticsearch.service;

import com.es.elasticsearch.entity.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommodityService {

    long count();

    Commodity save(Commodity commodity);

    void delete(Commodity commodity);

    Iterable<Commodity> getAll();

    List<Commodity> getByName(String name);

    Page<Commodity> pageQuery(Integer pageNo, Integer pageSize, String kw);

    /**
     * 搜索附近的体验店
     *
     * @param lat 经度
     * @param lon 维度
     * @param distance 距离
     * @param pageable
     * @return
     */
    Page<Commodity> findAllByLocaltion(
            double lat, double lon, double distance, Pageable pageable);

}