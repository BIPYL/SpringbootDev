package com.example.my.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Controller + ResponseBody. @Controller는 HTML(템플릿), @RestController는 문자열/JSON 반환.
public class HelloController {

    @GetMapping("/hello2")   //Spring은 자동으로 URL 요청을 매핑해준다	@GetMapping("/hello") 덕분에 우리가 if-else 없이 처리 가능
    public String sayHello() {
        return "안녕하세요";   //서버는 항상 "요청"에 "응답"하는 구조	요청 URL → 응답 텍스트 or HTML
    }
}

