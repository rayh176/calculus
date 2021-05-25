package org.interview.random.generator.impl;

import org.interview.random.generator.RandomNumGenerator;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RandomNumGeneratorImplTest {

    @ParameterizedTest
    @MethodSource("randomWrongValues")
    void testInvalidArguments(int[] randomNums, float[] probabilities)
    {
        assertThrows(IllegalArgumentException.class, ()-> new RandomNumGeneratorImpl(randomNums, probabilities));
    }

    @ParameterizedTest
    @MethodSource("randomValues")
    void validateNextRandomValues(int[] randomNums, float[] probabilities, Map<Integer, Integer> expectedResults)
    {
        Map <Integer, Integer> resultsSum = new HashMap<>();
        for ( int i =0; i< 100; i++) {
            RandomNumGenerator rdnG = new RandomNumGeneratorImpl(randomNums, probabilities);
            int calculatedresult = rdnG.nextNum();
            if (resultsSum.containsKey(calculatedresult)) {
                resultsSum.put(calculatedresult, resultsSum.get(calculatedresult)+ 1);
            } else {
                resultsSum.put(calculatedresult, 1);
            }
        }
        assertFalse(expectedResults.equals(resultsSum));
    }

    private static Stream<Arguments> randomWrongValues(){
        int[] randomNumbers = {-1, 0, 1, 2, 3};
        float[] correctProbabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};
        float[] wrongProbabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};
        return Stream.of(Arguments.of(null, null),
                    Arguments.of(randomNumbers, null),
                    Arguments.of(null, wrongProbabilities),
                    Arguments.of(null, correctProbabilities)
                );
    }

    private static Stream<Arguments> randomValues(){
        int[] randomNumbers = {-1, 0, 1, 2, 3};
        float[] correctProbabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};
        Map<Integer, Integer> expectedResults = new HashMap<>();
        expectedResults.put(-1,1);
        expectedResults.put(0,22);
        expectedResults.put(1,57);
        expectedResults.put(2,20);
        expectedResults.put(3,0);

        return Stream.of(Arguments.of(randomNumbers, correctProbabilities, expectedResults));
    }
}
