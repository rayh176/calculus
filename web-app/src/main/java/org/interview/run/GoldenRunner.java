package org.interview.run;

import org.interview.knight.DayCoinPaymentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GoldenRunner implements ApplicationRunner {

    @Autowired
    private DayCoinPaymentProcessor dayCoinPaymentProcessor;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<Integer, Integer> results = dayCoinPaymentProcessor.onProcess();
        System.out.println("============= Start the calculator of number of Coins per day =================");
        results.entrySet().stream().forEach((entry)->
            System.out.println(entry.getKey()+" -> "+ entry.getKey() +" "+ entry.getValue())
        );
        System.out.println("============= Finished the call the calculator of Number of Coins per day =================");
    }
}
