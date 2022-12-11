package com.worldline.perfectnumber.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/**
 * This is a Response class which set the status code and response message for the validatePerfectNumber REST API call
 *
 **/
public class Response<T> extends ResponseEntity<T> {

    private Status status;
    private T payload;
    private String details;
    private static final String OK_MESSAGE = "Email send successfully";
    private static final String BAD_REQUEST_MESSAGE = "Please provide proper request payload";
    private static final String INTERNAL_SERVER_ERROR_MESSAGE = "Internal server error occurred";

    public Response(T payload, HttpStatus status) {
        super(payload, status);
    }

    public Response(HttpStatus status) {
        super(status);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public static Response<String> badRequests() {
        Response<String> response = new Response<String>(BAD_REQUEST_MESSAGE, HttpStatus.BAD_REQUEST);
        response.setStatus(Status.BAD_REQUEST);
        response.setDetails("Please provide proper payload");
        return response;
    }

    public static Response<String> okStatus(String result) {
        Response<String> response = new Response<String>(result, HttpStatus.OK);
        response.setDetails(result);
        response.setPayload(result);
        response.setStatus(Status.OK);
        return response;
    }

    public Response<String> internalServerErrors() {
        Response<String> response = new Response<String>(INTERNAL_SERVER_ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
        response.setStatus(Status.INTERNAL_SERVER_ERROR);
        return response;
    }





    public enum Status {
        OK, BAD_REQUEST, INTERNAL_SERVER_ERROR, UNAUTHORIZED, VALIDATION_EXCEPTION, EXCEPTION, WRONG_CREDENTIALS, ACCESS_DENIED, NOT_FOUND,
        DUPLICATE_ENTITY
    }
}