package com.example.cocomecha_api.application;

import com.example.cocomecha_api.domain.model.UserMyList;
import com.example.cocomecha_api.domain.service.UserMyListService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

// import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(path = "/v1/usermylist")
public class UserMyListController {

    @NonNull
    @Autowired
    private final UserMyListService userMyListService;

    /**
     * idをキーとしてお気に入り情報を取得する
     * 
     * @param id
     * @return userFavorite
     */
    @GetMapping("usermylist/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserMyList> findById(@PathVariable("id") String id) {
        return this.userMyListService.findById(id);
    }

    /**
     * ユーザーIDをキーとして閲覧履歴情報を取得する
     * 
     * @param id
     * @return userFavorite
     */
    @GetMapping("getuserbymylist/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserMyList> findByUser_Id(@PathVariable("userId") String userId) {
        System.out.println("引数" + userId);
        List<UserMyList> resultList = new ArrayList<UserMyList>();
        // 伝票情報を取得しエリア情報で絞り込みを行う
        List<UserMyList> userMyList = this.userMyListService.findAll();
        userMyList.stream()
                .filter(fav -> fav.getUserId().equals(userId))
                .forEach(fav -> resultList.add(fav));

        System.out.println("UserMyList:初期データ：" + userMyList.size());
        System.out.println("UserMyList:返却件数：" + resultList.size());

        return resultList;
    }

    /**
     * お気に入り情報を登録する
     * 
     * @param id
     * @return userFavorite
     */
    @RequestMapping(value = "/postmylist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    // JSONマッピング用に作成したBeanクラスを指定する
    public UserMyList postUser(@RequestBody UserMyList userMyList) {
        System.out.println("マイリスト1:"+userMyList);
        List<UserMyList> list = this.userMyListService.findAll();
        System.out.println("マイリスト1.5:"+list);
        int Numbering = list.size();
        // 採番
        userMyList.setId(String.valueOf(Numbering++));
        System.out.println("マイリスト2:"+userMyList);
        return this.userMyListService.postUser(userMyList);
    }

    /**
     * お気に入り情報を更新する
     * 
     * @param id
     * @return userFavorite
     */
    @RequestMapping(value = "/putmylist/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserMyList putUser(@PathVariable("id") String user_id, @RequestBody UserMyList userMyList) {
        // 更新対象確認
        if (this.userMyListService.findById(userMyList.getUserId()).size() > 0) {
            userMyList.setUserId(user_id);
            return this.userMyListService.putUser(userMyList);
        }
        return userMyList;
    }

    /**
     * お気に入り情報を削除
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteusermylist/{id}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable("id") String id) {
        this.userMyListService.deleteUser(id);
    }

    /**
     * お気に入り情報全件取得
     * 
     * @return userFavorite
     */
    @RequestMapping(value = "/user/usermylist/getall", method = RequestMethod.GET)
    public List<UserMyList> findAll() {
        return this.userMyListService.findAll();
    }

}
