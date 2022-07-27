package com.optimagrowth.license.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditPostingDto {
    private Long postingId;
    private Double longitude;
    private Double latitude;
    private String title;
    private String text;
    private String textSnippet;
    private Boolean contactable;
}
