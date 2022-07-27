package com.optimagrowth.license.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostingDto {
    private Double longitude;
    private Double latitude;
    private String title;
    private String text;
    private String textSnippet;
    private Boolean contactable;
}
