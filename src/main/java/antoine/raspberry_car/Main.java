package antoine.raspberry_car;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class Main {
	public void run() {
		log.info("Bonjour le monde !");
	}
}
