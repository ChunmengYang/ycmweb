package ycm.security;

import java.util.Map;
import java.util.Base64;

public class RSATest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        //生成密钥对
        Map<String,byte[]> keyMap = RSAProvider.initKey(1024);
        //公钥
        byte[] publicKey = keyMap.get(RSAProvider.PUBLIC_KEY);
        
        //私钥
        byte[] privateKey = keyMap.get(RSAProvider.PRIVATE_KEY);
        

        System.out.println("公钥：\n" + Base64.getEncoder().encodeToString(publicKey));
        System.out.println("私钥：\n" + Base64.getEncoder().encodeToString(privateKey));
        
        System.out.println("\n\n================密钥对构造完毕,甲方将公钥公布给乙方，开始进行加密数据的传输=============");
        
        System.out.println("===========甲方向乙方发送加密数据=============="); 
        String str = "RSA密码交换算法";
        System.out.println("原文:" + str);
        //甲方进行数据的加密
        byte[] code1 = RSAProvider.encryptByPrivateKey(str.getBytes(), privateKey);
        System.out.println("加密后的数据：\n" + Base64.getEncoder().encodeToString(code1));
        
        System.out.println("===========乙方使用甲方提供的公钥对数据进行解密==============");
        //乙方进行数据的解密
        byte[] decode1 = RSAProvider.decryptByPublicKey(code1, publicKey);
        System.out.println("乙方解密后的数据：" + new String(decode1));
     
        
        System.out.println("\n\n===========反向进行操作，乙方向甲方发送数据==============");
        str = "乙方向甲方发送数据RSA算法";
        System.out.println("原文:"+str);
        
        //乙方使用公钥对数据进行加密
        byte[] code2 = RSAProvider.encryptByPublicKey(str.getBytes(), publicKey);
        String sha1Str = RSAProvider.digestSHA1(str.getBytes());
        System.out.println("SHA1数字签名：\n" + sha1Str);
        String md5Str = RSAProvider.digestMD5(str.getBytes());
        System.out.println("MD5数字签名：\n" + md5Str);
        System.out.println("===========乙方使用公钥对数据进行加密==============");
        System.out.println("加密后的数据：\n" + Base64.getEncoder().encodeToString(code2));
        
        System.out.println("===========甲方使用私钥对数据进行解密==============");
        //甲方使用私钥对数据进行解密
        byte[] decode2=RSAProvider.decryptByPrivateKey(code2, privateKey); 
        System.out.println("甲方解密后的数据："+new String(decode2));
	}

}
