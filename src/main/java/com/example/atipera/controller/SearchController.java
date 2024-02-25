package com.example.atipera.controller;

import com.example.atipera.dto.RepositoryDTO;
import com.example.atipera.dto.RepositoryRecord;
import com.example.atipera.mappers.RepositoryMapper;
import com.example.atipera.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private RepositoryMapper repositoryMapper;

    @GetMapping("library/{username}")
    public List<RepositoryRecord> findAllRepositoriesForUserUsedLib(@PathVariable String username) {
        return searchService.findAllRepositoriesForUser(username).stream()
                .map(repositoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("client/{username}")
    public List<RepositoryDTO> findAllRepositoriesForUserUsedClient(@PathVariable String username) {
        List<RepositoryDTO> list = searchService.findAllRepositoriesForUserByClient(username);
        return list;
    }

}
