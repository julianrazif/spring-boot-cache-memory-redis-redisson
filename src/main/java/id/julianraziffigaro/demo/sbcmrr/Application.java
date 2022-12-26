package id.julianraziffigaro.demo.sbcmrr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude = {
  MultipartAutoConfiguration.class,
  JmxAutoConfiguration.class
}, scanBasePackages = {"id.julianraziffigaro.demo.sbcmrr.web", "id.julianraziffigaro.demo.sbcmrr.cache"})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
