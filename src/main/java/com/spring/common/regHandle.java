/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hsoft
 */
public final class regHandle {
    
    /**
     * 使用正则替换字符串
     * @param rlcStr 将要被替换的字符串
     * @param regStr 将要被匹配的字符串
     * @param rpeStr 将要替换为的字符串
     * @return String 替换完成后的字符串
     */
	public static String replacec(String rlcStr, String regStr, String rpeStr) {
        
        Pattern pn
                = Pattern.compile(regStr);
        Matcher mc
                = pn.matcher(rlcStr);
        
        return mc.replaceAll(rpeStr);
	}
}
