package com.test.start;

import com.test.entity.Page;
import com.test.service.IDownloadService;
import com.test.service.IProcessService;
import com.test.service.impl.HttpClientDownloadService;
import com.test.service.impl.YOUKUProcessService;

/**
 * 电视剧爬虫执行入口类
 * create by 2019-12-21
 */

public class StartDSJCount {

    private IDownloadService downloadService;
    private IProcessService processService;

    public static void main(String[] args) {
        StartDSJCount dsj = new StartDSJCount();
        dsj.setDownloadService(new HttpClientDownloadService());
        dsj.setProcessService(new YOUKUProcessService());

        String url = "https://v.youku.com/v_show/id_XNDQyNzg0MjgzNg==.html?spm=a2h0k.11417342.soresults.dselectbutton&s=e438e14b3fa94613a1bb";
        //下载页面
        Page page = dsj.downloadPage(url);

        //解析页面
        dsj.processPage(page);
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
}
