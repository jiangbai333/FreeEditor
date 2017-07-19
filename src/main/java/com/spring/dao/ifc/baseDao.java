/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dao.ifc;

import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;

/**
 *
 * @author hsoft
 */
public interface baseDao {
    /**
     * 数据库查询方法
     * @param jsonObject 以键值对形式传入sql供Sql模板文件解析执行
     *      @数据格式：{"sql":"需要执行的sql语句"}
     *      @数据格式：{"field":"要查询的字段", "table":"要查询的表名", "where":"查询语句where条件"}
     *      两种格式选择一种，这实际上是我根据上篇文章中提到的initDaoMapper.xml文件格式而定的，你也可以自己写！
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> getList(JSONObject jsonObject);
    
    /**
     * 数据库插入方法
     * @param jsonObject 以键值对形式传入sql供Sql模板文件解析执行
     *      @数据格式：{"sql":"需要执行的sql语句"}
     */
    public void add(JSONObject jsonObject);
    
    /**
     * 数据库删除方法
     * @param jsonObject 以键值对形式传入sql供Sql模板文件解析执行
     *      @数据格式：{"sql":"需要执行的sql语句"}
     */
    public void del(JSONObject jsonObject);
    
    /**
     * 数据库删除方法
     * @param jsonObject 以键值对形式传入sql供Sql模板文件解析执行
     *      @数据格式：{"sql":"需要执行的sql语句"}
     */
    public void update(JSONObject jsonObject);
}
