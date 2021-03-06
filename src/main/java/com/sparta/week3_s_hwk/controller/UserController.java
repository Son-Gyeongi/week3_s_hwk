package com.sparta.week3_s_hwk.controller;


import com.sparta.week3_s_hwk.dto.SignupRequestDto;
import com.sparta.week3_s_hwk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }

    //디테일 페이지로 이동
    //BlogContoller에서는 @RestContoller가 있어서 그런지 안되었는데
    //UserCOntroller에서는 @Controller만 있어서 잘된다
    @GetMapping("/api/detail/{id}")
    public String detail() {
        return "detail";
    }
}