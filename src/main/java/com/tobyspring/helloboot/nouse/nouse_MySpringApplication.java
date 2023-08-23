package com.tobyspring.helloboot.nouse;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class nouse_MySpringApplication {
    public static void run(Class<?> applicationClass, String[]... args)  { // atgs 혹시 사용할 수 도 있기 때문에
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() { // Springcontainer 초기화 하는 도중에
                super.onRefresh();
                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                // 톰캣 서블릿 컨테이너를 코드로 쉽게 사용할 수 있도록 한 도우미 클래스 , 추상화 시켜둠, 다른 서버들도 사용 할 수 있게
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);

                dispatcherServlet.setApplicationContext(this);

                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet",dispatcherServlet
                            // 클래스 내부에서 참고하고자 하기 때문에
                    ).addMapping("/*");
                });
                // tomcat 외의 다른 서블릿컨테이너를 지원 할 수 있고, 일관된 방식으로 실행하기위해서
                // 추상화를 해놓았다
                // ServletContainer 를 만드는 생성 함수이다.
                webServer.start();
            }
        };
        // 구성정보를 가지고 있는 자바 클래스를 등록해줘야한다
        applicationContext.register(applicationClass);
        applicationContext.refresh();
    }
}
