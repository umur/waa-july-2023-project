package com.alumni.dtos.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class AttachmentDTO {
    public String type;
    public byte[] data;
}
