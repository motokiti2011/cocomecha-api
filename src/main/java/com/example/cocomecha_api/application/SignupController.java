package com.example.cocomecha_api.application;


// import com.example.cocomecha_api.domain.model.UserDetail;
// import com.example.cocomecha_api.domain.model.SignUpUser;
import com.example.cocomecha_api.domain.service.UserDetailService;
// import com.example.cocomecha_api.domain.service.LoginService;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
// import org.springframework.http.MediaType;



@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(path = "/signup")
public class SignupController {
  @NonNull
  @Autowired
  private final UserDetailService userService;

  // @Autowired
  // private final LoginService loginService;



    /**
     * 新規ユーザー情報を登録する
     * @param user_id
     * @return user
     */
    // @RequestMapping(value="/signupuseuser",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
    // // JSONマッピング用に作成したBeanクラスを指定する
    // public UserDetail postUser(@RequestBody SignUpUser signUpUserInfo) {
    //     // 新規ユーザー登録情報にログイン関連の情報も含まれるので分割する
    //     System.out.println("log1ユーザー:"+signUpUserInfo);
    //     UserDetail signUpuser = userUtils.SignUpUserInfo(signUpUserInfo);
    //     System.out.println("log2ユーザー:"+signUpuser);
    //     // ユーザー情報を登録（登録時にユーザーIDが発行される）
    //     UserDetail user = this.userService.postUser(signUpuser);
    //     System.out.println("log3ユーザー:"+user);
    //     // ログイン情報を取得
    //     // this.loginService.postLogin(this.userUtils.SignUpLogin(signUpUserInfo, user.getUser_id()));
    //     return user;
    // }
  
}
