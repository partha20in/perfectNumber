package com.worldline.perfectnumber.controller;

import com.worldline.perfectnumber.response.Response;
import com.worldline.perfectnumber.service.PerfectNumberSearchService;
import com.worldline.perfectnumber.util.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This is a Controller class containing PerfectNumber finder REST API  .
 **/
@RestController
@RequestMapping("/app")
public class PerfectNumberSearchController {
    @Autowired
    PerfectNumberSearchService perfectNumberSearchService;
    @Autowired
    private Environment env;
    private static final Logger LOGGER = LoggerFactory.getLogger(PerfectNumberSearchController.class);
    private static final String PERFECT_NUMBER = "perfect.number";
    private static final String NON_PERFECT_NUMBER = "non.perfect.number";

    /**
     * Validate Perfect number REST API
     *
     * @param number
     * @return - Response
     */
    @GetMapping("/api/v1/perfectNumbers/{number}")
    public Response<String> validateNumber(@PathVariable("number") String number) {
        LOGGER.debug("In sendEmail method in PerfectNumberSearchController");

        Response<String> response = null;

        if (!ValidateUtil.validate(number)) {
            LOGGER.debug("Request payload is not proper");
            response = Response.badRequests();

        } else {
            Integer num = Integer.parseInt(number);
            boolean val = perfectNumberSearchService.FindPerfectNumber(num);
            if (val) {
                String statusMessagePerfect = env.getProperty(PERFECT_NUMBER);
                response = Response.okStatus(statusMessagePerfect);
            } else {
                String statusMessageNonPerfect = env.getProperty(NON_PERFECT_NUMBER);
                response = Response.okStatus(statusMessageNonPerfect);
            }
        }


        LOGGER.info("Request send to perfectNumberHandler service");
        return response;

    }

    /**
     * Validate Perfect number within ranges REST API
     *
     * @param startNumber
     * @param endNumber
     * @return - Response
     */
    @GetMapping("/api/v1/perfectNumbersRange/startNumber/{startnumber}/endNumber/{endNumber}")
    public Response<String> validateNumberRange(@PathVariable("startnumber") String startNumber, @PathVariable("endNumber") String endNumber) {
        LOGGER.debug("In sendEmail method in PerfectNumberSearchController");

        Response<String> response = null;

        if (!ValidateUtil.validate(startNumber)) {
            LOGGER.debug("Request payload is not proper for startNumber");
            response = Response.badRequests();

        } else if (!ValidateUtil.validate(endNumber)) {
            LOGGER.debug("Request payload is not proper for endNumber");
            response = Response.badRequests();
        } else {
            Integer startNum = Integer.parseInt(startNumber);
            Integer endNum = Integer.parseInt(endNumber);
            Optional<List<Integer>> listNum = perfectNumberSearchService.FindPerfectNumberWithinRange(startNum, endNum);
            List<Integer> finalList = listNum.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
            String listNumbers = "List of perfect Numbers are" + finalList;
            response = Response.okStatus(listNumbers);
        }


        LOGGER.info("Request send to perfectNumberHandler service");
        return response;

    }
}