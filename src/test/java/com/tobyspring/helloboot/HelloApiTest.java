package com.tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;

public class HelloApiTest {

    @Test
    void helloApi() {
        // http localhost:8080/hello?name=Spring 을 코드로구현

        TestRestTemplate rest = new TestRestTemplate(); // api 요청을 호출해서 사용할 수 있다.
        ResponseEntity<String> res = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class, "Spring");
        // url / 어떤 타입으로 해서 리턴할까, / 파라미터
        // 검증
        // status 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        // text/plain
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        //bodycheck
        assertThat(res.getBody()).isEqualTo("*HelloSpring*");
    }
    @Test
    void failhelloApi() {
        // http localhost:8080/hello?name=Spring 을 코드로구현

        TestRestTemplate rest = new TestRestTemplate(); // api 요청을 호출해서 사용할 수 있다.
        ResponseEntity<String> res = rest.getForEntity("http://localhost:8080/hello?name=", String.class);
        // url / 어떤 타입으로 해서 리턴할까, / 파라미터
        // 검증
        // status 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        // text/plain
//        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        //bodycheck
//        assertThat(res.getBody()).isEqualTo("HelloSpring");
    }
}
