package com.lottevn.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lottevn.core.enums.ApiResultCodeEnum;
import com.lottevn.core.model.api.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ApiResultUtil {

    /**
     * Response Success
     * @param obj
     * @return
     */
    public static ResponseEntity<?> response(Object obj) {
        GenericResponse<Object> response = new GenericResponse<Object>();

        response.setError(ApiResultCodeEnum.SUCCESS.getCode());
        response.setMessage(ApiResultCodeEnum.SUCCESS.getMessage());
        response.setResult(obj);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Response Success Message
     * @param obj
     * @param message
     * @return
     */
    public static ResponseEntity<?> responseMessage(Object obj, String message) {
        GenericResponse<Object> response = new GenericResponse<Object>();

        response.setError(ApiResultCodeEnum.SUCCESS.getCode());
        response.setMessage(message);
        response.setResult(obj);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    /**
     * Response Error
     * @param status
     * @param message
     * @return
     */
    public static ResponseEntity<?> responseError(int status, String message) {
        GenericResponse<Object> response = new GenericResponse<Object>();

        response.setError(status);
        response.setMessage(message);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Response Error
     * @param status
     * @param message
     * @return
     */
    public static ResponseEntity<?> responseError(int status, String message, Object obj) {
        GenericResponse<Object> response = new GenericResponse<Object>();

        response.setError(status);
        response.setMessage(message);
        response.setResult(obj);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     *
     * @param status
     * @param message
     * @return
     */
    public static ResponseEntity<?> responseErrorUnauthorized(int status, String message) {
        GenericResponse<Object> response = new GenericResponse<Object>();

        response.setError(status);
        response.setMessage(message);

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    /**
     *
     * @param status
     * @param message
     * @return
     */
    public static ResponseEntity<?> responseErrorUnauthorized(int status, String message, Throwable e) {
        GenericResponse<Object> response = new GenericResponse<Object>();

        response.setError(status);
        response.setMessage(message);

        Map<String, String> errorMap = new HashMap<String, String>();
        /*
        if (e.getCause() != null) {
            e = e.getCause();
        }
        String errorLocalizedMessage = e.getLocalizedMessage();
        */

        errorMap.put("errorMessage", message);

        response.setResult(errorMap);

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    /**
     * Response Error
     * @param status
     * @param message
     * @param e
     * @return
     */
    public static ResponseEntity<?> responseError(int status, String message, Throwable e) {
        GenericResponse<Object> response = new GenericResponse<Object>();

        response.setError(status);
        response.setMessage(message);

        Map<String, String> errorMap = new HashMap<String, String>();
        if (e.getCause() != null) {
            e = e.getCause();
        }
        String errorLocalizedMessage = e.getLocalizedMessage();

        errorMap.put("errorMessage", e.getMessage());

        response.setResult(errorMap);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     *
     * @param status
     * @param message
     * @return
     */
    public static String responseFilterError(int status, String message, String description) {
        ObjectMapper om = new ObjectMapper();
        String returnString = "";

        try {
            GenericResponse<Object> response = new GenericResponse<Object>();

            response.setError(status);
            response.setMessage(message);

            Map<String, String> errorMap = new HashMap<String, String>();

            errorMap.put("errorMessage", description);

            response.setResult(errorMap);

            returnString = om.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }

        return returnString;
    }

}
