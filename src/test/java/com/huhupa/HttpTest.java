package com.huhupa;

import com.huhupa.common.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

public class HttpTest {

    public static void main(String[] args) throws Exception{
        Map<String, String> params = new HashMap<String, String>();
        params.put("info", "明天天气");
        params.put("loc", "深圳市龙华区");
        params.put("userid", "222");
        params.put("appkey", "ea3a0f225fd886c15d036c3535f74d4a");
        Map<String, String> headers = new HashMap<String, String>();
        String respStr = HttpUtils.sendPostRequest("https://way.jd.com/turing/turing", params, headers);
        System.out.println(respStr);
//        URL url = new URL("https://way.jd.com/turing/turing");
//        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//        conn.setRequestMethod("POST");
//        conn.setDoOutput(true);
//        StringBuilder params = new StringBuilder();
//        params.append("info=").append("今晚打老虎")
//                .append("&loc=").append("深圳市龙华区")
//                .append("&userid=").append("222")
//                .append("&appkey=").append("ea3a0f225fd886c15d036c3535f74d4a");
//        conn.getOutputStream().write(params.toString().getBytes("UTF-8"));
//        conn.connect();
//        String respStr = StreamUtils.copyToString(conn.getInputStream(), Charset.forName("UTF-8"));
//        System.out.println(respStr);
    }
}
