package com.pcagrade.painter.client;

import com.pcagrade.mason.web.client.IWebClientConfigurer;
import com.pcagrade.painer.client.ClientCardImageService;
import com.pcagrade.painer.client.ClientImageService;
import com.pcagrade.painer.client.ClientLegacyImageService;
import com.pcagrade.painer.client.ClientSetImageService;
import com.pcagrade.painer.client.PainterClientProperties;
import com.pcagrade.painter.common.image.IImageService;
import com.pcagrade.painter.common.image.card.ICardImageService;
import com.pcagrade.painter.common.image.legacy.ILegacyImageService;
import com.pcagrade.painter.common.image.set.ISetImageService;
import com.pcagrade.painter.common.publicdata.PublicUrlService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(com.pcagrade.painer.client.PainterClientProperties.class)
public class PainterClientConfiguration {

    @Bean
    public IImageService imageService(com.pcagrade.painer.client.PainterClientProperties painterClientProperties, IWebClientConfigurer webClientConfigurer) {
        return new ClientImageService(painterClientProperties, webClientConfigurer);
    }

    @Bean
    public ILegacyImageService legacyImageService(com.pcagrade.painer.client.PainterClientProperties painterClientProperties, IWebClientConfigurer webClientConfigurer) {
        return new ClientLegacyImageService(painterClientProperties, webClientConfigurer);
    }

    @Bean
    public ICardImageService cardImageService(com.pcagrade.painer.client.PainterClientProperties painterClientProperties, IWebClientConfigurer webClientConfigurer) {
        return new ClientCardImageService(painterClientProperties, webClientConfigurer);
    }

    @Bean
    public ISetImageService setImageService(com.pcagrade.painer.client.PainterClientProperties painterClientProperties, IWebClientConfigurer webClientConfigurer) {
        return new ClientSetImageService(painterClientProperties, webClientConfigurer);
    }

    @Bean
    public PublicUrlService publicUrlService(PainterClientProperties painterClientProperties) {
        return new PublicUrlService(painterClientProperties.publicUrl());
    }
}
