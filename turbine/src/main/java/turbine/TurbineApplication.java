package turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by sai.luo on 2017/4/26.
 */

@SpringBootApplication
@EnableTurbine
@EnableHystrix
@EnableHystrixDashboard
public class TurbineApplication{
    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class,args);
    }
}
