package org.interview.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Data
@RequiredArgsConstructor
public class PaymentPerDay {
    private final int noOfDays;
    private final int noOfCoins;
}