package com.leyou.demo;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;


public class Main {

    public static void main(String[] args) {
        //DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIM8x6sYDGGji7", "hjoXJckFuZOeDj61vSjLMifenDDT8y");
        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIM8x6sYDGGji7", "hjoXJckFuZOeDj61vSjLMifenDDT8y");

        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "default");
        request.putQueryParameter("SignName", "Jason乐友商城");
        request.putQueryParameter("TemplateCode", "SMS_172888818");


        //其他是固定用法： 下面是要发送的  手机号 和 code
        request.putQueryParameter("PhoneNumbers", "17864280604");
        request.putQueryParameter("TemplateParam", "{\"code\":\"5136\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
