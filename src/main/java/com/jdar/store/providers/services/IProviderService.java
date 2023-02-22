package com.jdar.store.providers.services;

import com.jdar.store.providers.model.dto.request.ProviderRqDto;
import com.jdar.store.providers.model.dto.response.ProviderRsDto;

public interface IProviderService {

    ProviderRsDto createProvider(ProviderRqDto providerRqDto);

}
