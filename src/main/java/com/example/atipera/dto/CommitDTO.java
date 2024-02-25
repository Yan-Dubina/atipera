package com.example.atipera.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommitDTO {

    @JsonProperty
    private String sha;
}
