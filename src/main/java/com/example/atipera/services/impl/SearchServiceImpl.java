package com.example.atipera.services.impl;

import com.example.atipera.dto.BranchDTO;
import com.example.atipera.dto.RepositoryDTO;
import com.example.atipera.enums.Postfix;
import com.example.atipera.services.SearchService;
import com.example.atipera.utils.UrlUtils;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {
    @Value("${token}")
    private String token;

    @Autowired
    private RestClient restClient;


    @Override
    public List<RepositoryDTO> findAllRepositoriesForUserByClient(String username) {
        RepositoryDTO[] repositories = findRepositories(username);
        return Arrays.stream(repositories)
                .filter(rep -> !rep.isFork())
                .peek(this::fillBranchesOnRepository)
                .collect(Collectors.toList());
    }


    @Override
    public List<GHRepository> findAllRepositoriesForUser(String username) {
        try {
            GitHub gitHub = GitHub.connectUsingOAuth(token);
            GHUser user = gitHub.getUser(username);
            return user.listRepositories().toList();
        } catch (IOException e) {
            throw new HttpStatusCodeException(HttpStatus.NOT_FOUND) {
            };
        }
    }

    @Override
    public List<BranchDTO> getBranchesForRepository(RepositoryDTO repositoryDTO) {
        return List.of(findBranches(UrlUtils.removePostfixFromUrls(repositoryDTO.getBranchesUrl(), Postfix.Branch)));
    }

    private RepositoryDTO[] findRepositories(String username) {
        return restClient
                .get()
                .uri(UrlUtils.REPO_URL_TEMPLATE, username)
                .header(HttpHeaders.AUTHORIZATION, token)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(RepositoryDTO[].class);
    }

    private BranchDTO[] findBranches(String url) {
        return restClient
                .get()
                .uri(url)
                .header(HttpHeaders.AUTHORIZATION, token)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(BranchDTO[].class);
    }


    private void fillBranchesOnRepository(RepositoryDTO repositoryDTO) {
        repositoryDTO.setBranches(getBranchesForRepository(repositoryDTO));
    }
}
