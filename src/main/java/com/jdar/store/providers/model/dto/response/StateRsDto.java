package com.jdar.store.providers.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StateRsDto {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("state_name")
    private String stateName;

}
