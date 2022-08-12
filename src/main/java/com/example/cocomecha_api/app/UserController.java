package com.example.cocomecha_api.app;

import com.example.cocomecha_api.domain.model.User;
import com.example.cocomecha_api.domain.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/users")
public class UserController {
  @NonNull
  private final UserService userService;

  @GetMapping("/{user}")
  @ResponseStatus(HttpStatus.OK)
  public List<User> findByPriceLessThanEqualOrderByPriceAsc(@PathVariable("user") Integer user) {
    return this.userService.findByPriceLessThanEqualOrderByPriceAsc(user);
  }


}