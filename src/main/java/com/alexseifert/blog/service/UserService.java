package com.alexseifert.blog.service;

import com.alexseifert.blog.dto.UserDto;
import com.alexseifert.blog.entity.User;

import java.util.List;

public interface UserService {

  void saveUser(UserDto userDto);

  User findByEmail(String email);

  List<UserDto> findAllUsers();

}
