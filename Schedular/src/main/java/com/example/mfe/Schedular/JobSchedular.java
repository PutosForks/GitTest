package com.example.mfe.Schedular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
 /*
@ConditionalOnProperty(value = "scheduling.disabled")
@EnableScheduling
*/

@Component
public class JobSchedular {

    private static final Logger log = LoggerFactory.getLogger(JobSchedular.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /*
    The Scheduled annotation defines when a particular method runs. NOTE:
    This example uses fixedRate, which specifies the interval between method
    invocations measured from the start time of each invocation. It doesn't wait for previous invocation to finish running
     */

    @Scheduled(fixedRate = 20000)
    public void fixedDelay() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    /*
    This example uses fixedDelay, which specifies the interval between method
    invocations with regard to previous Run
    */

    @Scheduled(fixedDelay = 5000)
    public void fixedRate() {
        log.info("The time is now with delay{}", dateFormat.format(new Date()));
    }

    /*
    The task will be executed a first time after initalDelay value - and it will
    continue to be executed according to fixed delay
     */

    @Scheduled(fixedDelay = 5000, initialDelay = 1000)
    public void usingFixedDelayWithInitalDelay() {
        log.info("The time is now with delay and initial delay{} ", dateFormat.format(new Date()));
    }

    /*
    1.Seconds
    2.Minutes
    3.Hours
    4.Day-of-Month
    5.Month
    6.Day-of-Week
    7.Year (optional field)

        +-------------------- second (0 - 59)
    |  +----------------- minute (0 - 59)
    |  |  +-------------- hour (0 - 23)
    |  |  |  +----------- day of month (1 - 31)
    |  |  |  |  +-------- month (1 - 12)
    |  |  |  |  |  +----- day of week (0 - 6) (Sunday=0 or 7)
    |  |  |  |  |  |  +-- year [optional]
    |  |  |  |  |  |  |
    *  *  *  *  *  *  * command to be executed

    Every 30 minutes  "0 0/30 * * * ?"
     */

    @Scheduled(cron = "*/5 * * * * *")  // every 5 seconds
    public void usingCron() {
        log.info("The cron {} ", dateFormat.format(new Date()));
    }

}
