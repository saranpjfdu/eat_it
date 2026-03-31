package com.example.eat_it.common.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private Long id;
    private String fullAddress;
    private String city;
    private String state;
    private String pincode;
    private String landmark;
    private String type;
    private Boolean isDefault;
}