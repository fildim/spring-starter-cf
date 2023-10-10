package gr.aueb.cf.springstarter4.controller;

import gr.aueb.cf.springstarter4.dto.StudentInsertDTO;
import gr.aueb.cf.springstarter4.validator.StudentInsertValidator;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Date;

@Controller
//@RequestMapping("/hello-app")
public class HelloController {

    private final StudentInsertValidator studentInsertValidator;

    @Autowired
    public HelloController(StudentInsertValidator studentInsertValidator) {
        this.studentInsertValidator = studentInsertValidator;
    }

    //@RequestMapping(path = "/coding-factory", method = RequestMethod.GET)
    @GetMapping("/coding-factory")
    public String getHello() {
        return "index";
    }

    @GetMapping("/get-date")
    public String getDate(Model model) {
        model.addAttribute("dateTxt", new Date());
        return "date";
    }

    @GetMapping("/messages")
    public String getMessage(@RequestParam("title") String title, Model model) {
        if (title.equals("CF")) {
            model.addAttribute("message", "Hello CF");
            return "message";
        } else {
            model.addAttribute("msg", "There is an error in request param");
            return "error";
        }
    }

    @RequestMapping(path = "/student/insert", method = RequestMethod.GET)
    public String getStudentForm(Model model) {
        model.addAttribute("studentInsertDto", new StudentInsertDTO());
        return "student/insert";
    }

    @RequestMapping(path = "/student/insert", method = RequestMethod.POST)
    public String insertStudent(@Valid @ModelAttribute("studentInsertDto") StudentInsertDTO dto, BindingResult bindingResult, Model model) {
        studentInsertValidator.validate(dto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "student/insert";
        }

        model.addAttribute("dto", dto);
        return "student/success";
    }

}
