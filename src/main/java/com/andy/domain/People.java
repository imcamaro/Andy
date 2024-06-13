package com.andy.domain;

import lombok.Data;

import java.util.Date;

@Data
public class People {

    private String name;

    private String weight;

    private String height;

    private String gender;

    private Date birthday;

    private String nationality;

}
