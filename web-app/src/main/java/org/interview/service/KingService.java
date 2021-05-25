package org.interview.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.interview.knight.DayCoinPaymentProcessor;
import org.interview.model.PaymentPerDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This service retrieve the payments before sending out to the rest
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KingService {

    @NonNull
    DayCoinPaymentProcessor dayCoinPaymentProcessor;

    public List<PaymentPerDay> findAll() {
        Map<Integer, Integer> results = dayCoinPaymentProcessor.onProcess();
        if (results == null) {
            return new ArrayList<>();
        }
        return results.entrySet().stream().map((entry) -> new PaymentPerDay(entry.getKey(), entry.getValue()) )
        .collect(Collectors.toList());
    }
}
