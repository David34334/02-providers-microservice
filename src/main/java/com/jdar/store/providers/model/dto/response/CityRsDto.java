package com.jdar.store.providers.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityRsDto {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("state")
    private StateRsDto stateRsDto;

}
