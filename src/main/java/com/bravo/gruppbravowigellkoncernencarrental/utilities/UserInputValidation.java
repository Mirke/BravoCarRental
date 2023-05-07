package com.bravo.gruppbravowigellkoncernencarrental.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CustomerDto;
import com.bravo.gruppbravowigellkoncernencarrental.rules.enums.ValidationRules;

/**
 * <code>UserInputValidation</code> - Class for validating input
 * 
 * @authors Jessica
 * @version 0.0.1
 */

public class UserInputValidation {

    protected static Integer parseIntOrNull(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public class CustomerValidation {

        public List<String> CustomerFieldValidation(CustomerDto dto) {

            List<String> messages = new ArrayList<>();
            messages = Validation(dto, messages);

            return messages;
        }

        private boolean LenghtValidation(int rule, String stringValue) {

            boolean isValid = true;
            if (stringValue == null
                    || stringValue.isEmpty()
                    || stringValue.trim().isEmpty()
                    || stringValue.length() > rule) {
                isValid = false;
            }
            return isValid;
        }

        private boolean contentValidation(int rule, String stringValue) {
            boolean isValid = false;
            Pattern pattern = null;
            // Character not allowed filter
            if (ValidationRules.TYPE_NAME.getValue() == rule) {
                pattern = Pattern.compile("[^a-zA-Z]");
            } else if (ValidationRules.TYPE_ADDRESS.getValue() == rule) {
                pattern = Pattern.compile("[^a-zA-Z0-9]");
            } else if (ValidationRules.TYPE_CITY.getValue() == rule) {
                pattern = Pattern.compile("[^a-zA-Z]");
            } else if (ValidationRules.TYPE_EMAIL.getValue() == rule) {

            } else if (ValidationRules.TYPE_PHONE.getValue() == rule) {
                pattern = Pattern.compile("[^0-9]");
            } else if (ValidationRules.TYPE_POSTAL_CODE.getValue() == rule) {
                pattern = Pattern.compile("[^0-9]");
            }

            Matcher match = pattern.matcher(stringValue);
            boolean hasMatch = match.find();
            if (!hasMatch) {
                isValid = true;
            }
            return isValid;
        }

        private List<String> Validation(CustomerDto dto, List<String> messages) {

            if (LenghtValidation(ValidationRules.FIRST_NAME_LENGHT.getValue(), dto.getFirstName())) {
                if (!contentValidation(ValidationRules.TYPE_NAME.getValue(), dto.getFirstName())) {
                    messages.add(UserMessages.customerFirstNameLenghtAlowedCharacters);
                }
            } else {
                messages.add(UserMessages.customerFirstNameAlowedLenght);
            }

            if (LenghtValidation(ValidationRules.LAST_NAME_LENGHT.getValue(), dto.getLastName())) {
                if (!contentValidation(ValidationRules.TYPE_NAME.getValue(), dto.getLastName())) {
                    messages.add("null");
                }
            } else {
                messages.add("null");
            }

            if (LenghtValidation(ValidationRules.STREET_ADDRESS_LENGHT.getValue(), dto.getStreetAddress())) {
                if (!contentValidation(ValidationRules.TYPE_ADDRESS.getValue(), dto.getStreetAddress())) {
                    messages.add("null");
                }
            } else {
                messages.add("null");
            }

            if (LenghtValidation(ValidationRules.POST_CODE_LENGHT.getValue(), Integer.toString(dto.getPostalCode()))) {
                if (!contentValidation(ValidationRules.TYPE_POSTAL_CODE.getValue(),
                        Integer.toString(dto.getPostalCode()))) {
                    messages.add("null");
                }
            } else {
                messages.add("null");
            }

            if (LenghtValidation(ValidationRules.CITY_LENGHT.getValue(), dto.getCity())) {
                if (!contentValidation(ValidationRules.TYPE_CITY.getValue(), dto.getCity())) {
                    messages.add("null");
                }
            } else {
                messages.add("null");
            }

            if (LenghtValidation(ValidationRules.EMAIL_LENGHT.getValue(), dto.getEmail())) {
                if (!contentValidation(ValidationRules.TYPE_EMAIL.getValue(), dto.getEmail())) {
                    messages.add("null");
                }
            } else {
                messages.add("null");
            }

            if (LenghtValidation(ValidationRules.PHONE_NUMBER_LENGHT.getValue(), Integer.toString(dto.getPhone()))) {
                if (!contentValidation(ValidationRules.TYPE_EMAIL.getValue(), Integer.toString(dto.getPhone()))) {
                    messages.add("null");
                }
            } else {
                messages.add("null");
            }

            return messages;
        }
    }

}
