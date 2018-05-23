package com.ke.chequelapid.domain;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;

public class PhoneNumberUtils {
    public static final PhoneNumberUtil PHONE_NUMBER_UTIL = PhoneNumberUtil.getInstance();
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(PhoneNumberUtils.class);

    public static String parsePhoneNumber(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            String s = (str.length() > 9 && Character.isDigit(str.charAt(0)) && str.charAt(0) != '0') ? "+" + str : str;
            Phonenumber.PhoneNumber phoneNumber = PHONE_NUMBER_UTIL.parse(s, LocaleContextHolder.getLocale().getCountry()).clearItalianLeadingZero();
            return PHONE_NUMBER_UTIL.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164).substring(1);
        } catch (NumberParseException e) {
            LOG.info("this is the number",str);
            throw new IllegalArgumentException("Invalid phone number", e);
        }

    }
}
