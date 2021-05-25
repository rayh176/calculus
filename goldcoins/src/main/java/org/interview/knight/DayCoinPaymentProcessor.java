package org.interview.knight;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DayCoinPaymentProcessor {

    @NonNull
    CsvReader cvsReader;
    @NonNull
    GoldPayment goldPayment;

    /**
     * Assume all entries are digits
     */
    public Map<Integer, Integer> onProcess() {
        return cvsReader.loadData().map( noDaysString -> {
                int noDays = Integer.parseInt(noDaysString.trim());
                return new int [] { noDays, goldPayment.payment(noDays)};
            }
        ).collect(Collectors.toMap(k -> k[0], v -> v[1]));
    }
}
