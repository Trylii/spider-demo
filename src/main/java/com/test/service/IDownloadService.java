package com.test.service;

import com.test.entity.Page;

/**
 * 页面下载接口
 * create by 2019-12-21
 */

public interface IDownloadService {
    public Page download(String url);
}
