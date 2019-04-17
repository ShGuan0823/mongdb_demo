package com.test.demo.controller;

import com.test.demo.dao.TestDemoRepository;
import com.test.demo.domain.TestDemo;
import com.test.demo.service.TestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Author Ssssg
 * @Description TODO
 * @Date 2019/4/16 9:50
 **/

@Controller
@RequestMapping(value = "/test")
public class TestDemoController {

    @Autowired
    TestDemoService testDemoService;

    @Autowired
    private TestDemoRepository testDemoRepository;

    @PostMapping(value = "/save")
    @ResponseBody
    public String save(@RequestBody TestDemo testDemo) {
        return testDemoService.save(testDemo);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public TestDemo get(@PathVariable(name = "id") String id) {
        return testDemoService.get(id);
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public Boolean update(@RequestBody TestDemo testDemo) {
        return testDemoService.update(testDemo);
    }

    @PostMapping(value = "/delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable(name = "id") String id) {
        return testDemoService.remove(id);
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public List<TestDemo> list() {
        return testDemoService.list();
    }

    @GetMapping(value = "/get")
    @ResponseBody
    public TestDemo testGet() {
        return testDemoService.testGet();
    }

    @GetMapping(value = "/repository/list")
    @ResponseBody
    public List<TestDemo> testRepositoryLis() {
        List<TestDemo> list = testDemoRepository.findAll();
        return list;
    }

    @GetMapping(value = "/repository/get/{id}")
    @ResponseBody
    public Optional<TestDemo> testRepositoryGet(@PathVariable(name = "id") String id) {
        return testDemoRepository.findById(id);
    }

    @PostMapping(value = "/repository/save")
    @ResponseBody
    public String testRepositorySave(@RequestBody TestDemo testDemo) {
        testDemoRepository.save(testDemo);
        return testDemo.getId();
    }

    @PostMapping(value = "/repository/delete/{id}")
    @ResponseBody
    public Boolean testRepositoryDel(@PathVariable(name = "id") String id) {
        testDemoRepository.deleteById(id);
        return true;
    }

    @PostMapping(value = "/repository/update")
    @ResponseBody
    public Boolean testRepositoryUpdate(@RequestBody TestDemo testDemo) {
        testDemoRepository.save(testDemo);
        return true;
    }

    @GetMapping(value = "/repository/date")
    @ResponseBody
    public List<TestDemo> testRespositoryGetByDate(String preDate, String lastDate) {
        List<TestDemo> list = testDemoRepository.getListByDate(preDate, lastDate);
        return list;
    }
}