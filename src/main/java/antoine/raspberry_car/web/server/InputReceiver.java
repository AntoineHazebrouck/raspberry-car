package antoine.raspberry_car.web.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class InputReceiver {

    @MessageMapping("/motor-controls")
    public String greeting(MotorControls hello) throws Exception {
        log.info("Message received : {}", hello);
        return "Hello" + hello.toString();
    }
}
