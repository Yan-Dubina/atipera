package com.example.atipera.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class RepositoryDTO {

    @JsonProperty("owner")
    private OwnerDTO owner;

    @JsonProperty
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean fork;

    @JsonProperty
    private List<BranchDTO> branches;

    @JsonProperty(value = "branches_url", access = JsonProperty.Access.WRITE_ONLY)
    private String branchesUrl;

}
