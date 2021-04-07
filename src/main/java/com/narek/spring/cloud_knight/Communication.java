package com.narek.spring.cloud_knight;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.narek.spring.cloud_knight.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Configuration
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

   // private final String URL = "http://localhost:8080/spring_course_rest/api/employees/";
    //private final String URL = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=7984a23014928462576b56060f5faadb";






//    public List<Employee> getWeatherFromCity(){
//
//
//
//
//        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET,
//                null, new ParameterizedTypeReference<List<Employee>>() {});
//
//
//        List<Employee> allEmployees = responseEntity.getBody();
//
//
//        return allEmployees;
//
//    }



}
