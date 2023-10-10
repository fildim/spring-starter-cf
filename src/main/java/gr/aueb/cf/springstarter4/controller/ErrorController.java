package gr.aueb.cf.springstarter4.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = {RuntimeException.class})
    public String handleBadRequest(RuntimeException e, Model model) {
        model.addAttribute("msg", "Runtime exception: " + e.getMessage());
        return "error";
    }

    @ExceptionHandler(value = {Exception.class})
    public String handleBadRequest(Exception e, Model model) {
        model.addAttribute("msg", "Exception: " + e.getMessage());
        return "error";
    }
}
