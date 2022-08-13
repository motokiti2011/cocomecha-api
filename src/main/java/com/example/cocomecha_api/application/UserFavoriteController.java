package com.example.cocomecha_api.application;

import com.example.cocomecha_api.domain.model.UserFavorite;
import com.example.cocomecha_api.domain.service.UserFavoriteService;
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
@RequestMapping(path = "/v1/favorite")
public class UserFavoriteController {

    @NonNull
    @Autowired
    private final UserFavoriteService userFavoriteService;

    /**
     * idをキーとしてお気に入り情報を取得する
     * @param id
     * @return userFavorite
     */
    @GetMapping("getfavorite/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserFavorite> findById(@PathVariable("id") Integer id) {
        return this.userFavoriteService.findById(id);
    }



  /**
   * ユーザーIDをキーとして閲覧履歴情報を取得する
   * @param id
   * @return userFavorite
   */
  @GetMapping("getuserbyfavorite/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public List<UserFavorite> findByUser_Id(@PathVariable("userId") String userId) {
    System.out.println("引数" + userId);
    List<UserFavorite> resultList = new ArrayList<UserFavorite>();
    // 伝票情報を取得しエリア情報で絞り込みを行う
    List<UserFavorite> favoriteList = this.userFavoriteService.findAll();
    favoriteList.stream()
    .filter(fav -> fav.getUserId().equals(userId))
    .forEach(fav -> resultList.add(fav));

    System.out.println("UserFavorite:初期データ：" + favoriteList.size());
    System.out.println("UserFavorite:返却件数：" + resultList.size());
    
    return resultList;  
  }

    /**
     * お気に入り情報を登録する
     * @param id
     * @return userFavorite
     */
    @RequestMapping(value = "/postfavorite", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    // JSONマッピング用に作成したBeanクラスを指定する
    public UserFavorite postUser(@RequestBody UserFavorite userFavorite) {
        System.out.println(userFavorite);
        // ObjectMapper objectMapper = new ObjectMapper();
        return this.userFavoriteService.postUser(userFavorite);
    }

    /**
     * お気に入り情報を更新する
     * @param id
     * @return userFavorite
     */
    @RequestMapping(value = "/putfavorite/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserFavorite putUser(@PathVariable("id") String user_id, @RequestBody UserFavorite userFavorite) {
        // 更新対象確認
        // if (this.userFavoriteService.findById(userFavorite.getUser_id()).size() > 0) {
        //     userFavorite.setUser_id(user_id);
        //     return this.userFavoriteService.putUser(userFavorite);
        // }
        return userFavorite;
    }

    /**
     * お気に入り情報を削除
     * @param id
     * @return
     */
    @RequestMapping(value = "/deletefavorite/{id}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable("id") Integer id) {
        this.userFavoriteService.deleteUser(id);
    }

    /**
     * お気に入り情報全件取得
     * @return　userFavorite
     */
    @RequestMapping(value = "/user/favorite/getall", method = RequestMethod.GET)
    public List<UserFavorite> findAll() {
        return this.userFavoriteService.findAll();
    }

}
