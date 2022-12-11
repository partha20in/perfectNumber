package com.worldline.perfectnumber.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;


/**
 * This is an Utility class named ValidateUtil containing validateRequest method for checking valid email address , subject and content
 **/
public class ValidateUtil {

    private ValidateUtil() {
    }

    private static final String REQUIRED = "required";
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateUtil.class);


    public static boolean validate(String num) {
        boolean result = false;
        if (StringUtils.hasLength(num)) {
            if (isNumeric(num)) {
                result = true;
            }
        } else {
            result = false;
        }
        return result;
    }

    public static boolean isNumeric(String number) {
        // Checks if the provided string
        // is a numeric by applying a regular
        // expression on it.
        String regex = "[0-9]+[\\.]?[0-9]*";
        return Pattern.matches(regex, number);
    }
}
