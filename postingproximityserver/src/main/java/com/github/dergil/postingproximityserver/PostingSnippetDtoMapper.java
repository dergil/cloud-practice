package com.github.dergil.postingproximityserver;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostingSnippetDtoMapper {
    PostingSnippetDto toPostingSnippetDto(PostingSnippet posting);
}
