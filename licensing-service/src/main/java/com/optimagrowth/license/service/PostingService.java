package com.optimagrowth.license.service;

import com.optimagrowth.license.model.Posting;
import com.optimagrowth.license.model.dto.*;
import com.optimagrowth.license.model.utils.PostingEditMapper;
import com.optimagrowth.license.model.utils.PostingViewMapper;
import com.optimagrowth.license.repository.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostingService {
    @Autowired
    private PostingRepository repository;
    @Autowired
    private PostingEditMapper postingEditMapper;
    @Autowired
    private PostingViewMapper postingViewMapper;


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

}
