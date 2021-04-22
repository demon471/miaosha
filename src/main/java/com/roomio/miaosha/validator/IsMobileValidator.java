package com.roomio.miaosha.validator;

import com.roomio.miaosha.utils.ValidatorUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author biqiang
 * @version 2021/4/22
 * @Description:
 * @Copyright (C)2021, Pcitech
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String>{

    private boolean required=false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
       required= constraintAnnotation.required();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (required){
            return ValidatorUtil.isMobile(value);
        }else{
            if (StringUtils.isEmpty(value)){
                return true;
            }else {
                return ValidatorUtil.isMobile(value);
            }
        }
    }
}
