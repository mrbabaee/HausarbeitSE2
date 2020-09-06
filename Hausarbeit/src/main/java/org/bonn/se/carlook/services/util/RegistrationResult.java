package org.bonn.se.carlook.services.util;

import org.bonn.se.carlook.model.objects.dto.BaseDTO;

import java.util.ArrayList;
import java.util.List;

public class RegistrationResult<T extends BaseDTO> {

    T userDTO = null;

    public void addRegisteredUserDTO(T userDTO) {
        this.userDTO = userDTO;
    }

    public T getRegisteredUserDTO(){
        return userDTO;
    }

    public enum FailureType {

        FIRSTNAME_MISSING,
        LASTNAME_MISSING,

        EMAIL_MISSING,
        PASSWORD_MISSING,

        STREET_MISSING,
        STREETNUMBER_MISSING,
        POSTALCODE_MISSING,
        POSTALCODEAREA_MISSING,
        PHONE_MISSING
    }

    private boolean result;
    private List<FailureType> reasons;

    public RegistrationResult(){
        reasons = new ArrayList<>();
    }

    public List<FailureType> getReasons() {
        return this.reasons;
    }

    public void setReasons(List<FailureType> failures){
        this.reasons = failures;
    }

    public boolean getResult() {
        return this.result;
    }

    public void addReason(FailureType reason) {
        this.reasons.add(reason);
    }

    public void setResult(boolean b) {
        this.result = b;
    }
}
