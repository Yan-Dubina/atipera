package com.example.atipera.mappers;

import com.example.atipera.dto.BranchRecord;
import org.kohsuke.github.GHBranch;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.io.IOException;
import java.util.Map;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BranchMapper {
    BranchRecord toDto(GHBranch entity);

    Map<String, BranchRecord> toDto(Map<String, GHBranch> entity) throws IOException;

}
