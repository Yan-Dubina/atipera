package com.example.atipera.dto;

import java.util.Map;

public record RepositoryRecord(String repositoryName, String ownerLogin, Map<String, BranchRecord> branches) {
}
