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
        // 1

        // 1

        // date object is having 3 methods namely after,before and equals for comparing
        // after() will return true if and only if date1 is after date 2
        if (date1.after(date2)) {
            System.out.println("Date1 is after Date2");
            isTrue = true;
        }

        // before() will return true if and only if date1 is before date2
        if (date1.before(date2)) {
            System.out.println("Date1 is before Date2");
            isTrue = false;
        }

        // equals() returns true if both the dates are equal
        if (date1.equals(date2)) {
            System.out.println("Date1 is equals to Date2");

            isTrue = false;
        }

        return isTrue;

    }
}