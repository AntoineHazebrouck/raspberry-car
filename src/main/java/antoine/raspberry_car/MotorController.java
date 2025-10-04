package antoine.raspberry_car;

import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.pwm.Pwm;
import org.springframework.stereotype.Service;

@Service
public class MotorController {

    private final Pwm power;
    private final DigitalOutput rotationDirection1;
    private final DigitalOutput rotationDirection2;

    public MotorController(PiContextWrapper wrapper) {
        this.power = wrapper.getPi().pwm().create(17).frequency(1000);
        this.rotationDirection1 = wrapper.getPi().digitalOutput().create(18);
        this.rotationDirection2 = wrapper.getPi().digitalOutput().create(23);
    }

    public void on(double power, boolean forward) {
        this.power.on(power);

        if (forward) {
            this.rotationDirection1.high();
            this.rotationDirection2.low();
        } else {
            this.rotationDirection1.low();
            this.rotationDirection2.high();
        }
    }
}
