package com.example.hellospring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by lonny on 5/18/2017.
 */
@Controller

public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {
        HashMap<String, String> langs = new HashMap<>();
        langs.put("English", "Hello");
        langs.put("French", "Bonjour");
        langs.put("Spanish", "Hola");
        langs.put("Italian", "Ciao");
        langs.put("German", "Guten Tag");
        String name = request.getParameter("name");
        String language = request.getParameter("language");
        if (name == null) {
            name = "World";
        }
        if (language == null) {
            language = "English";
        }
        return langs.get(language) +" " + name+"!";
    }

        @RequestMapping(value = "hello", method = RequestMethod.GET)
        @ResponseBody
        public String helloForm(){

            String html = "<form method='post'>" +
                    "<input type='text' name='name' />" +
                    "<select name='language'>" +
                    "<option value='English' selected>English</option>" +
                    "<option value='French'>French</option>"+
                    "<option value='Italian'>Italian</option>"+
                    "<option value='Spanish'>Spanish</option>"+
                    "<option value ='German'>German</option>"+
                    "</select>"+
                    "<input type='submit' value='Greet Me!' />" +
                    "</form>";

            return html;
        }
        @RequestMapping(value ="hello", method = RequestMethod.POST)
        @ResponseBody
        public String helloPost(HttpServletRequest request) {

            HashMap<String, String> langs = new HashMap<>();
            langs.put("English", "Hello");
            langs.put("French", "Bonjour");
            langs.put("Spanish", "Hola");
            langs.put("Italian", "Ciao");
            langs.put("German", "Guten Tag");
            String name = request.getParameter("name");
            String language = request.getParameter("language");
            if (name == null) {
                name = "World";
            }
            if (language == null) {
                language = "English";
            }
            return langs.get(language) +" " + name+"!";


        }
        @RequestMapping(value = "hello/{name}")
        @ResponseBody
        public String helloUrlSegment(@PathVariable String name) {

            return "Hello " + name;

        }
    @RequestMapping(value= "goodbye")

    public String goodbye() {
        return "redirect:/";
    }
}
