/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller.menu;

import com.spring.service.impl.menu.menuService;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author hsoft
 */

@Controller
@RequestMapping(value="/menu")
public class menuController {
    
    @Autowired
    private HttpSession session;
    
    @Autowired
    private menuService service;
    
    @RequestMapping(value="/getMenuList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getMenuList(){
        return new JSONObject().accumulate("key", "中文").toString();
    }
}
