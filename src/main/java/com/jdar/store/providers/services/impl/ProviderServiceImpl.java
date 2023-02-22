package com.jdar.store.providers.services.impl;

import com.jdar.store.exceptions.clasification.servererror.TechnicalException;
import com.jdar.store.exceptions.clasification.successful.NoDataException;
import com.jdar.store.providers.dataprovider.jpa.entity.CityEntity;
import com.jdar.store.providers.dataprovider.jpa.entity.ProviderEntity;
import com.jdar.store.providers.dataprovider.jpa.repository.ICityRepository;
import com.jdar.store.providers.dataprovider.jpa.repository.IProviderRepository;
import com.jdar.store.providers.model.dto.request.ProviderRqDto;
import com.jdar.store.providers.model.dto.response.CityRsDto;
import com.jdar.store.providers.model.dto.response.ProviderRsDto;
import com.jdar.store.providers.model.dto.response.StateRsDto;
import com.jdar.store.providers.services.IProviderService;
import com.jdar.store.providers.util.constants.Constants;
import com.jdar.store.providers.util.constants.ErrorsEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements IProviderService {

    private final IProviderRepository providerRepository;
    private final ICityRepository cityRepository;

    @Override
    public ProviderRsDto createProvider(ProviderRqDto providerRqDto) {
        try {
            CityEntity cityEntity = cityRepository.findById(providerRqDto.getCityId())
                    .orElseThrow(() -> new NoDataException(String.format(ErrorsEnum.NO_CITIES_FOUND.getDescription(), providerRqDto.getCityId())));

            ProviderEntity providerEntityBuilder = buildProviderEntity(providerRqDto, cityEntity);
            return buildProviderResponse(providerEntityBuilder);
        } catch (Exception exception) {
            throw new TechnicalException(String.format(ErrorsEnum.ERROR_CREATING_PROVIDER.getDescription(), exception.getMessage()));
        }
    }

    private ProviderEntity buildProviderEntity(ProviderRqDto providerRqDto, CityEntity cityEntity) {
        return ProviderEntity.builder()
                .providerName(providerRqDto.getProviderName())
                .providerEmail(providerRqDto.getProviderEmail())
                .providerAddress(providerRqDto.getProviderAddress())
                .createDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .city(cityEntity)
                .build();
    }

    private ProviderRsDto buildProviderResponse(ProviderEntity providerEntityBuilder) {
        try {
            ProviderEntity providerEntitySaved = providerRepository.save(providerEntityBuilder);

            StateRsDto stateRsDto = StateRsDto.builder()
                    .id(providerEntitySaved.getCity().getState().getId())
                    .stateName(providerEntitySaved.getCity().getState().getStateName())
                    .build();

            CityRsDto cityRsDto = CityRsDto.builder()
                    .id(providerEntitySaved.getCity().getId())
                    .cityName(providerEntitySaved.getCity().getCityName())
                    .stateRsDto(stateRsDto)
                    .build();

            return ProviderRsDto.builder()
                    .id(providerEntitySaved.getId())
                    .providerName(providerEntitySaved.getProviderName())
                    .providerEmail(providerEntitySaved.getProviderEmail())
                    .providerAddress(providerEntitySaved.getProviderAddress())
                    .createdDate(providerEntitySaved.getCreateDate())
                    .updatedDate(providerEntitySaved.getUpdatedDate())
                    .cityRsDto(cityRsDto)
                    .build();
        } catch (Exception exception) {
            throw new TechnicalException(String.format(ErrorsEnum.ERROR_SAVING_PROVIDER.getDescription(),
                    providerEntityBuilder.getProviderEmail(), exception.getMessage()));
        }
    }

}