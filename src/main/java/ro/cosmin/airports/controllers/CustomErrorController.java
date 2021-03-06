package ro.cosmin.airports.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {


    @RequestMapping("/error")
    public String manageErrors(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "404-error";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "500-error";
            } else if (statusCode == HttpStatus.BAD_REQUEST.value()) {
                return "400-error";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                return "403-error";
            } else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
                return "405-error";
            }
        }
        return "error";
    }
}
