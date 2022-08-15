package com.github.dergil.postingproximityserver;

import com.github.dergil.postingproximityserver.util.GeoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class ProximityService {
    @Autowired
    private PostingSnippetDtoMapper postingSnippetDtoMapper;
    @Autowired
    private PostingSnippetRepository repository;
    float MAX_DISTANCE = 1000;

    @Transactional
    public Set<PostingSnippetDto> getNearbyPostings(FindNearbyDto findNearbyDto) {
        Set<PostingSnippetDto> nearbyPostings = new HashSet<>();
        for (PostingSnippet posting : repository.findAll()) {
            if (GeoUtil.distance(posting.getLongitude(), posting.getLatitude(), findNearbyDto.getLongitude(), findNearbyDto.getLatitude(), 'K') < MAX_DISTANCE)
                nearbyPostings.add(postingSnippetDtoMapper.toPostingSnippetDto(posting));
        }
        return nearbyPostings;
    }
}
