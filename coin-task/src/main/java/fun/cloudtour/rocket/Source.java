package fun.cloudtour.rocket;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source {


    /**
     * 向指定的output 里面输出信息
     * @return
     */
    @Output("subscribe_event_out")
    MessageChannel subscribeEventOutput() ;
}
