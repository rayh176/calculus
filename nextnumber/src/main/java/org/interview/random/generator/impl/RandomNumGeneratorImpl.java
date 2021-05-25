package org.interview.random.generator.impl;

import lombok.ToString;
import org.interview.random.generator.RandomNumGenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.IntStream;

@ToString
public class RandomNumGeneratorImpl implements RandomNumGenerator {

    private final Random random;
    private final int [] randNumbers;
    private final float [] probabilities;
    private Map<BigDecimal, Integer> randProbabilities;

    public RandomNumGeneratorImpl(final int [] randNumbers, final float [] probabilities ) {
        validateRandNumbers(randNumbers);
        this.randNumbers = randNumbers;
        validateSumOfProbabilities(probabilities);
        this.probabilities = probabilities;
        this.random = new Random();
        init();
    }

    private void init() {
        float keyEntry = 0;
        randProbabilities = new HashMap<>();
        for (int i=0; i < probabilities.length; i++) {
            keyEntry += probabilities[i];
            BigDecimal entryKey = floatToBigDecimal(keyEntry);
            randProbabilities.put(entryKey , randNumbers[i]);
        }
    }

    public static BigDecimal floatToBigDecimal(Float a){
        if(a == null || a.isInfinite() || a.isNaN()){
            return BigDecimal.ZERO;
        }
        try{
            return BigDecimal.valueOf(a).setScale(2, RoundingMode.HALF_EVEN);

        }catch(Exception e){
            return BigDecimal.ZERO;
        }
    }

    private void validateRandNumbers(final int[] randNumbers) {
        if (randNumbers == null || randNumbers.length == 0) {
            throw new IllegalArgumentException("RandNumbers array is null");
        }
    }

    private void validateSumOfProbabilities(final float[] probabilities) {
        if (probabilities == null || probabilities.length == 0) {
            throw new IllegalArgumentException("Probabilities array is null");
        }
        float sum = IntStream.range(0, probabilities.length).mapToObj(i -> probabilities[i]).reduce((a,b) -> a + b).orElse( 0f);
        if (sum != 1) {
            throw new IllegalArgumentException("Probabilities sum is not equal 1");
        }
    }

    @Override
    public int nextNum() {
        BigDecimal nextRandomNum = floatToBigDecimal(random.nextFloat());
        return randProbabilities.get(nextRandomNum) == null ? 0 : randProbabilities.get(nextRandomNum);
    }
}
