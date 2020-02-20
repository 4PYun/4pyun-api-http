package com.pyun.http.security;

import com.pyun.http.exception.AccessDenyException;
import com.pyun.http.utils.MD5;
import com.pyun.http.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class SecurityProvider {

    public void verifyRequest(Map<String, String> args) throws AccessDenyException {
        String signature = args.remove("sign");
        // Preconditions..
        if (StringUtils.isBlank(signature)) throw new IllegalArgumentException("请求参数`sign`缺失!");

        // TODO 根据参数获取当前的签名计算密钥
        String key = "DEMO";

        String plain = StringUtils.join(args, "&", "=");
        String expect = MD5.encryptHEX(plain + "&key=" + key);

        if (expect.equalsIgnoreCase(signature)) {
            // 签名校验通过
            return;
        } else {
            log.warn("[SecurityProvider][VerifyRequest][REF] - {} => {}", plain, expect);
            // 签名校验不通过
            throw new AccessDenyException("请求签名校验不通过")
                    .withHint(plain);
        }

    }

}
