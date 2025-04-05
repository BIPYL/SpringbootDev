// 🧠 개념 심화: POST 방식 vs GET 방식

// 구분	설명
// GET	URL 뒤에 ?name=홍길동 처럼 데이터 붙임 (보여짐)
// POST	데이터를 요청 본문(body)에 담아 보냄 (안보임)
// 보안성	POST가 상대적으로 안전 (ex. 로그인, 회원가입)
// 사용처	GET: 조회, 검색 / POST: 입력, 저장, 등록

// 실습파일 구조
// src/
// ├── java/com/example/my/app/controller/
// │   └── FormController.java ← 실습할 파일!
// └── resources/templates/
//     ├── form.html         ← 이름 입력하는 페이지
//     └── welcome.html      ← 결과 보여주는 페이지

package com.example.my.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    // 폼 페이지 보여주기 (GET)
    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    // 폼 제출 처리 (POST)
    @PostMapping("/submit")
    public String handleForm(@RequestParam("name") String name, Model model) {
        model.addAttribute("username", name);
        return "welcome";
    }
}


// 📦 전체 흐름 요약

// 1. 사용자: /form → 이름 입력
// 2. 서버: form.html 렌더링
// 3. 사용자: 이름 입력 후 POST → /submit
// 4. 서버: handleForm 메서드 실행 → name 받음
// 5. Model에 username 저장 → welcome.html로 전달
// 6. 사용자: 환영 메시지 확인

// ☝ 여기까지의 필수지식 요약

// 항목	설명
// @GetMapping	폼 같은 페이지를 보여줄 때 사용
// @PostMapping	폼 데이터를 처리할 때 사용
// <form method="post">	POST 방식으로 데이터 전송
// @RequestParam	form의 input 값을 받아오는 도구
// Model	컨트롤러 → 뷰로 데이터 전달