package com.example.cocomecha_api.application;

import com.example.cocomecha_api.domain.model.SlipComment;
import com.example.cocomecha_api.domain.service.SlipCommentService;
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
@RequestMapping(path = "/v1/slipcomment")
public class SlipCommentController {
  @NonNull
  @Autowired
  private final SlipCommentService slipCommentService;

  /**
   * 伝票No.をキーとして伝票情報を取得する
   * 
   * @param slipNo
   * @return 伝票情報
   */
  @GetMapping("/{commen_id}")
  @ResponseStatus(HttpStatus.OK)
  public List<SlipComment> findById(@PathVariable("commen_id") Integer commen_id) {
      return this.slipCommentService.findById(commen_id);
  }

  /**
   * 伝票情報を登録する
   * 
   * @param slipNo
   * @return 伝票情報
   */
  @RequestMapping(value = "/slippost", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  // JSONマッピング用に作成したBeanクラスを指定する
  public SlipComment postUser(@RequestBody SlipComment slipComment) {
      // ObjectMapper objectMapper = new ObjectMapper();
      return this.slipCommentService.postUser(slipComment);
  }

  /**
   * 伝票情報を更新する
   * 
   * @param slipNo
   * @return 伝票情報
   */
  @RequestMapping(value = "/{commen_id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public SlipComment putUser(@PathVariable("commen_id") Integer commentId, @RequestBody SlipComment slipComment) {
      // 更新対象確認
      if (this.slipCommentService.findById(slipComment.getCommentId()).size() > 0) {
        slipComment.setCommentId(commentId);
          return this.slipCommentService.putUser(slipComment);
      }
      return slipComment;
  }

  /**
   * 伝票情報を削除
   * 
   * @param slipNo
   * @return 伝票情報
   */
  @RequestMapping(value = "{commentId}", method = RequestMethod.DELETE)
  void deleteUser(@PathVariable("commentId") Integer commentId) {
      this.slipCommentService.deleteUser(commentId);
  }


  
  @RequestMapping(value = "/slipget", method = RequestMethod.GET)
  public List<SlipComment> getUserAll() {
      return this.slipCommentService.getUserAll();
  }
}
