package com.spring.controller.api;

import com.filehandle.FileHandle;
import com.spring.service.impl.api.apiService;

import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author hsoft
 */

@Controller
@RequestMapping(value="/api")
public class apiController {
    
    @Autowired
    private apiService service;
    
    @RequestMapping(value="/getFiles", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getFiles() throws IOException{
        JSONArray jr = JSONArray.fromObject(FileHandle.fromObject("C:\\Users\\hsoft\\Desktop\\SpringMVC\\src").tree());
        
        return jr.toString();
    }

    @RequestMapping(value="/testData", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getMenuList(){
        return new JSONObject().accumulate("key", "中文").toString();
    }
    
    @RequestMapping(value="/getExcelData", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getExcelData() throws IOException{
        String rt = JSONArray.fromObject(service.getExcelData("C:/Users/hsoft/Desktop/学校对应小区房价.xlsx")).toString();
        return rt; 
    }
    
    @RequestMapping(value="/updatePoint/", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String updatePoint(@RequestParam("data") String data) throws IOException{
        service.updataPoint(JSONArray.fromObject(data));
        return null; 
    }
    
    @RequestMapping(value="/getAvg", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String updatePoint() throws IOException{
        return service.getAvg(); 
    }
    
    @RequestMapping(value="/getSchoolAvg", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getSchoolAvg(@RequestParam("data") String data) throws IOException{
        return service.getSchoolAvg(data); 
    }
    
    @RequestMapping(value="/getHouse", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getHouse(@RequestParam("data") String data) throws IOException{
        return service.getHouse(data); 
    }
    
    @RequestMapping(value="/getScript", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getScript(@RequestParam("data") String data) throws IOException{
        return data; 
    }
    
    @RequestMapping(value="/testApi", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String testApi() throws IOException{
        return "aaa"; 
    }
}
