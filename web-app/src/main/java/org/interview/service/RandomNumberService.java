package org.interview.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.interview.random.generator.RandomNumGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Call the random number generator to retrieve a value
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RandomNumberService {

    @NonNull
    private RandomNumGenerator randomNumGenerator;

    public int nextNum() {
        return randomNumGenerator.nextNum();
    }

}
