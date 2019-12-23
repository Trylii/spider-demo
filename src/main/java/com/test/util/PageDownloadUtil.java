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
        String url = "https://v.youku.com/v_show/id_XNDQyNzg0MjgzNg==.html?spm=a2h0k.11417342.soresults.dselectbutton&s=e438e14b3fa94613a1bb";
        HttpClientDownloadService down = new HttpClientDownloadService();
        Page page = down.download(url);
        System.out.println(page.getContent());
    }
}
