package com.optimagrowth.license.model.utils;

import com.optimagrowth.license.model.Posting;
import com.optimagrowth.license.model.dto.PostingView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostingViewMapper {
    PostingView toPostingView(Posting posting);
}

