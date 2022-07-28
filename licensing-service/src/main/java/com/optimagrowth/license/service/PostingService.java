package com.optimagrowth.license.service;

import com.optimagrowth.license.model.Posting;
import com.optimagrowth.license.model.dto.*;
import com.optimagrowth.license.model.utils.PostingEditMapper;
import com.optimagrowth.license.model.utils.PostingSnipperDtoMapper;
import com.optimagrowth.license.model.utils.PostingViewMapper;
import com.optimagrowth.license.repository.PostingRepository;
import com.optimagrowth.license.util.GeoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class PostingService implements PostingServiceInterface{
    @Autowired
    private PostingRepository repository;
    @Autowired
    private PostingEditMapper postingEditMapper;
    @Autowired
    private PostingViewMapper postingViewMapper;
    @Autowired
    private PostingSnipperDtoMapper postingSnipperDtoMapper;

    @Transactional
    public PostingView createPosting(CreatePostingDto request) {
        Posting car = postingEditMapper.create(request);
        repository.save(car);
        PostingView carView = postingViewMapper.toPostingView(car);
//        log.info("Returning: " + carView.toString());
        return carView;
    }

    @Transactional
    public PostingView updatePosting(EditPostingDto request) {
        Posting updatedPosting = new Posting();
        postingEditMapper.update(request, updatedPosting);
        Posting savedPosting = repository.save(updatedPosting);
        PostingView carView = postingViewMapper.toPostingView(savedPosting);
//        log.info("Returning: " + carView.toString());
        return carView;
    }

    @Transactional
    public void delete(DeletePostingDto request) {
        repository.deleteById(request.getId());
    }

    @Transactional
    public PostingView get(ReadPostingDto request) {
        Posting posting = repository.getPostingById(request.getId());
        return postingViewMapper.toPostingView(posting);
    }

    @Transactional
    public Set<PostingSnippetDto> getNearbyPostings(FindNearbyDto findNearbyDto) {
        Set<PostingSnippetDto> nearbyPostings = new HashSet<>();
        for (Posting posting : repository.findAll()) {
            if (GeoUtil.distance(posting.getLongitude(), posting.getLatitude(), findNearbyDto.getLongitude(), findNearbyDto.getLatitude(), 'K') < MAX_DISTANCE)
                nearbyPostings.add(postingSnipperDtoMapper.toPostingSnippetDto(posting));
        }
        return nearbyPostings;
    }





}
