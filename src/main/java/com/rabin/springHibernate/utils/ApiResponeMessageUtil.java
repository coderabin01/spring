package com.rabin.springHibernate.utils;

import com.rabin.springHibernate.dto.ApiResponseMessage;
import org.springframework.stereotype.Component;

@Component
public class ApiResponeMessageUtil {
    public ApiResponseMessage getApiResponseMessage(String code){
        return new ApiResponseMessage("Customer Added Sucessfully", code);
    }
}
