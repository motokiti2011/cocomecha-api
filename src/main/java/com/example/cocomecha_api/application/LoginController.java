package com.example.cocomecha_api.application;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.cocomecha_api.domain.model.LoginInfoDTO;
import com.example.cocomecha_api.domain.model.Login;
import com.example.cocomecha_api.domain.model.LoginUser;

import java.util.Base64;
import lombok.RequiredArgsConstructor;
import com.example.cocomecha_api.domain.service.LoginServiceDemo;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(path = "/v1")
public class LoginController {

  @Autowired
  private LoginServiceDemo service;

  /**
   * ログイン処理
   * 
   * @param loginInfo
   * @param request
   * @param response
   * @return
   */
  @GetMapping("/login")
  public ResponseEntity<LoginUser> Login(HttpServletRequest request, HttpServletResponse response,
      @RequestHeader(name = "authorization", required = false) String value) {

    LoginUser loginUser = new LoginUser();
    System.out.println("リクエスト：" + request.toString());
    System.out.println("0："+value);
    // ログインでのユーザー認証実装が必要
    String loginPassWd = new String(Base64.getDecoder().decode(value));

    String[] certificationInfo = loginPassWd.split(":");
    LoginInfoDTO loginInfo = new LoginInfoDTO();
    loginInfo.setLoginid(certificationInfo[0]);
    loginInfo.setPassword(certificationInfo[1]);

    // ログインユーザー情報取得仮
    List<Login> userList = this.service.findByLoginid(certificationInfo[0]);
    System.out.println("04：" + userList);
    // 仮認証
    if (userList.size() < 0) {
      return new ResponseEntity<>(null, null, HttpStatus.UNAUTHORIZED);
    }
    Login user = userList.get(0);
    loginUser.setUserId(user.getUserid());
    loginUser.setUserName(user.getName());

    return new ResponseEntity<>(loginUser, null, HttpStatus.OK);
  }

  /**
   * 以下Sequrityの実装に問題が発生したため未実装
   * 
   * @param request
   * @param response
   * @param value
   * @return
   */
  // @RequestMapping(value="/v1/login",method=RequestMethod.POST)
  // public ResponseEntity<AuthResult> login(@RequestBody LoginInfoDTO
  // loginInfo,HttpServletRequest request,HttpServletResponse response){
  // @GetMapping
  // public ResponseEntity<AuthResult> Login(HttpServletRequest request,
  // HttpServletResponse response,
  // @RequestHeader(name = "authorization", required = false) String value) {
  // System.out.println("リクエスト：" + request.toString());
  // // ログインでのユーザー認証実装が必要
  // String code = value.replace("Basic ", "");
  // String loginPassWd = new String(Base64.getDecoder().decode(code));

  // String[] certificationInfo = loginPassWd.split(":");
  // LoginInfoDTO loginInfo = new LoginInfoDTO();
  // loginInfo.setMailaddress(certificationInfo[0]);
  // loginInfo.setPassword(certificationInfo[1]);

  // // 認証処理を実行
  // AuthResult authResult = loginService.login(loginInfo);
  // // 認証OKの場合はcsrfトークンをクッキーにセット
  // if (authResult.getUserName() != null) {
  // CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
  // if (csrf != null) {
  // Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
  // String token = csrf.getToken();
  // Authentication authentication =
  // SecurityContextHolder.getContext().getAuthentication();
  // if ((cookie == null || token != null && !token.equals(cookie.getValue()))
  // && (authentication != null && authentication.isAuthenticated())) {
  // cookie = new Cookie("XSRF-TOKEN", token);
  // cookie.setPath("/");
  // response.addCookie(cookie);
  // }
  // }
  // return new ResponseEntity<>(authResult, null, HttpStatus.OK);
  // }
  // // 認証失敗時は401エラーを返却
  // else {
  // return new ResponseEntity<>(authResult, null, HttpStatus.UNAUTHORIZED);
  // }
  // }

}
