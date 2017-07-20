package com.code.java.crypt;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 数据加密工具类
 * Created by 刘长申 on 2017/7/12.
 */
public class CryptEncodeUtil {
    /**
     * 对密码进行md5加密,并返回密文和salt，包含在User对象中
     * @param username 用户名
     * @param password 密码
     * @return 密文和salt
     */
    public static String md5Password(String username,String password){
        SecureRandomNumberGenerator secureRandomNumberGenerator=new SecureRandomNumberGenerator();
        //组合username,两次迭代，对密码进行加密
        String password_cipherText= new Md5Hash(password,username,1024).toBase64();
        return password_cipherText;
    }

    public static void main(String[] arg){
        System.out.println(md5Password("admin","admin"));
    }
}
