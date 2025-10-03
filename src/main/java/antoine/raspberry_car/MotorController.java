package antoine.raspberry_car;

import com.pi4j.io.pwm.Pwm;
import org.springframework.stereotype.Service;

@Service
public class MotorController {

    private final Pwm power;

    public MotorController(PiContextWrapper wrapper) {
        this.power = wrapper.getPi().pwm().create(17).frequency(1000);
    }

    public void on(double power) {
        this.power.on(power);
    }
}
