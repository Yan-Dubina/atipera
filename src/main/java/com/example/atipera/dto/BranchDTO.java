package com.example.atipera.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BranchDTO {

    private String name;

    @JsonProperty
    private CommitDTO commit;
}
