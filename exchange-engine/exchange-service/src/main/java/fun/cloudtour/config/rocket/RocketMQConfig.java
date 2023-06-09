package fun.cloudtour.config.rocket;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {Sink.class,Source.class})
public class RocketMQConfig {
}
