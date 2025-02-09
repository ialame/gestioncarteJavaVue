package com.pcagrade.painter.client;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("painter")
public record PainterClientProperties(
    String baseUrl,
    String publicUrl,
    String oauth2RegistrationId
) { }
