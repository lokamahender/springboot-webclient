package com.springbootwebflux.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passenger {
    private String name;
    private Integer trips;
    private Integer airline;
}
