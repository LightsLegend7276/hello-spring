package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="")
public class HelloController {

    @GetMapping("/")
    public String helloForm() {
        return "form";
    }

    // responds to /hello
    @GetMapping("hello")
    public String hello(@RequestParam String name, @RequestParam String language, Model model) {
        String greeting = createMessage(name, language);
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello-list")
    public String displayNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Papo");
        names.add("Crystal");
        names.add("Tuti");
        model.addAttribute("names", names);
        return "hello-list";
    }

    // responds to /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String helloGoodbye() {
        return "Hello, Goodbye";
    }

    private static String createMessage(String name, String language) {
        String greeting = "";
        if (language.toLowerCase().equals("english")) {
            greeting = "Hello, " + name +"!";
        } else if (language.toLowerCase().equals("spanish")) {
            greeting = "Hola, " + name + "!";
        } else if (language.toLowerCase().equals("french")) {
            greeting = "Bonjour, " + name + "!";
        } else if (language.toLowerCase().equals("italian")) {
            greeting = "Ciao, " + name + "!";
        } else if (language.toLowerCase().equals("greek"))  {
            greeting = "Χαίρετε, " + name + "!";
        }
        return greeting;
    }

//    private static String styleTheGreeting(String greeting) {
//        return "<html>" +
//                "<body>" +
//                "<h1 style='color:green'>" + greeting + "</h1>" +
//                "</body>" +
//                "</html>";
//    }
}
