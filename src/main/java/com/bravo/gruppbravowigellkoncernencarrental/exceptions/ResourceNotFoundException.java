package com.bravo.gruppbravowigellkoncernencarrental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <code>ResourceNotFoundException</code> - Used in case entity doesn't exist
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException{

    // -----------------------------------------------------------------------------------------------------------------
    //   Properties
    // -----------------------------------------------------------------------------------------------------------------

    private static final long serialVersionUID = 1L;
    private String name;
    private String field;
    private Object value;

    // -----------------------------------------------------------------------------------------------------------------
    //   Constructors
    // -----------------------------------------------------------------------------------------------------------------

    public ResourceNotFoundException(String name, String field, Object value) {
        super(String.format("%s not found with : '%s", name, field, value));
        this.name = name;
        this.field = field;
        this.value = value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    //   Methods
    // -----------------------------------------------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public String getField() {
        return field;
    }

    public Object getValue() {
        return value;
    }
}


