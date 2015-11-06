package lv.test.app.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by artyom on 15.6.11.
 */

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(DataAccessException.class)
    public ModelAndView handleDataBaseErrors(DataAccessException e) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("error", e.getLocalizedMessage());

        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public String handleAllErrors(Exception e) {
        return "error";
    }
}
