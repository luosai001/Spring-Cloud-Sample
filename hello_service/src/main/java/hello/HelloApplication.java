package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by sai.luo on 2017/4/25.
 */
@SpringBootApplication
@RestController
public class HelloApplication{

    private static Logger logger = LoggerFactory.getLogger(HelloApplication.class) ;

    @RequestMapping(value = "/greeting")
    public String hello(){
        logger.info("access /greeting");
        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
        Random rand = new Random();

        int randomNum = rand.nextInt(greetings.size());
        return greetings.get(randomNum);
    }
    @RequestMapping(value = "/")
    public String home() {
        logger.info("Access /");
        return "Hi!";
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class,args);
    }
}
