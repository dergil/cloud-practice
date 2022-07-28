package com.optimagrowth.license.service;

import com.optimagrowth.license.model.dto.*;

import java.util.Set;

public interface PostingServiceInterface {
    float MAX_DISTANCE = 1000;
    public PostingView createPosting(CreatePostingDto request);
    public PostingView updatePosting(EditPostingDto request);
    public void delete(DeletePostingDto request);
    public PostingView get(ReadPostingDto request);
    public Set<PostingSnippetDto> getNearbyPostings(FindNearbyDto findNearbyDto);

}
