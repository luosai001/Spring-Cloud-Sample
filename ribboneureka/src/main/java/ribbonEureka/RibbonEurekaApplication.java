package ribbonEureka;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sai.luo on 2017/4/26.
 */

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableHystrixDashboard
@EnableHystrix
public class RibbonEurekaApplication {

    private static Logger log = LoggerFactory.getLogger(RibbonEurekaApplication.class);

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Autowired
    RestTemplate restTemplate ;

    @RequestMapping(value = "/hi")
    @HystrixCommand(fallbackMethod = "callback")
    public String hi(@RequestParam(value = "name",defaultValue = "joe") String name){
        ResponseEntity<String> forEntity = this.restTemplate.getForEntity("http://hello/greeting", String.class);
        return String.format("%s %s",forEntity.getBody(),name);
    }
    private String callback(String name){
        return "callback something";
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonEurekaApplication.class,args);
    }
}
