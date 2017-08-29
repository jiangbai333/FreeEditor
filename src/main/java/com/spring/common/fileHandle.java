/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.common;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author 姜柏超
 */
public final class fileHandle {
    
    /**
     * 获取目录树
     * @param path 获取路径
     * @return 目录列表
     * @throws IOException
     */
    public static List directoryTree(String path) throws IOException {
        File fp //通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例
                = new File(path);
        
        return buildTree(fp);
    }
    
    /**
     * 构建文件结构树
     * @param file
     * @return
     * @throws IOException 
     */
    private static List buildTree(File file) throws IOException {
        
        List rt
                = new ArrayList();
        File[] fileList
                = file.listFiles();
        
        for ( File tempFile : fileList ) {
            
            Map tempFileMap
                    = new HashMap();
            
            if ( tempFile.isDirectory() ) {
                tempFileMap.put("type", "dir");
                tempFileMap.put("child", buildTree(tempFile));
            } else {
                tempFileMap.put("type", "file");
            }
            
            tempFileMap.putAll(buildFileInfo(tempFile));
            
            rt.add(tempFileMap);
        } 
        return rt;
    }
    
    /**
     * 构建文件基本信息
     * @param file File 实例
     * @return Map 文件基本信息
     * @throws IOException 
     */
    private static Map buildFileInfo(File file) throws IOException {
        Map rt //返回值 Map
                = new HashMap();
        
        rt.put("name", file.getName());
        rt.put("path", regHandle.replacec(file.getAbsolutePath(), ".*src", "src"));
        rt.put("size", file.length());
        rt.put("lastChangeTime", file.lastModified());
        
        return rt;
    }
}
