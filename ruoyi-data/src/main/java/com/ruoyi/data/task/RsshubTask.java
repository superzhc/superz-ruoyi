package com.ruoyi.data.task;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.data.domain.TRsshub;
import com.ruoyi.data.service.ITRsshubService;
import com.ruoyi.data.utils.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author superz
 * @create 2023/5/10 9:30
 **/
@Component("rsshubTask")
public class RsshubTask {
    private static final Logger LOG = LoggerFactory.getLogger(RsshubTask.class);

    @Autowired
    private ITRsshubService rsshubService;

    public void fetch(String path) {
        String baseUrl = "https://rsshub.app";
        String url = String.format("%s/%s.json", baseUrl, path);

        String result = HttpRequest.get(url)
                .useProxy("127.0.0.1", 10809)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36")
                .body();
        LOG.info(result);

        JSONObject json = JSON.parseObject(result);
        String type = json.getString("title");

        JSONArray items = json.getJSONArray("items");
        for (int i = 0, len = items.size(); i < len; i++) {
            JSONObject item = items.getJSONObject(i);

            TRsshub entity = new TRsshub();
            entity.setGuid(item.getString("id"));
            entity.setTitle(item.getString("title"));
            entity.setContent(item.getString("content_html"));
            entity.setPublishDate(item.getDate("date_published"));
            entity.setLink(item.getString("url"));
            entity.setType(type);

            JSONArray authors = item.getJSONArray("authors");
            if (null != authors && authors.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < authors.size(); j++) {
                    sb.append(',').append(authors.getJSONObject(j).getString("name"));
                }
                entity.setAuthor(sb.substring(1));
            }

            // 没做数据去重操作
            rsshubService.insertTRsshub(entity);
        }
    }
}
