package com.mall.seckill.validator;
import  javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

	private boolean required = false;
    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    private static boolean isMobile(String src) {
        if(StringUtils.isEmpty(src)) {
            return false;
        }
        Matcher m = mobile_pattern.matcher(src);
        return m.matches();
    }

	@Override
	public void initialize(IsMobile constraintAnnotation) {
		required = constraintAnnotation.required();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(required) {
			return isMobile(value);
		}else {
			if(StringUtils.isEmpty(value)) {
				return true;
			}else {
				return isMobile(value);
			}
		}
	}

}
