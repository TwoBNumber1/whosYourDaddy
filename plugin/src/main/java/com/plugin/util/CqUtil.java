package com.plugin.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.plugin.entity.CqMessage;
import com.plugin.entity.CqResponse;
import com.plugin.entity.ResponseData;

import org.springframework.stereotype.Component;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//将CQ的HTTP API封装为接口，并托管到Spring
@Component
public class CqUtil {
    private final String baseURL = "http://localhost:5700";
    
    public CqResponse sendMsg(CqMessage cqMessage) {
        String URL;
        switch (cqMessage.getMessageType()) {
            case "group":
                URL = baseURL + "/send_group_msg";
                break;
            case "private":
                URL = baseURL + "/send_private_msg";
                break;
            case "smoke":
                URL = baseURL + "/set_group_ban";
                break;
            case "handleInvite":
                URL = baseURL +"/set_group_add_request";
                break;
            default:
                return null;
        }
        return sendHttpRequest(cqMessage, URL);

    }

    /**
     * 通过URL和cqMessage发送请求
     * @param cqMessage
     * @param URL
     * @return
     */
	private CqResponse sendHttpRequest(CqMessage cqMessage, String URL) {
		HttpURLConnection httpConnection;
        try {
            httpConnection =
                    (HttpURLConnection) new URL(URL).openConnection();
            httpConnection.setRequestMethod("POST");
            //接收和发送的报文体都是json对象
            httpConnection.setRequestProperty("Accept", "application/json");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            httpConnection.setDoOutput(true);

            OutputStream os = httpConnection.getOutputStream();
            //防止转义
            //折腾了半天最后是少了UTF-8………………我tm想给自己一巴掌
            //插件建议使用json对象传入
            os.write(new GsonBuilder().disableHtmlEscaping().create().toJson(cqMessage).getBytes("UTF-8"));
            os.flush();
            os.close();
            BufferedReader responseBuffer =
                    new BufferedReader(new InputStreamReader((httpConnection.getInputStream())));
            StringBuilder tmp2 = new StringBuilder();
            String tmp;
            while ((tmp = responseBuffer.readLine()) != null) {
                tmp2.append(tmp);
            }
            return new Gson().fromJson(tmp2.toString(), CqResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}
    
    /**
     * 该方法里的http请求不需要添加参数 但有返回数据
     * @param param
     */
    public CqResponse<ResponseData> sendMsgWithoutParam(String param) {
    	
    	String URL="";
    	switch (param) {
    	//获取登录到Coolq的账号信息
		case "getLoginInfo":
			URL = baseURL + "/get_login_info";
			break;
			//获取http插件的版本信息
		case "getVersionInfo":
			URL = baseURL + "/get_version_info";
			break;
			//获取插件运行状态
		case "getStatus" :
			URL = baseURL + "/get_status";
			break;
		case "getToken":
			URL = baseURL + "/get_csrf_token";
			break;
		default:
			
			break;
		}
    	return sendHttpRequest(null, URL);
    	
    }
    
 
}
