package org.yangmy.tide.common.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Configuration
@ConfigurationProperties(prefix = "tide.security")
public class SecurityConfiguration {

    /**
     * 前端传过来的携带token的请求头
     */
    private String tokenHeader;

    public String getTokenHeader() {
        return tokenHeader;
    }

    public void setTokenHeader(String tokenHeader) {
        this.tokenHeader = tokenHeader;
    }

}
