package com.alexseifert.blog.service;

import com.alexseifert.blog.dto.UserDto;
import com.alexseifert.blog.entity.Role;
import com.alexseifert.blog.entity.User;
import com.alexseifert.blog.repository.RoleRepository;
import com.alexseifert.blog.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private BCryptPasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepository userRepository,
                          RoleRepository roleRepository,
                          BCryptPasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void saveUser(UserDto userDto) {
    User user = new User();
    user.setEmail(userDto.getEmail());
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));

    Role role = roleRepository.findByName("MEMBER");
    user.setRoles(Arrays.asList(role));

    userRepository.save(user);
  }

  @Override
  public User findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public List<UserDto> findAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream().map((user) -> convertEntityToDto(user))
            .collect(Collectors.toList());
  }

  private UserDto convertEntityToDto(User user){
    UserDto userDto = new UserDto();
    userDto.setEmail(user.getEmail());
    return userDto;
  }

}
