package com.github.dergil.postingproximityserver;

import com.github.dergil.postingproximityserver.exception.EntryNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingSnippetRepository extends CrudRepository<PostingSnippet, Long> {
    default PostingSnippet getPostingSnippetById(long id) {
        return findById(id).orElseThrow(() -> new EntryNotFoundException(PostingSnippet.class, id));
    }
}
