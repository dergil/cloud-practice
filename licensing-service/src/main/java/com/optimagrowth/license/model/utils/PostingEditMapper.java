package com.optimagrowth.license.model.utils;

import com.optimagrowth.license.model.Posting;
import com.optimagrowth.license.model.dto.CreatePostingDto;
import com.optimagrowth.license.model.dto.EditPostingDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface PostingEditMapper {
    Posting create(CreatePostingDto request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS, nullValuePropertyMappingStrategy = IGNORE)
    void update(EditPostingDto request, @MappingTarget Posting posting);
}
