package com.example.cocomecha_api.domain.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import com.example.cocomecha_api.domain.model.User;

import java.util.List;

// @Repository
public interface UserRepository 
// extends JpaRepository<User, String>
{
  List<User> findById(String mailaddress);	

}
