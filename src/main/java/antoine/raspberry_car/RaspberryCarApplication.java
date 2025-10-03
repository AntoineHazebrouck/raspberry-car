package antoine.raspberry_car;

import antoine.raspberry_car.pwm.PulseWidthModulationProvider;
import com.pi4j.Pi4J;
import com.pi4j.plugin.gpiod.provider.gpio.digital.GpioDDigitalInputProviderImpl;
import com.pi4j.plugin.gpiod.provider.gpio.digital.GpioDDigitalOutputProviderImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RaspberryCarApplication {

    public static void main(String[] args) throws Exception {
        var app = SpringApplication.run(RaspberryCarApplication.class, args);

        var pi = Pi4J.newContextBuilder()
            .add(new GpioDDigitalOutputProviderImpl())
            .add(new GpioDDigitalInputProviderImpl())
            .add(new PulseWidthModulationProvider())
            .build();

        app.getBean(Main.class).run(pi);

        pi.shutdown();
    }
}
