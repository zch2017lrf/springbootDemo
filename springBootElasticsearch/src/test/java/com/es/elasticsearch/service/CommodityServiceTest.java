package com.es.elasticsearch.service;

import com.es.elasticsearch.dao.CommodityRepository;
import com.es.elasticsearch.entity.Commodity;
import org.elasticsearch.common.geo.GeoDistance;
import org.elasticsearch.common.unit.DistanceUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommodityServiceTest {
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private CommodityRepository commodityRepository;

    @Test
    public void contextLoads() {

        System.out.println(commodityService.count());
    }

    @Test
    public void testInsert() {
        Commodity commodity = new Commodity();
        commodity.setSkuId("1501009011");
        commodity.setName("原味切片面包（10片装）");
        commodity.setCategory("101");
        commodity.setPrice(880);
        commodity.setBrand("良品铺子");

        GeoPoint geoPoint = new GeoPoint(30.282905,119.987661);
        commodity.setLocation(geoPoint);
        commodity.setLat(30.282905);
        commodity.setLon(119.987661);
        commodityService.save(commodity);

        commodity = new Commodity();
        commodity.setSkuId("1501009012");
        commodity.setName("原味切片面包（6片装）");
        commodity.setCategory("101");
        commodity.setPrice(680);
        commodity.setLocation(new GeoPoint(30.316513,120.021278));
        commodity.setLat(30.316513);
        commodity.setLon(120.021278);
        commodity.setBrand("良品铺子");
        commodityService.save(commodity);

        commodity = new Commodity();
        commodity.setSkuId("1501009014");
        commodity.setName("元气吐司850g");
        commodity.setCategory("101");
        commodity.setPrice(120);
        commodity.setLocation(new GeoPoint(30.241073,119.949798));
        commodity.setLat(30.241073);
        commodity.setLon(119.949798);
        commodity.setBrand("百草味");
        commodityService.save(commodity);

    }

    @Test
    public void testDelete() {
        Commodity commodity = new Commodity();
        commodity.setSkuId("1501009002");
        commodityService.delete(commodity);
    }

    @Test
    public void testGetAll() {
        Iterable<Commodity> iterable = commodityService.getAll();
        iterable.forEach(e -> System.out.println(e.toString()));
    }

    @Test
    public void testGetByName() {
        List<Commodity> list = commodityService.getByName("面包");
        System.out.println(list);
    }

    @Test
    public void testPage() {
//        Page<Commodity> page = commodityService.pageQuery(0, 10, "切片");
//        System.out.println(page.getTotalPages());
//        System.out.println(page.getNumber());
//        System.out.println(page.getContent());
        //经纬度查询
        Pageable pageable = new PageRequest(0,10);
        Page<Commodity> page = commodityService.findAllByLocaltion(30.292227, 120.004870, 2000, pageable);
        List<Commodity> list = page.getContent();
        list.forEach(l -> {
            double calculate = GeoDistance.PLANE.calculate(l.getLat(), l.getLon(), 30.292227, 120.004870, DistanceUnit.METERS);
            l.setDistanceMeters("距离" + (int)calculate + "m");
        });
        for (Commodity commodity : list) {
            System.out.println(commodity.toString());
        }
    }

}