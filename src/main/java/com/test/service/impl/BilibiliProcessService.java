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

public class BilibiliProcessService implements IProcessService {
    @Override
    public void process(Page page){
        String content = page.getContent();

        HtmlCleaner htmlCleaner = new HtmlCleaner();
        TagNode rootNode = htmlCleaner.clean(content);

        try {
            Object[] number = rootNode.evaluateXPath("//*[@id=\"bili_report_live\"]/div[1]/header/div[1]/div/span");
            if(number.length > 0){
                TagNode node = (TagNode) number[0];
                System.out.println(node);
            }
        } catch (XPatherException e) {
            e.printStackTrace();
        }
    }
}
