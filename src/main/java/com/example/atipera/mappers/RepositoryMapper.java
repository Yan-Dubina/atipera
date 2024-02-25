package com.example.atipera.mappers;

import com.example.atipera.dto.RepositoryRecord;
import org.kohsuke.github.GHRepository;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {BranchMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RepositoryMapper {


    @Mapping(target = "repositoryName", source = "name")
    @Mapping(target = "ownerLogin", expression = "java(entity.getOwnerName())")
    RepositoryRecord toDto(GHRepository entity);

}
