package com.tobyspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//검증만 함, 책임은 service로 넘김
@RequestMapping
@RestController
public class  HelloController {
    private final HelloService helloService;

    // 생성자 주입
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        if(name == null || name.trim().length() == 0) throw new IllegalArgumentException();

        return helloService.sayHello(name);
    }
}
