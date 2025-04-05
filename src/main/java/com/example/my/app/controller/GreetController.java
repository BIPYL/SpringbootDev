package com.example.my.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 🔍 Model 이란?
// Spring이 제공하는 데이터 전달용 객체
// Controller에서 데이터를 model.addAttribute()로 넣으면
// View 템플릿에서 ${name} 같은 형식으로 꺼낼 수 있음

//파일구조
// src/
// └── main/
//     ├── java/com/example/my/app/
//     │   ├── MyAppApplication.java
//     │   └── controller/
//     │       └── GreetController.java
//     └── resources/
//         └── templates/
//             └── greet.html ← 여기에 뷰 파일 작성


@Controller
public class GreetController {

    @GetMapping("/greet")
    public String greet(@RequestParam(name = "name", required = false, defaultValue = "손님") String name,
                        Model model) { //Spring이 자동 생성한 Model 객체
        model.addAttribute("username", name);  //username이라는 이름으로 name을 Model에 저장한다는 뜻이야. 이 Model은 나중에 뷰 템플릿(greet.html) 에 전달돼.
        return "greet"; // greet.html로 연결
    }
}


// 항목                                         설명
// @RequestParam	                           URL 파라미터를 받아오는 어노테이션
// required = false	                           파라미터 없어도 실행 가능하게
// defaultValue = "손님"	                    name이 없으면 기본값 사용
// model.addAttribute("username", name)	       View에 넘길 데이터 저장
// return "greet"	                           resources/templates/greet.html 파일로 연결됨