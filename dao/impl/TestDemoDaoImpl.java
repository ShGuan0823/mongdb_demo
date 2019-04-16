package com.test.demo.dao.impl;

import com.test.demo.dao.TestDemoDao;
import com.test.demo.domain.TestDemo;
import javafx.scene.shape.Circle;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.swing.text.TabExpander;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Ssssg
 * @Description TODO
 * @Date 2019/4/16 9:50
 **/

@Service
public class TestDemoDaoImpl implements TestDemoDao {

    private final static String ID = "_id";

    private final static String COLLECTION = "test";

    private final static String BY = "ShGuan";

    private final static String DB = "MongoDB";

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public String save(TestDemo entity) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        entity.setDate(format.format(new Date()));
        entity.setBy(BY);
        entity.setDb(DB);
        entity.setMethod("insert");
        mongoTemplate.insert(entity, COLLECTION);
        return entity.getId();
    }

    @Override
    public Boolean remove(String id) {
//        Query query = Query.query(Criteria.where(ID).is(new ObjectId(id)));
        Query query = Query.query(Criteria.where(ID).is(id));
        if (mongoTemplate.remove(query, COLLECTION).getDeletedCount() != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean update(TestDemo entity) {
        entity.setDate(new Date().toString());
        entity.setMethod("save");
        mongoTemplate.save(entity, COLLECTION);
        return true;
    }

    /**
     * 根据id精确查找
     * @param id 主键
     * @return
     */

    @Override
    public TestDemo get(String id) {
        Query query = new Query();
        Criteria criteria = new Criteria();
//        criteria.and(ID).is(new ObjectId(id));
        criteria.and(ID).is(id);
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, TestDemo.class, COLLECTION);
    }

    @Override
    public List<TestDemo> list() {
        return mongoTemplate.findAll(TestDemo.class, COLLECTION);
    }

    @Override
    public TestDemo testGet() {
        /**
         * 连续使用两个andOperator会报错
         */
//        Criteria gt = Criteria.where("date").gt("2019-03-29 13:00");
//        Criteria lt = Criteria.where("date").lt("2019-04-17");
//        Criteria criteria = new Criteria();
//        criteria.and("method").is("save");
//        Query query = new Query(new Criteria().andOperator(gt,lt).andOperator(criteria));

        // 查询条件数组, 若能明确查询条件个数直接申请空间即可
        Criteria[] criteriaArray = {};
        // 不确定条件数量, 利用List自增作缓存, 若有明确查询条件个数无需List
        List<Criteria> criteriaList = new ArrayList<>();
        // 根据逻辑将true改成对应的判断条件
        if (true) {
            // 创建查询条件
            Criteria gt = Criteria.where("date").gt("2019-03-29 13:00");
            Criteria lt = Criteria.where("date").lt("2019-04-17");
            Criteria criteria = new Criteria();
            criteria.and("method").is("save");
            // 存入查询条件
            criteriaList.add(gt);
            criteriaList.add(lt);
            criteriaList.add(criteria);
        } else {
            // 根据逻辑放入其他条件
        }
        // 将条件放入数组
        if (criteriaList.size() > 0) {
            criteriaArray = new Criteria[criteriaList.size()];
            for (int i = 0; i < criteriaList.size(); i++) {
                criteriaArray[i] = criteriaList.get(i);
            }
        }
        // 封装进Query
        Query query = new Query();
        query.addCriteria(new Criteria().andOperator(criteriaArray));

        // 调用MongoTemplate实现多条件查询
        return mongoTemplate.findOne(query,TestDemo.class, COLLECTION);
    }


}