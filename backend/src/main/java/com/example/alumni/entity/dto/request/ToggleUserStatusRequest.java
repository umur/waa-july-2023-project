package com.example.alumni.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ToggleUserStatusRequest {
    private Long userId;
    private Boolean enabled;
}
