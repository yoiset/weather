package com.yoiset.weather.app.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;


/**
 * Created by yoisetlopez on 8/21/17.
 */
@Service
public class WeatherService {

    private static final Logger logger = Logger.getLogger(WeatherService.class);

    private static RestTemplate restTemplate = new RestTemplate();

    @Value("${weather.endpoint.url}")
    private String url;

    public List<Map> getCities(){

        Map myObject = restTemplate.getForObject(url, Map.class);

        return (List<Map>) ((Map)myObject.get("response")).get("results");
    }
}
