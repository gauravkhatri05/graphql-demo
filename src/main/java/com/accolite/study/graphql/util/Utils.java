package com.accolite.study.graphql.util;

import java.security.SecureRandom;

public final class Utils {

    private static final SecureRandom SECURE_RANDOM;

    static {
        SECURE_RANDOM = new SecureRandom();
    }

    private Utils() {
        super();
    }

    public static Integer getRandomNumber(final Integer max) {

        var randomNumber = SECURE_RANDOM.nextInt(max);

        return switch (randomNumber) {
            case 0 -> 1;
            default -> randomNumber;
        };
    }
}
