package com.test.demo.service;

import com.test.demo.domain.TestDemo;

import java.util.List;

/**
 * @Author Ssssg
 * @Description TODO
 * @Date 2019/4/16 9:47
 **/
public interface TestDemoService {

    String save(TestDemo entity);

    Boolean remove(String id);

    boolean update(TestDemo entity);

    TestDemo get(String id);

    List<TestDemo> list();

    TestDemo testGet();
}