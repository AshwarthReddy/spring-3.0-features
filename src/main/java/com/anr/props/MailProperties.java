package com.anr.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "mail-info")
public record MailProperties(Map<String, String> servers) {

    static record Gmail(String hostName, int port, String from) { }
    static record Smtp(String hostName, int port, String from) { }


}
