package com.test.util;

import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import java.util.regex.Pattern;

/**
 * @Author: lirt
 * @Description: 页面解析工具类
 * @Date: 2020-2-7 下午 8:24
 */
public class HtmlUtil {

    public static String getFieldByRegex(TagNode rootNode, String xPath, String regex){
        String number = "0";
        Object[] evaluateXPath = null;

        try {
            evaluateXPath = rootNode.evaluateXPath(xPath);
            if (evaluateXPath.length > 0){
                TagNode node = (TagNode) evaluateXPath[0];
                Pattern numberPatten = Pattern.compile(regex, Pattern.DOTALL);
                number = RegexUtil.getPageInfoByRegex(node.getText().toString(), numberPatten, 0);
            }
        } catch (XPatherException e) {
            e.printStackTrace();
        }

        return number;
    }
}
/**
 * 2 * @Author:
 * 3 * @Date: 2020-2-7 下午 8:24
 * 4 * @Param:
 * 5 * @return:
 * 6
 */
