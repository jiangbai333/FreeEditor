/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.service.impl.menu;

import com.spring.dao.impl.menu.commonDaoImpl;
import com.spring.service.ifc.baseService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hsoft
 */
@Service
public class menuService implements baseService {
    @Autowired
    private commonDaoImpl daoHand;
    
    public String getMenuList() {
        JSONObject jo = new JSONObject();
        jo.accumulate("sql", "select * from menu");
        JSONArray jr = JSONArray.fromObject(daoHand.getList(jo));
        return jr.toString();
    }
}
