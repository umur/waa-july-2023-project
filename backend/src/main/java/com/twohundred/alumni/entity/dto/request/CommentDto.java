package com.twohundred.alumni.entity.dto.request;

import lombok.Data;

@Data
public class CommentDto {
    private String comment;
    private Long studentId;
}
