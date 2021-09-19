package com.springbootwebflux.controller;

import com.springbootwebflux.pojo.Passenger;

import com.springbootwebflux.pojo.PassengerResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


/**
 * @author mahenderloka
 */

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    Logger logger =  LoggerFactory.getLogger(PassengerController.class);


    @Autowired
    private WebClient.Builder webClient;

    @PostMapping("/details")
    public Mono<String> getPassengerDetails(@RequestBody Passenger passenger){

        logger.info("--- API Request --- "+ passenger.getName());

        return webClient
                .build()
                .post()
                .uri("https://api.instantwebtools.net/v1/passenger")
                .body(Mono.just(passenger), Passenger.class)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);
    }

    @PostMapping("/details/modify")
    public PassengerResponse modifyPassengerDetails(@RequestBody Passenger passenger){

        logger.info("--- API Request --- "+ passenger.getName());

            PassengerResponse result = webClient
                    .build()
                    .post()
                    .uri("https://api.instantwebtools.net/v1/passenger")
                    .body(Mono.just(passenger), Passenger.class)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(PassengerResponse.class)
                    .block();

            logger.info("--- actual response --- "+ result);

            return result;
    }
}
