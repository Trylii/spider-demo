package com.test.util;

import com.test.entity.Page;
import com.test.service.impl.HttpClientDownloadService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 页面下载工具类
 *
 * create by 2019-12-21
 */
public class PageDownloadUtil {

    public static String getPageContent(String url){
        HttpClientBuilder builder = HttpClients.custom();
        CloseableHttpClient client = builder.build();

        HttpGet request = new HttpGet(url);
        String content = null;
        try {
            CloseableHttpResponse respose = client.execute(request);
            HttpEntity entity =  respose.getEntity();
            content = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void main(String[] args) {
        String url = "https://v.youku.com/v_show/id_XNDUxOTQ2NDgwMA==.html?spm=a2hcb.12523948.m_5295_c_12649.d_1&s=2bd6c44166b74ebfb2b5&scm=20140719.rcmd.5295.show_2bd6c44166b74ebfb2b5";
        HttpClientDownloadService down = new HttpClientDownloadService();
        Page page = down.download(url);
        System.out.println(page.getContent());
    }
}
