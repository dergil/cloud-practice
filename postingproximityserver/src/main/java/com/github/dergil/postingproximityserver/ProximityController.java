package com.github.dergil.postingproximityserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class ProximityController {
    @Autowired
    private ProximityService service;

    @GetMapping(value="/find-nearby/")
    public ResponseEntity<Set<PostingSnippetDto>> getPosting(FindNearbyDto request) {
        return ResponseEntity.ok(service.getNearbyPostings(request));
    }
}
