package com.springbootwebflux.pojo;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Airline {
    private Integer id;
    private String airline;
    private String logo;
    private String slogan;
    private String head_quaters;
    private String website;
    private String established;
}
