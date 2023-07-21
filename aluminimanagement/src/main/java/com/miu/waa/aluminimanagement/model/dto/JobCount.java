package com.miu.waa.aluminimanagement.model.dto;

import lombok.Data;

@Data
public class JobCount {
    Long count;
    String address;
    public JobCount(Long count,String city, String state){
        this.count=count;
        this.address= city + ", "+ state;
    }
}
