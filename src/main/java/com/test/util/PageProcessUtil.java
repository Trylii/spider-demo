package com.test.util;

import com.test.entity.Page;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

/**
 * @Author:
 * @Date: 2019-12-25 上午 10:01
 * @Param:
 * @return:
 */
public class PageProcessUtil {
    public void ProcessPage(Page page,String xPathExpression){
        String content = page.getContent();

        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode node = cleaner.clean(content);

        try {
            Object[] number = node.evaluateXPath(xPathExpression);
            if (number.length > 0 ){
                TagNode tagNode = (TagNode) number[0];
            }
        } catch (XPatherException e) {
            e.printStackTrace();
        }
    }
}