package kr.flab.ottsharing.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.ottsharing.entity.User;
import kr.flab.ottsharing.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService loginService;

    @PostMapping("/login")
    public String IdCheck(@RequestParam String userId,HttpServletResponse response){

        User loginMember = loginService.loginCheck(userId);
        if(loginMember == null){
            loginMember = loginService.enrollUser(userId);
        }

        Cookie cookie = new Cookie("memberId",String.valueOf(loginMember.getUserId()));
        response.addCookie(cookie);


        return loginMember.getUserId();
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("memberId", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}