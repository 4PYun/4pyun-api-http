package com.pyun.http.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Setter
@Getter
public class APIRemoteException extends Exception {

    private String code;
    private String hint;

    public APIRemoteException() {
        super();
    }

    public APIRemoteException(int code, String message) {
        super(message);
        this.code = String.valueOf(code);
    }

    public APIRemoteException(String code, String message) {
        super(message);
        this.code = code;
    }

    @Builder
    public APIRemoteException(String code, String message, String hint) {
        super(message);
        this.code = code;
        this.hint = hint;
    }

    public APIRemoteException(String message, Throwable cause) {
        super(message, cause);
    }

    public APIRemoteException(String message) {
        super(message);
    }

    public APIRemoteException(Throwable cause) {
        super(cause);
    }

    public APIRemoteException withHint(String hint) {
        this.hint = hint;
        return this;
    }

    public String asString() {
        StringBuffer sb = new StringBuffer();
        if (!StringUtils.isEmpty(this.getCode())) sb.append("[" + this.getCode() + "]");
        if (!StringUtils.isEmpty(this.getMessage())) sb.append(this.getMessage());
        if (!StringUtils.isEmpty(this.getHint())) sb.append("(").append(this.getHint()).append(")");

        return sb.toString();
    }
}
