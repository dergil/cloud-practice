package com.optimagrowth.license.model.utils;

import com.optimagrowth.license.model.Posting;
import com.optimagrowth.license.model.dto.PostingSnippetDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostingSnipperDtoMapper {
    PostingSnippetDto toPostingSnippetDto(Posting posting);
}
