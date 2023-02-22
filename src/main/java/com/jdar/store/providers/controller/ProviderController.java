package com.jdar.store.providers.controller;

import com.jdar.store.model.dto.DataResponse;
import com.jdar.store.providers.model.dto.request.ProviderRqDto;
import com.jdar.store.providers.model.dto.response.ProviderRsDto;
import com.jdar.store.providers.services.IProviderService;
import com.jdar.store.providers.util.constants.ResourceEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(ResourceEndpoint.PROVIDERS_ENDPOINT)
@RequiredArgsConstructor
public class ProviderController {

    private final IProviderService providerService;

    @PostMapping
    public DataResponse<ProviderRsDto> createProviderService(@Valid @RequestBody ProviderRqDto providerRqDto) {
        return DataResponse.<ProviderRsDto>builder().data(providerService.createProvider(providerRqDto)).build();
    }

}
