package com.optimagrowth.license.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindNearbyDto {
    private Float longitude;
    private Float latitude;
}
