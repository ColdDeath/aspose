package ru.gbuac;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LdapConfiguration {
    @Value("${ad.domain}")
    private String AD_DOMAIN;

    @Value("${ad.url}")
    private String AD_URL;

    @Value("${ad.username}")
    private String AD_USERNAME;

    @Value("${ad.password}")
    private String AD_PASSWORD;

    @Value("${ad.base}")
    private String AD_BASE;

    @Bean
    public LdapContextSource contextSource(){
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl(AD_URL);
        contextSource.setBase(AD_BASE);
        contextSource.setUserDn(AD_USERNAME);
        contextSource.setPassword(AD_PASSWORD);
        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate(){
        return new LdapTemplate(contextSource());
    }
}
