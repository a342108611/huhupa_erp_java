package com.huhupa;

import com.huhupa.common.mail.MailService;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public class EmailTest {

    public static void main(String[] args){
        testSendMail();
    }
    public static void testSendMail(){
        String to = "342108611@qq.com";
        String sbjuct = "测试发送一疯邮件";
        String html = "<a href='www.huhupa.com'>呼呼爬</a>";
        try {
            MailService.sendHtmlMail(to, sbjuct, html);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
