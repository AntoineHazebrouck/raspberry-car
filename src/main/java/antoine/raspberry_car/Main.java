package antoine.raspberry_car;

import com.pi4j.context.Context;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class Main {

    public void run(Context pi) throws Exception {
        var leftPower = pi.pwm().create(17).frequency(1000);

        for (int power = 0; power < 100; power++) {
            leftPower.on(power);

            Thread.sleep(Duration.ofMillis(100));
        }

        for (int power = 100; power >= 0; power--) {
            leftPower.on(power);

            Thread.sleep(Duration.ofMillis(100));
        }

        for (int power = 0; power < 100; power++) {
            leftPower.on(power);

            Thread.sleep(Duration.ofMillis(100));
        }

        leftPower.off();
    }
}
