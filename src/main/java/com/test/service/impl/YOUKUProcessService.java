package com.test.service.impl;

import com.test.entity.Page;
import com.test.service.IProcessService;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

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
    }
}
