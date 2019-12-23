package com.test.service.impl;

import com.test.entity.Page;
import com.test.service.IProcessService;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

/**
 * 优酷页面解析实现类
 * create by 2019-12-22
 */

public class YOUKUProcessService implements IProcessService {
    @Override
    public void process(Page page){
        String content = page.getContent();

        HtmlCleaner htmlCleaner = new HtmlCleaner();
        TagNode rootNode = htmlCleaner.clean(content);

        try {
            Object[] evaluateXPath = rootNode.evaluateXPath("//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/div[1]/div/div/div/span/span[2]");
            if(evaluateXPath.length > 0){
                TagNode node = (TagNode) evaluateXPath[0];
                System.out.println(node.getText().toString());
            }

        } catch (XPatherException e) {
            e.printStackTrace();
        }

    }
}
