package com.example.my.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.testng.reporters.jq.Model;



@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {
        return "index"; //index.html
    }
}


//🔍 Model 이란?
// Spring이 제공하는 데이터 전달용 객체
// Controller에서 데이터를 model.addAttribute()로 넣으면
// View 템플릿에서 ${name} 같은 형식으로 꺼낼 수 있음