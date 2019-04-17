package com.test.demo.dao;

import com.test.demo.domain.TestDemo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ShGuan
 * @Description TODO
 * @Date 2019/4/17 9:30
 **/
@Repository
public interface TestDemoRepository extends MongoRepository<TestDemo, String> {

    @Query(value = "{date;{$gte:?0}}")
    List<TestDemo> getListByDate(String preDate, String lastDate);

}