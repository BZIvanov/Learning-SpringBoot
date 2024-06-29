package com.example.mvcdemo;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // lastName is required, but we can still submit with only white spaces and here we will make sure only white spaces won't work
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("employee", new Employee());

        return "home";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "home";
        }

        return "employee-confirmation";
    }
}
