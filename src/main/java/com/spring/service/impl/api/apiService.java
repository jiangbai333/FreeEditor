/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.service.impl.api;

import com.spring.common.excelUtil;
import com.spring.dao.impl.menu.commonDaoImpl;
import com.spring.service.ifc.baseService;
import java.io.IOException;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hsoft
 */
@Service
public class apiService implements baseService {
    
    @Autowired
    private commonDaoImpl daoHand;
    
    public List<List<String>> getExcelData(String path) throws IOException {
        return excelUtil.getList(path);
    }
    
    public void updataPoint(JSONArray jr) throws IOException {
        JSONObject jo = new JSONObject();
        jo.accumulate("sql", "update hsoft_map_block set hosuepoint='" + jr.getString(1) + "' where id=" + jr.getString(0));
        System.out.println("update hsoft_map_block set schoolpoint='" + jr.getString(1) + "' where id=" + jr.getString(0));
        daoHand.update(jo);
    }
    
    public String getAvg() throws IOException {
        JSONObject jo = new JSONObject();
        jo.accumulate("sql", "SELECT a.schoolblock, AVG(a.hosueprice) AS hosueprice, b.name, b.points, b.center, count(schoolblock) as num FROM hsoft_map_block a, hsoft_map_district b WHERE a.hosueprice != 0 AND a.schoolpoint IS NOT NULL AND a.hosuepoint IS NOT NULL AND a.schoolblock = b.id GROUP BY a.schoolblock");

        return (JSONArray.fromObject(daoHand.getList(jo))).toString();
    }
    
    public String getSchoolAvg(String data) throws IOException {
        JSONObject jo = new JSONObject();
        jo.accumulate("sql", "SELECT id, AVG(hosueprice) AS hosueprice,schoolname as name,schoolpoint as center,count(schoolname) AS num FROM hsoft_map_block WHERE hosueprice != 0 AND schoolpoint IS NOT NULL AND hosuepoint IS NOT NULL AND schoolblock = " + data + " GROUP BY schoolname");

        return (JSONArray.fromObject(daoHand.getList(jo))).toString();
    }
    
    public String getHouse(String data) throws IOException {
        JSONObject jo = new JSONObject();
        jo.accumulate("sql", "SELECT id,hosueprice, housename, hosuepoint FROM hsoft_map_block WHERE hosueprice != 0 AND schoolpoint IS NOT NULL AND hosuepoint IS NOT NULL AND schoolname = (select schoolname from hsoft_map_block where id = " + data + ")");

        return (JSONArray.fromObject(daoHand.getList(jo))).toString();
    }
}
