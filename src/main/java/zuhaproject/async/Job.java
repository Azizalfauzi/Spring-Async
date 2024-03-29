package zuhaproject.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Slf4j
public class Job {
    private AtomicLong atomicLong = new AtomicLong();

    @Scheduled(timeUnit = TimeUnit.SECONDS, initialDelay = 2, fixedDelay = 2)
    public void runJob() {
        Long value = atomicLong.incrementAndGet();
        log.info("{} run job {}", value, Thread.currentThread());
    }

    public long getValue() {
        return atomicLong.get();
    }
}
