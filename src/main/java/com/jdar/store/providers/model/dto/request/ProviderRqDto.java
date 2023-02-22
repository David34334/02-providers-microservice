package com.jdar.store.providers.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jdar.store.providers.util.constants.Constants;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProviderRqDto {

    @JsonProperty("provider_name")
    @NotBlank(message = Constants.PROVIDER_NAME_VALIDATION)
    private String providerName;

    @JsonProperty("provider_email")
    @Email(message = Constants.PROVIDER_EMAIL_VALIDATION, regexp = "[a-z0-9\\.\\-\\_]+@[a-z0-9\\-]+\\.[a-z]{2,5}")
    private String providerEmail;

    @JsonProperty("provider_address")
    @NotBlank(message = Constants.PROVIDER_ADDRESS_VALIDATION)
    private String providerAddress;

    @JsonProperty("provider_city")
    @NotNull(message = Constants.PROVIDER_CITY_ID_VALIDATION)
    private UUID cityId;

}
