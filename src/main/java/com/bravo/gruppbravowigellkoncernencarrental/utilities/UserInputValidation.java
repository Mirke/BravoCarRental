package com.bravo.gruppbravowigellkoncernencarrental.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CustomerDto;

/**
 * <code>UserInputValidation</code> - Class for validating input
 * 
 * @authors Jessica
 * @version 0.0.1
 */

public class UserInputValidation {

    public class CustomerValidation {

        public List<String> CustomerFieldValidation(CustomerDto dto){

            List<String> messages = new ArrayList<>();
           firstNameValidation(dto.getFirstName(), messages);
           lastNameValidation(dto.getLastName(), messages);

            return messages;
        }

        private List<String> firstNameValidation(String firstname, List<String> messages) {

            if (firstname == null
                    || firstname.isEmpty()
                    || firstname.trim().isEmpty()
                    || firstname.length() > 30) {
                        messages.add(""); 
            }

            // Character not allowed filter
            // Pattern pattern = Pattern.compile("[^a-zA-Z]");
            // Matcher match = pattern.matcher(firstname);
            // boolean hasMatch = match.find();
            // if(hasMatch){
            //     messages.add(""); 
            // }

            return messages;
        }
        
        private List<String> lastNameValidation(String lastname, List<String> messages) {

            if (lastname == null
                    || lastname.isEmpty()
                    || lastname.trim().isEmpty()
                    || lastname.length() > 30) {
                messages.add(""); 
            }

            // Character not allowed filter
            // Pattern pattern = Pattern.compile("[^a-zA-Z]");
            // Matcher match = pattern.matcher(lastname);
            // boolean hasMatch = match.find();
            // if(hasMatch){
            //    messages.add("");
            // }
            return messages;
        }

        // private List<String> streetAddressValidation(String streetAddress) {

        //     if (streetAddress == null
        //             || streetAddress.isEmpty()
        //             || streetAddress.trim().isEmpty()
        //             || streetAddress.length() > 30) {
        //         isValid = false;
        //     }else{
        //         isValid = true;
        //     }

        //     // Character not allowed filter
        //     // Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        //     // Matcher match = pattern.matcher(streetAddress);
        //     // boolean hasMatch = match.find();
        //     // if(hasMatch){
        //     //     isValid = false;
        //     // }else{
        //     //     isValid = true;
        //     // }

        //     return isValid;
        // }

        // private List<String> postalCodeValidation(String postalCode) {

        //     Boolean isValid = false;
        //     if (postalCode == null
        //             || postalCode.isEmpty()
        //             || postalCode.trim().isEmpty()
        //             || postalCode.length() > 6) {
        //         isValid = false;
        //     }else{
        //         isValid = true;
        //     } 

        //     // Character not allowed filter
        //     // Pattern pattern = Pattern.compile("[^0-9]");
        //     // Matcher match = pattern.matcher(streetAddress);
        //     // boolean hasMatch = match.find();
        //     // if(hasMatch){
        //     //     isValid = false;
        //     // }else{
        //     //     isValid = true;
        //     // }

        //     return isValid;
        // }

        // private List<String> cityValidation(String city) {

        //     Boolean isValid = false;
        //     if (city == null
        //             || city.isEmpty()
        //             || city.trim().isEmpty()
        //             || city.length() > 30) {
        //         isValid = false;
        //     }else{
        //         isValid = true;
        //     } 

        //     // Character not allowed filter
        //     // Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        //     // Matcher match = pattern.matcher(city);
        //     // boolean hasMatch = match.find();
        //     // if(hasMatch){
        //     //     isValid = false;
        //     // }else{
        //     //     isValid = true;
        //     // }

        //     return isValid;
        // }

        // private List<String> emailValidation(String email) {

        //     Boolean isValid = false;
        //     if (email == null
        //             || email.isEmpty()
        //             || email.trim().isEmpty()
        //             || email.length() > 45) {
        //         isValid = false;
        //     }else{
        //         isValid = true;
        //     } 

        //     // Character not allowed filter
        //     // Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        //     // Matcher match = pattern.matcher(city);
        //     // boolean hasMatch = match.find();
        //     // if(hasMatch){
        //     //     isValid = false;
        //     // }else{
        //     //     isValid = true;
        //     // }

        //     return isValid;
        // }

        // private String phoneValidation(String phone) {

        //     Boolean isValid = false;
        //     if (phone == null
        //             || phone.isEmpty()
        //             || phone.trim().isEmpty()
        //             || phone.length() > 12) {
        //         isValid = false;
        //     }else{
        //         isValid = true;
        //     } 

        //     // Character not allowed filter
        //     // Pattern pattern = Pattern.compile("[^0-9]");
        //     // Matcher match = pattern.matcher(city);
        //     // boolean hasMatch = match.find();
        //     // if(hasMatch){
        //     //     isValid = false;
        //     // }else{
        //     //     isValid = true;
        //     // }

        //     return isValid;
        // }


    }
}
