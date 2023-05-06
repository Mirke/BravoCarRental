package com.bravo.gruppbravowigellkoncernencarrental.rules.enums;

public enum ValidationRules {
    FIRST_NAME_LENGHT(30),
    LAST_NAME_LENGHT(30),
    STREET_ADDRESS_LENGHT(30),
    POST_CODE_LENGHT(6),
    CITY_LENGHT(30),
    EMAIL_LENGHT(45),
    PHONE_NUMBER_LENGHT(12),
    
    
    TYPE_NAME(1),
    TYPE_EMAIL(2),
    TYPE_ADDRESS(3),
    TYPE_POSTAL_CODE(4),
    TYPE_PHONE(5),
    TYPE_CITY(6);

    private final int value;

    ValidationRules(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
