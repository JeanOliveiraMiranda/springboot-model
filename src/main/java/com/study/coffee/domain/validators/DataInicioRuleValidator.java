package com.study.coffee.domain.validators;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DataInicioRuleValidator implements ConstraintValidator<DataInicioRule, Date> {

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {

        Date hoje = new Date();

        Boolean dateIsAfter = compareDates(value, hoje);

        return value != null && dateIsAfter == true;
    }

    // date1 is the coming date and date2 is the actual date
    public static Boolean compareDates(Date date1, Date date2) {

        Boolean isTrue = false;
        // if you already have date objects then skip 1


        // after() will return true if and only if date1 is after date 2
        if (date1.after(date2)) {
            System.out.println("Date1 is after Date2");
            isTrue = true;
        }

        return isTrue;

    }
}