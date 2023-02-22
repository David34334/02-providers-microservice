package com.jdar.store.providers.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProviderRsDto {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("provider_name")
    private String providerName;

    @JsonProperty("provider_email")
    private String providerEmail;

    @JsonProperty("provider_address")
    private String providerAddress;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;

    @JsonProperty("city")
    private CityRsDto cityRsDto;

}
