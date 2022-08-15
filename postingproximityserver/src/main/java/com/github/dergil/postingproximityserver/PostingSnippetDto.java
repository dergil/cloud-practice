package com.github.dergil.postingproximityserver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostingSnippetDto {
    private Long postingId;
    private Double longitude;
    private Double latitude;
    private String title;
    private String textSnippet;

}
