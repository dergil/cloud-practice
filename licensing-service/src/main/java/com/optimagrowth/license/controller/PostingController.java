package com.optimagrowth.license.controller;

import com.optimagrowth.license.model.License;
import com.optimagrowth.license.model.Posting;
import com.optimagrowth.license.model.dto.*;
import com.optimagrowth.license.model.utils.PostingSnipperDtoMapper;
import com.optimagrowth.license.model.utils.PostingViewMapper;
import com.optimagrowth.license.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class PostingController {

    @Autowired
    private PostingService service;

    @GetMapping(value="/{postingId}")
    public ResponseEntity<PostingView> getPosting(@PathVariable("postingId") Long postingId) {
        return ResponseEntity.ok(service.get(new ReadPostingDto(postingId)));
    }



    @PutMapping
    public ResponseEntity<PostingView> updatePosting(@RequestBody EditPostingDto request) {
        return ResponseEntity.ok(service.updatePosting(request));
    }

    @PostMapping
    public ResponseEntity<PostingView> createPosting(@RequestBody CreatePostingDto request) {
        return ResponseEntity.ok(service.createPosting(request));
    }

    @DeleteMapping(value="/{postingId}")
    public ResponseEntity deleteLicense(@PathVariable("postingId") DeletePostingDto request) {
        service.delete(request);
        return ResponseEntity.ok().build();
    }
}
