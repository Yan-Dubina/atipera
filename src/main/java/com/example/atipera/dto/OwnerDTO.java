package com.example.atipera.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OwnerDTO {
    @JsonProperty
    private String login;
}
