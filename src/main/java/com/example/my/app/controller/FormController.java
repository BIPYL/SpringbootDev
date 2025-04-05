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

import com.example.my.app.dto.UserForm;

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

    @PostMapping("/form")
    public String submitForm(@ModelAttribute UserForm userForm, Model model) {
        model.addAttribute("user", userForm);
        return "form";
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



// Q. 근데 위 html에서는 get요청이 없는데 get정보를 받아?
// ChatGPT의 말:
// 오! 아주 날카로운 질문이야 👏
// 정확히 말하자면, GET /form 요청은 HTML 코드에 명시적으로 들어있진 않지만,
// 우리가 작성한 컨트롤러 코드에서 처리하도록 구성되어 있어.

// 📌 어디서 GET 요청을 처리하냐면?

// 바로 이 부분이야 👇
// FormController.java에서:

// @GetMapping("/form")
// public String showForm() {
//     return "form"; // → templates/form.html 파일 렌더링
// }
// 즉, 사용자가 브라우저에서 localhost:8080/form으로 들어가면,
// 자동으로 이 GET 요청을 컨트롤러가 처리해서 form.html 페이지를 보여주는 거야!

// 🔁 HTML 폼 안에는 POST만 있어도 괜찮은 이유

// <form action="/form" method="post">
// 이건 사용자가 폼에 값 입력하고 제출할 때 POST 요청을 보내는 부분이고,
// 그 전에 처음 페이지를 볼 때는 브라우저가 자동으로 GET 요청을 보내.

// 👉 즉,
// 처음 진입 시: 브라우저가 GET /form 요청 → form.html 보여줌
// 폼 제출 시: <form action="/form" method="post"> → POST /form 요청 → 값 처리 후 결과 표시
// 🧠 한 마디로 요약

// HTML에서는 GET 요청을 직접 쓸 필요 없어.
// 브라우저 주소창에 직접 입력하거나 링크 클릭하면 기본이 GET이야.
// 이 요청은 우리가 컨트롤러에서 @GetMapping("/form")으로 처리하는 거고,
// HTML 폼에 있는 method="post"는 폼 제출 시 실행되는 POST 요청이야.