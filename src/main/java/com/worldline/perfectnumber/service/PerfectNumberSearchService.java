package com.worldline.perfectnumber.service;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * This is the PerfectNumberSearch handler for Service class for validating number is Perfect number or not
 **/
@Component
public class PerfectNumberSearchService {
    /*Perfect Number is the sum of its positive divisors excluding the number itself and is equal
    to that number. For example, 28 is a perfect number because 28 is divisible by 1, 2, 4, 7,
    14 and 28 and the sum of these values is 1 + 2 + 4 + 7 + 14 = 28. Remember, we have to exclude
    the number itself.
     */
    public boolean FindPerfectNumber(Integer Number) {
        int[] primeNumber = new int[]{2, 3, 5, 7, 13, 17, 19, 31};
        for (int primes : primeNumber) {
            if (euler(primes) == Number)
                return true;
        }
        return false;
    }

    public Optional<List<Integer>> FindPerfectNumberWithinRange(Integer startRange, Integer endRange) {

        List<Integer> perfectNumberList = new ArrayList<>();
        for (int i = startRange; i <= endRange; i++) {
            if (FindPerfectNumber(i) == true) {

                perfectNumberList.add(i);
            }

        }
        return Optional.ofNullable(perfectNumberList);
    }



    public int euler(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }

    /*public int euler(int p) {
        int v = (int) (Math.pow(2, p - 1) * (Math.pow(2, p) - 1));
        return v;
    }*/


}
