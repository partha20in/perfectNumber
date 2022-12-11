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
    void testFindPerfectNumber_True() {
        boolean result = perfectnumberservice.FindPerfectNumber(6);
        assertEquals(true, result);

    }

    @Test
    void testFindPerfectNumber_NotTrue() {
        boolean result = perfectnumberservice.FindPerfectNumber(2);
        assertEquals(false, result);

    }

    @Test
    void testFindPerfectNumberWithinRange100() {
        Optional<List<Integer>> result = perfectnumberservice.FindPerfectNumberWithinRange(1, 100);
        assertEquals("Optional[[6, 28]]", result.toString());

    }

    @Test
    void testFindPerfectNumberWithinRange1000() {
        Optional<List<Integer>> result = perfectnumberservice.FindPerfectNumberWithinRange(1, 1000);
        assertEquals("Optional[[6, 28, 496]]", result.toString());
    }


}


