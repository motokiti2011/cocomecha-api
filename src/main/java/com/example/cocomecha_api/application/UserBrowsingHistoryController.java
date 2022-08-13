package com.example.cocomecha_api.application;

import com.example.cocomecha_api.domain.model.UserBrowsingHistory;
import com.example.cocomecha_api.domain.service.UserBrowsingHistoryService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(path = "/v1/userbrowsinghistory")
public class UserBrowsingHistoryController {

  @NonNull
  @Autowired
  private final UserBrowsingHistoryService userBrowsingHistory;

  /**
   * idをキーとして閲覧履歴情報を取得する
   * @param id
   * @return userFavorite
   */
  @GetMapping("getuserbrowsinghistory/{id}")
  @ResponseStatus(HttpStatus.OK)
  public List<UserBrowsingHistory> findById(@PathVariable("id") Integer id) {
    return this.userBrowsingHistory.findById(id);
  }


  /**
   * ユーザーIDをキーとして閲覧履歴情報を取得する
   * @param id
   * @return userFavorite
   */
  @GetMapping("/getuserbybrowsinghistory/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public List<UserBrowsingHistory> findByUser_Id(@PathVariable("userId") String userId) {
    System.out.println("引数" + userId);
    List<UserBrowsingHistory> resultList = new ArrayList<UserBrowsingHistory>();
    // 伝票情報を取得しエリア情報で絞り込みを行う
    List<UserBrowsingHistory> browsingHistory = this.userBrowsingHistory.findAll();
    browsingHistory.stream()
    .filter(bh -> bh.getUserId().equals(userId))
    .forEach(bh -> resultList.add(bh));

    System.out.println("UserBrowsingHistory:初期データ：" + browsingHistory.size());
    System.out.println("UserBrowsingHistory:返却件数：" + resultList.size());
    
    return resultList;  
  }


  /**
   * 閲覧履歴情報を登録する
   * 
   * @param id
   * @return userFavorite
   */
  @RequestMapping(value = "/postuserbrowsinghistory", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  // JSONマッピング用に作成したBeanクラスを指定する
  public UserBrowsingHistory postUser(@RequestBody UserBrowsingHistory userFavorite) {
    // ObjectMapper objectMapper = new ObjectMapper();
    return this.userBrowsingHistory.postUser(userFavorite);
  }

  /**
   * 閲覧履歴情報を更新する
   * 
   * @param id
   * @return userFavorite
   */
  @RequestMapping(value = "/putuserbrowsinghistory/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public UserBrowsingHistory putUser(@PathVariable("id") String userId, @RequestBody UserBrowsingHistory userFavorite) {
    // 更新対象確認
    // if (this.userBrowsingHistory.findById(userFavorite.getUser_id()).size() > 0) {
    //   userFavorite.setUser_id(userId);
    //   return this.userBrowsingHistory.putUser(userFavorite);
    // }
    return userFavorite;
  }

  /**
   * 閲覧履歴情報を削除
   * 
   * @param id
   * @return
   */
  @RequestMapping(value = "/deleteuserbrowsinghistory/{id}", method = RequestMethod.DELETE)
  void deleteUser(@PathVariable("id") Integer id) {
    this.userBrowsingHistory.deleteUser(id);
  }

  /**
   * 閲覧履歴情報全件取得
   * 
   * @return userFavorite
   */
  @RequestMapping(value = "/user/userbrowsinghistory/getall", method = RequestMethod.GET)
  public List<UserBrowsingHistory> findAll() {
    return this.userBrowsingHistory.findAll();
  }
}
