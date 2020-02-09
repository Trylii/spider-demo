package com.test.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: lirt
 * @Description: 正则表达式工具类
 * @Date: 2020-2-7 下午 8:00
 */
public class RegexUtil {

    public static String getPageInfoByRegex(String content, Pattern pattern, int groupNo){
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()){
            return matcher.group(groupNo).trim();
        }
        return "0";
    }
}
/**
 * 2 * @Author:
 * 3 * @Date: 2020-2-7 下午 8:00
 * 4 * @Param:
 * 5 * @return:
 * 6
 */
