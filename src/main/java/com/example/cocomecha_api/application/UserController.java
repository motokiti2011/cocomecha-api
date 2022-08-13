package com.example.cocomecha_api.application;

import com.example.cocomecha_api.domain.model.UserDetail;
// import com.example.cocomecha_api.domain.model.SignUpUser;
import com.example.cocomecha_api.domain.service.UserDetailService;
// import com.example.cocomecha_api.domain.service.LoginService;
// import com.example.cocomecha_api.utils.UserUtils;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(path = "/v1/users")
public class UserController {

    @NonNull
    @Autowired
    private final UserDetailService userService;

    // @Autowired
    // private final LoginService loginService;

    // private UserUtils userUtils;

    /**
     * ユーザーidをキーとしてユーザー情報を取得する
     * @param user_id
     * @return user
     */
    @GetMapping("/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDetail> findById(@PathVariable("user_id") Integer user_id) {
        return this.userService.findById(user_id);
    }

    /**
     * ユーザー情報を登録する
     * @param user_id
     * @return user
     */
    // @RequestMapping(value="/userpost",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
    // // JSONマッピング用に作成したBeanクラスを指定する
    // public UserDetail postUser(@RequestBody SignUpUser signUpUserInfo) {
    //     // 新規ユーザー登録情報にログイン関連の情報も含まれるので分割する
    //     System.out.println("log1ユーザー:"+signUpUserInfo);
    //     // UserDetail signUpuser = userUtils.SignUpUserInfo(signUpUserInfo);
    //     // System.out.println("log2ユーザー:"+signUpuser);
    //     // ユーザー情報を登録（登録時にユーザーIDが発行される）
    //     // UserDetail user = this.userService.postUser(signUpuser);
    //     System.out.println("log3ユーザー:"+user);
    //     // ログイン情報を取得
    //     // this.loginService.postLogin(this.userUtils.SignUpLogin(signUpUserInfo, user.getUser_id()));
    //     return user;
    // }

    /**
     * ユーザー情報を更新する
     * @param user_id
     * @return user
     */
    @RequestMapping(value="/{user_id}", method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE )
    public UserDetail putUser(@PathVariable("user_id") Integer user_id, @RequestBody UserDetail user) {
        // 更新対象確認
        if(this.userService.findById(user.getUser_id()).size() > 0 ) {
            user.setUser_id(user_id);
            return this.userService.putUser(user);
        }
        return user;
    }

    /**
     * ユーザー情報を削除
     * @param user_id
     * @return user
     */
    @RequestMapping(value = "{user_id}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable("user_id") Integer user_id) {
        this.userService.deleteUser(user_id);
    }


    @RequestMapping(value="/userget", method=RequestMethod.GET)
    public List<UserDetail> getUserAll() {
        return this.userService.getUserAll();
    }
  
}
