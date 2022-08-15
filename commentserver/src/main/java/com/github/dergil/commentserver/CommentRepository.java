package com.github.dergil.commentserver;

import com.github.dergil.postingproximityserver.exception.EntryNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    default Comment getPostingSnippetById(long id) {
        return findById(id).orElseThrow(() -> new EntryNotFoundException(PostingSnippet.class, id));
    }
}
