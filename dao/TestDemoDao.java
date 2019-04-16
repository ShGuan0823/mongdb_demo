package com.test.demo.dao;

import com.test.demo.domain.TestDemo;

import java.util.List;

/**
 * @author Ssssg
 */
public interface TestDemoDao {

    String save(TestDemo entity);

    Boolean remove(String id);

    boolean update(TestDemo entity);

    TestDemo get(String id);

    List<TestDemo> list();

    TestDemo testGet();
}
