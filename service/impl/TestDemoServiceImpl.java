package com.test.demo.service.impl;

import com.test.demo.dao.TestDemoDao;
import com.test.demo.domain.TestDemo;
import com.test.demo.service.TestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Ssssg
 * @Description TODO
 * @Date 2019/4/16 9:47
 **/

@Service
public class TestDemoServiceImpl implements TestDemoService {

    @Autowired
    TestDemoDao testDemoDao;

    @Override
    public String save(TestDemo entity) {
        return testDemoDao.save(entity);
    }

    @Override
    public Boolean remove(String id) {
        return testDemoDao.remove(id);
    }

    @Override
    public boolean update(TestDemo entity) {
        return testDemoDao.update(entity);
    }

    @Override
    public TestDemo get(String id) {
        return testDemoDao.get(id);
    }

    @Override
    public List<TestDemo> list() {
        return testDemoDao.list();
    }

    @Override
    public TestDemo testGet() {
        return testDemoDao.testGet();
    }
}