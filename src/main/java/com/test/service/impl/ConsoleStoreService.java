package com.test.service.impl;

import com.test.entity.Page;
import com.test.service.IStoreService;

/**
 * @Author: lirt
 * @Description: 存储实现类
 * @Date: 2020-2-9 下午 6:07
 */
public class ConsoleStoreService implements IStoreService {
    @Override
    public void store(Page page) {
        System.out.println("热度：" + page.getAllNumber() );
        System.out.println("评论数：" + page.getCommentNumber() );
        System.out.println("赞数：" + page.getSupportNumber() );
        System.out.println("每日播放量：" + page.getDayNumber() );
        System.out.println("踩数：" + page.getAgainstNumber() );
        System.out.println("收藏数：" + page.getCollectNumber() );
    }
}
/**
 * 2 * @Author:
 * 3 * @Date: 2020-2-9 下午 6:07
 * 4 * @Param:
 * 5 * @return:
 * 6
 */
