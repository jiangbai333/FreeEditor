package com.spring.controller.view;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hsoft
 */
@Controller
@RequestMapping(value = "/display")
public class viewController {

    @Autowired
    private HttpSession session;

    /**
     * 渲染视图
     *
     * @param group 视图分组：指在page目录下的某一个分组目录
     * @param viewName 视图名：要渲染的视图文件名
     * 若要渲染page/menu目录下的view视图，则url为：/display/menu-view/
     * 若直接渲染page目录下的view视图，则url为：/display/-view/
     * @return
     */
    @RequestMapping(value = "/{group}-{view}", method = RequestMethod.GET)
    public String display(@PathVariable("group") String group, @PathVariable("view") String viewName) {

        session.setAttribute("user", "aaa");
        System.out.println("进入控制器");
        return group + "/" + viewName;
    }    
}
