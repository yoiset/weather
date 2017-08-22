package com.yoiset.weather.app.controller.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by yoisetlopez on 8/21/17.
 */
@Controller
public class WeatherController {

    private static final Logger logger = Logger.getLogger(WeatherController.class);

    @RequestMapping("/")
    public String index(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {

        model.addAttribute("name", name);
        logger.info("calling spring mvc Controller " + "/");

        return "index";
    }
}
