package com.worldline.perfectnumber;

import com.worldline.perfectnumber.service.PerfectNumberSearchService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class PerfectNumberSearchServiceTest {

    PerfectNumberSearchService perfectnumberservice = new PerfectNumberSearchService();

    @Test
    void test_FindPerfectNumber_True() {
        boolean result = perfectnumberservice.FindPerfectNumber(6);
        assertEquals(true, result);

    }

    @Test
    void test_FindPerfectNumber_NotTrue() {
        boolean result = perfectnumberservice.FindPerfectNumber(2);
        assertEquals(false, result);

    }

    @Test
    void test_FindPerfectNumberWithinRange_100() {
        Optional<List<Integer>> result = perfectnumberservice.FindPerfectNumberWithinRange(1, 100);
        assertEquals("Optional[[6, 28]]", result.toString());

    }

    @Test
    void test_FindPerfectNumberWithinRange_1000() {
        Optional<List<Integer>> result = perfectnumberservice.FindPerfectNumberWithinRange(1, 1000);
        assertEquals("Optional[[6, 28, 496]]", result.toString());
    }

    @Test
    void test_FindPerfectNumberWithinRange_5() {
        Optional<List<Integer>> result = perfectnumberservice.FindPerfectNumberWithinRange(1, 5);
        assertEquals("Optional[[]]", result.toString());
    }


}


