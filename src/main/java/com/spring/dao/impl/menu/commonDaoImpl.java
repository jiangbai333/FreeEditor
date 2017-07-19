/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dao.impl.menu;

import com.spring.dao.ifc.baseDao;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hsoft
 */
@Repository
public class commonDaoImpl implements baseDao{

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 数据库查询方法
     * @param jsonObject 以键值对形式传入sql供Sql模板文件解析执行
     *      @数据格式：{"sql":"需要执行的sql语句"}
     *      @数据格式：{"field":"要查询的字段", "table":"要查询的表名", "where":"查询语句where条件"}
     *      两种格式选择一种，这实际上是我根据上篇文章中提到的initDaoMapper.xml文件格式而定的，你也可以自己写！
     * @return List<Map<String, Object>>
     */
    @Override
    public List<Map<String, Object>> getList(JSONObject jsonObject) {
            return sqlSessionTemplate.selectList("initDaoTmep.getList", jsonObject);
    }

    /**
     * 数据库插入方法
     * @param jsonObject 以键值对形式传入sql供Sql模板文件解析执行
     *      @数据格式：{"sql":"需要执行的sql语句"}
     */
    @Override
    public void add(JSONObject jsonObject) {
            sqlSessionTemplate.insert("initDaoTmep.getList", jsonObject);
    }

    /**
     * 数据库删除方法
     * @param jsonObject 以键值对形式传入sql供Sql模板文件解析执行
     *      @数据格式：{"sql":"需要执行的sql语句"}
     */
    @Override
    public void del(JSONObject jsonObject) {
            sqlSessionTemplate.delete("initDaoTmep.getList", jsonObject);
    }
    
    /**
     * 数据库更新方法
     * @param jsonObject 以键值对形式传入sql供Sql模板文件解析执行
     *      @数据格式：{"sql":"需要执行的sql语句"}
     */
    @Override
    public void update(JSONObject jsonObject) {
            sqlSessionTemplate.update("initDaoTmep.getList", jsonObject);
    }
}
