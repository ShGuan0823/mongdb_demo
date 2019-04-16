package com.test.demo.controller;

import com.test.demo.domain.TestDemo;
import com.test.demo.service.TestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(value = "/save")
    public String save(@RequestBody TestDemo testDemo) {
        return testDemoService.save(testDemo);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public TestDemo get(@PathVariable(name = "id") String id) {
        return testDemoService.get(id);
    }

    @PostMapping(value = "/update")
    public Boolean update(@RequestBody TestDemo testDemo) {
        return testDemoService.update(testDemo);
    }

    @PostMapping(value = "/delete/{id}")
    public Boolean delete(@PathVariable(name = "id") String id) {
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
}