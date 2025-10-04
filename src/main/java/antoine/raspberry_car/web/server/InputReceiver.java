package antoine.raspberry_car.web.server;

import antoine.raspberry_car.MotorController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@RequiredArgsConstructor
@Controller
public class InputReceiver {

    private final MotorController motor;

    @MessageMapping("/motor-controls")
    public String greeting(MotorControls controls) throws Exception {
        motor.on(controls.power(), controls.forward());

        return "controls updated";
    }
}
