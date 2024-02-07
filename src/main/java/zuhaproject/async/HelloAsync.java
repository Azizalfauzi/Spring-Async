package zuhaproject.async;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
public class HelloAsync {

    @SneakyThrows
    @Async
    public void hello() {
        Thread.sleep(Duration.ofSeconds(2));
        log.info("Hello after 2 second {}", Thread.currentThread());
    }
}
