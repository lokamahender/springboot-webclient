package com.springbootwebflux.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/get/airline")
public class UserController {

    @GetMapping("/details/{id}")
    public Mono<String> getDetails(@PathVariable("id") int id){

     return WebClient.create()
                .get()
                .uri("https://api.instantwebtools.net/v1/airlines/"+id)
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/testConnection")
    public String testConnection(){

        JSONObject obj = new JSONObject();
        obj.put("statusCode",0);
        obj.put("statusMessage","app is responding");

        return obj.toString();
    }
}
