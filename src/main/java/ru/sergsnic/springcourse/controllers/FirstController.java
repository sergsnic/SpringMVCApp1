package ru.sergsnic.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "numberA", required = false) Integer numberA,
                                 @RequestParam(value = "numberB", required = false) Integer numberB,
                                 @RequestParam("arithmeticOperation") String arithmeticOperation, Model model){

        // System.out.println("What are you doing? " + arithmeticOperation);
        try {
            switch (arithmeticOperation) {
                case "multiplication":
                    model.addAttribute("message",
                            numberA + " * " + numberB + " = " + (numberA * numberB));
                    break;
                case "addition":
                    model.addAttribute("message",
                            numberA + " + " + numberB + " = " + (numberA + numberB));
                    break;
                case "substraction":
                    model.addAttribute("message",
                            numberA + " - " + numberB + " = " + (numberA - numberB));
                    break;
                case "division":
                    model.addAttribute("message",
                            numberA + " / " + numberB + " = " + (numberA / (double)numberB));
                    break;
                default:
                    break;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "first/calculator";
    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname) {
        System.out.println("Hello, " +name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
