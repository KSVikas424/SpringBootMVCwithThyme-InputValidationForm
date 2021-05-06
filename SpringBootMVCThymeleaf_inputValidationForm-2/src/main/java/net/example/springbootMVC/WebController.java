package net.example.springbootMVC;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer {


    private static final Logger logger = LoggerFactory.getLogger(WebController.class);
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	logger.debug("addViewControllers()");
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(PersonForm personForm) {
    	logger.debug("showForm");
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
    	logger.debug("checkPersonInfo");
        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }
}