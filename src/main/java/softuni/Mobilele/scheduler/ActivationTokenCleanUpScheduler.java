package softuni.Mobilele.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ActivationTokenCleanUpScheduler {


    // TODO
    @Scheduled(cron = "0 5 * * * ?")
    public void cleanupTokens(){
        // TODO - call the user service
        System.out.println(LocalDateTime.now());
    }
}
