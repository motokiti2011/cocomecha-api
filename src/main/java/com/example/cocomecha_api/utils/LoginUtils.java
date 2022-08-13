package com.example.cocomecha_api.utils;

import java.util.Base64;

public class LoginUtils {

  /**
   * ログイン情報(encode)からログインID、パスワードを取得する
   * @param bytecode
   * @return
   */
  public String[] getCertificationInfo(String bytecode) {
    String[] hoge= new String[2];
    if(bytecode == null){
      return hoge;
    }

    System.out.println("デコード10:"+bytecode);
    //「Basic encode情報」の形式のため先頭と半角スペースを取り除く
    String code = bytecode.replace("Basic ", "");
    
    System.out.println("デコード11:"+code);
    // デコード
    String loginPassWd = new String(Base64.getDecoder().decode(code));

    System.out.println("デコード後12:"+loginPassWd);
    // loginID : password　形式のため分割して返却
    return loginPassWd.split(":");
  }
  
}
