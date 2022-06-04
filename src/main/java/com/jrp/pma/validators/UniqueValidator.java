package com.jrp.pma.validators;


import com.jrp.pma.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {

    @Autowired
    private EmployeeService employeeS;


    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("---Entered email validation---");
        boolean valid=employeeS.findByEmail(email).isPresent();
        return (!valid);
    }


}
