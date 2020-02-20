package com.pyun.http.exception;

import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * Created by dengt on 2019-04-25
 */
public class AccessDenyException extends Exception {

    @Getter
    private String hint;

    public AccessDenyException(String message) {
        super(message);
    }

    public AccessDenyException(String message, String hint) {
        super(message);
        this.hint = hint;
    }

    public AccessDenyException withHint(String hint) {
        this.hint = hint;
        return this;
    }

    public String asString() {
        StringBuffer sb = new StringBuffer();
        if (!StringUtils.isEmpty(this.getMessage())) sb.append(this.getMessage());
        if (!StringUtils.isEmpty(this.getHint())) sb.append("(").append(this.getHint()).append(")");

        return sb.toString();
    }

}
