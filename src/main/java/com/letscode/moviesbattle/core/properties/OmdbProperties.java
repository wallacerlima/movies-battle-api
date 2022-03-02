package com.letscode.moviesbattle.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration(proxyBeanMethods = false)
@Data
@ConfigurationProperties(prefix = "omdb.api")
public class OmdbProperties {
    public String host;
    public String key;
}
