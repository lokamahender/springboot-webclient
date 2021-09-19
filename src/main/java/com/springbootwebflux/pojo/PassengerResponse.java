package com.springbootwebflux.pojo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PassengerResponse {
    private String _id;
    private Integer trips;
    private String name;
    private Integer __v;
    private List<Airline> airline;
}