package com.jdar.store.providers.util.constants;

import lombok.Getter;

@Getter
public enum ErrorsEnum {

    // Providers
    ERROR_CREATING_PROVIDER("PE_001", "Error creating provider [%s]"),
    ERROR_SAVING_PROVIDER("PE_002", "Error saving provider %s. [%s]"),


    // Cities
    NO_CITIES_FOUND("CE_001", "City [%s] not found");

    private final String code;
    private final String description;

    ErrorsEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
