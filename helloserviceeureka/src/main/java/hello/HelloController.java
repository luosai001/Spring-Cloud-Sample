package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by sai.luo on 2017/4/26.
 */
@RestController
@EnableDiscoveryClient
//@EnableHystrixDashboard
//@EnableHystrix
public class HelloController {
    private static Logger log = LoggerFactory.getLogger(HelloController.class) ;

    @GetMapping(value = "/greeting")
    public String greet(){
        log.info("access /greeting");

        List<String> hello_2 = Arrays.asList("hello-0", "hello-1", "hello_2");
        Random random = new Random();
        String s = hello_2.get(random.nextInt(hello_2.size()));
        return s ;

    }
    @GetMapping(value = "/1")
    public String home(){
        log.info("access /");
        return "hi";
    }
}
