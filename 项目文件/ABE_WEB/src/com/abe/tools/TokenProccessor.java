package com.abe.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import sun.misc.BASE64Encoder;

/**
 * 张顺 2016-11-14
 * <br>令牌生成工具,用于防止表单重复提交
 * @author 张顺
 */
public class TokenProccessor {

    /*
     *单例设计模式（保证类的对象在内存中只有一个）
     *1、把类的构造函数私有
     *2、自己创建一个类的对象
     *3、对外提供一个公共的方法，返回类的对象
     */
    private TokenProccessor(){}
    
    private static final TokenProccessor instance = new TokenProccessor();
    
    /**
     * 返回类的对象
     * @return
     */
    public static TokenProccessor getInstance(){
        return instance;
    }
    
    /**
     * 生成Token
     * Token：Nv6RRuGEVvmGjB+jimI/gw==
     * @return
     */
    public String makeToken(){  //checkException
        //  7346734837483  834u938493493849384  43434384
        String token = ((System.currentTimeMillis()/(1000*60*60*24) + new Random().nextInt(999))) + "";
        //数据指纹   128位长   16个字节  md5
        /*为什么不用下面这个更加复杂更加不可能重复的呢？因为session加载效率太低，长字符串往往加载很慢，无奈之下只得精简。（张顺 2016-12-14）
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] =  md.digest(token.getBytes());
            //base64编码--任意二进制编码明文字符   adfsdfsdfsf
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        */
        return token;
    }
}