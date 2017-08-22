package com.yoiset.weather.app.controller.rest;

import com.yoiset.weather.app.service.WeatherService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by yoisetlopez on 8/21/17.
 */

@RestController
@RequestMapping("/weather")
public class WeatherRest {

    private static final Logger logger = Logger.getLogger(WeatherRest.class);

    @Value("${welcome.message:test}")
    private String message = "Hello Interval";

    @Autowired
    private WeatherService service;

    @RequestMapping(path = "/{city}", method = RequestMethod.GET)
    public List<Map> getWeather(@PathVariable("city") String city) throws Exception {

        logger.info("Calling Rest Weather with city = " + city);

        try{
            List<Map> cities = service.getCities();

            if(city == null) return cities;

            // returning cities
            return cities.stream().filter(element -> ((String)element.get("city")).equalsIgnoreCase(city)).collect(Collectors.toList());

        }catch (Exception e) {
            logger.error("Error calling weather endpoint");
            throw e;
        }
    }
}
