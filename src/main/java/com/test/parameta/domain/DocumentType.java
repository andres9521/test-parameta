package com.test.parameta.domain;

public enum DocumentType {

    CEDULA("Cedula"),
    TARJETA_DE_IDENTIDAD("Tarjeta de identidad"),
    PASAPORTE("Pasaporte");

    private final String value;

    DocumentType(String value) {
        this.value = value;
    }
}
