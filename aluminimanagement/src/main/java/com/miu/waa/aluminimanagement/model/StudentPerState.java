package com.miu.waa.aluminimanagement.model;

import lombok.Data;

@Data
public class StudentPerState {

    private  Long count;
    private String state;
    public StudentPerState(Long count, String state) {
        this.count = count;
        this.state = state;
    }
}
