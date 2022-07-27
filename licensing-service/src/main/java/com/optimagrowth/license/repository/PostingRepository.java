package com.optimagrowth.license.repository;

import com.optimagrowth.license.model.Posting;
import com.optimagrowth.license.model.exception.EntryNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingRepository extends CrudRepository<Posting, Long> {
    default Posting getPostingById(long id) {
        return findById(id).orElseThrow(() -> new EntryNotFoundException(Posting.class, id));
    }
}
