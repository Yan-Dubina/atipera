package com.example.atipera.services;

import com.example.atipera.dto.BranchDTO;
import com.example.atipera.dto.RepositoryDTO;
import org.kohsuke.github.GHRepository;

import java.util.List;

public interface SearchService {
    List<GHRepository> findAllRepositoriesForUser(String username);

    List<RepositoryDTO> findAllRepositoriesForUserByClient(String username);

    List<BranchDTO> getBranchesForRepository(RepositoryDTO repositoryDTO);
}
