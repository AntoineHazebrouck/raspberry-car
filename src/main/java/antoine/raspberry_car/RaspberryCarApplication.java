package antoine.raspberry_car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RaspberryCarApplication {

    public static void main(String[] args) {
        var app = SpringApplication.run(RaspberryCarApplication.class, args);
        app.getBean(Main.class).run();
    }
}
