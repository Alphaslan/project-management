package com.jrp.pma.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AppErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int errorCode = Integer.parseInt(status.toString());
            switch (errorCode) {
                case 404:
                    return "errorpages/error-404";
                case 403:
                    return "errorpages/error-403";
                case 500:
                    return "errorpages/error-500";
            }
        }
        return "errorpages/error";
    }
}
