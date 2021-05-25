package org.interview.knight;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class assume that it maybe used in multi threaded env
 * a simple lock mechanism is used to achieve safety
 */
public class GoldPayment {

    private Lock lock = new ReentrantLock();

    int payment(int noDays) {
        try {
            lock.tryLock();

            // Not supported case
            if (noDays < 1) {
                return 0;
            }
            // Sum of payments
            int sum = 0;

            // Generic payment value
            int coinPayment = 1;

            // Identify the counter of the frequency
            int nDayCount = 1;

            int step = 1;

            for (int counter = 1; counter <= noDays; counter++) {
                sum += coinPayment;
                // only make payment if they are correct
                if (step == nDayCount) {
                    // n steps reset itself
                    nDayCount = 0;
                    // coin payment increased
                    step = ++coinPayment;
                }
                nDayCount++;
            }
            return sum;
        } finally {
            lock.unlock();
        }
    }
}
