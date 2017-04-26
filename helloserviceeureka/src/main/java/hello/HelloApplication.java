package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sai.luo on 2017/4/26.
 */

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class HelloApplication {
    public static void main(String[] args){
        SpringApplication.run(HelloApplication.class,args);
    }
}
