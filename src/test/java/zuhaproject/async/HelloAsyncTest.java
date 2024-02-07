package zuhaproject.async;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class HelloAsyncTest {
    @Autowired
    private HelloAsync helloAsync;

    @SneakyThrows
    @Test
    void hello() {
        for (int i = 0; i < 10; i++) {
            helloAsync.hello();
        }
        log.info("After call function hello()");
        Thread.sleep(Duration.ofSeconds(5));
    }

    @Test
    void helloName() throws ExecutionException, InterruptedException {
        Future<String> future = helloAsync.hello("Aziz");
        log.info("after call hello(Aziz)");
        String response = future.get();
        log.info(response);
    }
}