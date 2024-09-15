package algohani.common.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class HealthCheckComponent {

    public String healthCheck() {
        log.info("health check!!11!12312111");
        return "OK";
    }
}
