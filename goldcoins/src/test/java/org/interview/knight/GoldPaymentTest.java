package org.interview.knight;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.Assert.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GoldPaymentTest {

    private GoldPayment goldPayment;

    @BeforeAll
    public void setUp(){
        goldPayment = new GoldPayment();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/daysInput.csv", numLinesToSkip = 1)
    public void testPayment(int input, int expected){
        int actualValue = goldPayment.payment(input);
        assertEquals(expected, actualValue);
    }
}
