package com.test.service.impl;

import com.test.entity.Page;
import com.test.service.IDownloadService;
import com.test.util.PageDownloadUtil;

/**
 * HttpClient页面下载实现类
 * create by 2019-12-21
 */
public class HttpClientDownloadService implements IDownloadService {
    @Override
    public Page download(String url) {
        Page page = new Page();
        page.setContent(PageDownloadUtil.getPageContent(url));
        return page;
    }

}
