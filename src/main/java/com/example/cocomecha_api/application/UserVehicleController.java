package com.example.cocomecha_api.application;

import com.example.cocomecha_api.domain.model.UserVehicle;
import com.example.cocomecha_api.domain.service.UserVehicleService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

// import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(path = "/v1/user_vehicle")
public class UserVehicleController {

    @NonNull
    @Autowired
    private final UserVehicleService userVehicleService;


    /**
     * ユーザーidをキーとしてユーザー情報を取得する
     * @param userId
     * @return userVehicle
     */
    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserVehicle> findById(@PathVariable("userId") Integer userId) {
        return this.userVehicleService.findById(userId);
    }

    /**
     * ユーザー情報を登録する
     * @param userId
     * @return userVehicle
     */
    @RequestMapping(value="/userpost",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
    // JSONマッピング用に作成したBeanクラスを指定する
    public UserVehicle postUser(@RequestBody UserVehicle userVehicle) {
        // ObjectMapper objectMapper = new ObjectMapper();
        return this.userVehicleService.postUser(userVehicle);
    }

    /**
     * ユーザー情報を更新する
     * @param userId
     * @return userVehicle
     */
    @RequestMapping(value="/{userId}", method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE )
    public UserVehicle putUser(@PathVariable("userId") Integer userId, @RequestBody UserVehicle userVehicle) {
        // 更新対象確認
        if(this.userVehicleService.findById(userVehicle.getUserId()).size() > 0 ) {
          userVehicle.setUserId(userId);
            return this.userVehicleService.putUser(userVehicle);
        }
        return userVehicle;
    }

    /**
     * ユーザー情報を削除
     * @param userId
     * @return user
     */
    @RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable("userId") Integer userId) {
        this.userVehicleService.deleteUser(userId);
    }


    @RequestMapping(value="/user_vehicle_get", method=RequestMethod.GET)
    public List<UserVehicle> getUserAll() {
        return this.userVehicleService.getUserAll();
    }
  
}
