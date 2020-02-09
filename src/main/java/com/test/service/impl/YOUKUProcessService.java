package com.test.service.impl;

import com.test.entity.Page;
import com.test.service.IProcessService;
import com.test.util.HtmlUtil;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

/**
 * 优酷页面解析实现类
 * create by 2019-12-22
 */

public class YOUKUProcessService implements IProcessService {

    private String allNumberRegex = "(?<=热度 )[\\d]";

    private String parseAllNumber = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[1]/div/div/div/span/span[2]";
    private String parseCommentNumber = "//*[@id=\"BohComment\"]/div[2]/div/div/div[2]/div[1]/span";

    @Override
    public void process(Page page){
        String content = page.getContent();

        HtmlCleaner htmlCleaner = new HtmlCleaner();
        TagNode rootNode = htmlCleaner.clean(content);
        Object[] evaluateXPath = null;

        try {
            //获取热度
            String allNumber = HtmlUtil.getFieldByRegex(rootNode,parseAllNumber,allNumberRegex);
            page.setAllNumber(allNumber);
//            System.out.println("热度：" + allNumber );

            //获取评论数
            evaluateXPath = rootNode.evaluateXPath(parseCommentNumber);
            if (evaluateXPath.length > 0){
                TagNode node = (TagNode) evaluateXPath[0];
                page.setCommentNumber(node.getText().toString());
            }

            page.setSupportNumber("0");
            page.setDayNumber("0");
            page.setAgainstNumber("0");
            page.setCollectNumber("0");

        } catch (XPatherException e) {
            e.printStackTrace();
        }
    }
}
