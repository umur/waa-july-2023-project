package com.miu.waa.aluminimanagement.model.dto;

import lombok.Data;

@Data
public class AddressDto {
    private int id;
    private String city;
    private String state;
    private int zip;
    private String street;
}
