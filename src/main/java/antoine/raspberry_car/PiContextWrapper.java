package antoine.raspberry_car;

import antoine.raspberry_car.pwm.PulseWidthModulationProvider;
import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.plugin.gpiod.provider.gpio.digital.GpioDDigitalInputProviderImpl;
import com.pi4j.plugin.gpiod.provider.gpio.digital.GpioDDigitalOutputProviderImpl;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class PiContextWrapper {

    @Getter
    private final Context pi;

    public PiContextWrapper() {
        pi = Pi4J.newContextBuilder()
            .add(new GpioDDigitalOutputProviderImpl())
            .add(new GpioDDigitalInputProviderImpl())
            .add(new PulseWidthModulationProvider())
            .build();
    }

    @PreDestroy
    public void onDestroy() {
        pi.shutdown();
    }
}
