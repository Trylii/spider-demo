package com.test.start;

import com.test.entity.Page;
import com.test.service.IDownloadService;
import com.test.service.IProcessService;
import com.test.service.IStoreService;
import com.test.service.impl.ConsoleStoreService;
import com.test.service.impl.HttpClientDownloadService;
import com.test.service.impl.YOUKUProcessService;

/**
 * 电视剧爬虫执行入口类
 * create by 2019-12-21
 */

public class StartDSJCount {

    private IDownloadService downloadService;
    private IProcessService processService;
    private IStoreService storeService;

    public static void main(String[] args) {
        StartDSJCount dsj = new StartDSJCount();
        dsj.setDownloadService(new HttpClientDownloadService());
        dsj.setProcessService(new YOUKUProcessService());
        dsj.setStoreService(new ConsoleStoreService());

        String url = "https://v.youku.com/v_show/id_XNDUxOTQ2NDgwMA==.html?spm=a2hcb.12523948.m_5295_c_12649.d_1&s=2bd6c44166b74ebfb2b5&scm=20140719.rcmd.5295.show_2bd6c44166b74ebfb2b5";
        //下载页面
        Page page = dsj.downloadPage(url);

        //解析页面
        dsj.processPage(page);

        //页面信息存储
        dsj.storePage(page);


    }

    /**
     * 页面下载
     * @param url
     * @return
     */
    public Page downloadPage(String url){
        return this.downloadService.download(url);
    }

    /**
     * 页面解析
     * @param page
     */
    public void processPage(Page page){
        this.processService.process(page);
    }

    /**
     * 信息存储
     * @param page
     */
    public void storePage(Page page){
        this.storeService.store(page);
    }

    public IDownloadService getDownloadService() {
        return downloadService;
    }

    public void setDownloadService(IDownloadService downloadService) {
        this.downloadService = downloadService;
    }

    public IProcessService getProcessService() {
        return processService;
    }

    public void setProcessService(IProcessService processService) {
        this.processService = processService;
    }

    public IStoreService getStoreService() {
        return storeService;
    }

    public void setStoreService(IStoreService storeService) {
        this.storeService = storeService;
    }
}
