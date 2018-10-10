package com.huhupa;

import com.huhupa.base.entity.User;
import com.huhupa.common.utils.AESUtils;

public class AESTest {
    
    public static void main(String[] args){
        test1();
    }
    public static void test1(){
        String secret = "abcd1234";
        User user = new User();
        user.setPassword("asdf");
        user.setUserName("admin");
        user.setNickName("你才回鞥");
        user.setAddress("有个地址");
        user.setEmail("90443@sangfor.com");
        String value = "{\"name\":\"杜顶替一\",\"analysis_id\":\"1\",\"description\":\"埂夺下压一\"}";
        String encrypt = AESUtils.encrypt(secret, user.toString());
        System.out.println("加密串："+user.toString());
        System.out.println("加密后："+encrypt);
        System.out.println("加密后："+encrypt.length());
        String decrypt = AESUtils.decrypt(secret, encrypt);
        System.out.println("解密后："+decrypt);
    }
}
