package com.unimonte.a3.accesscontroller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EProfessionalConfig {

    private final String URL_SISTER = "http://sister.eprofessionalti.com/api/integra/access";
    private final String URL_WEBSAG = "http://websag.eprofessionalti.com/api/integra/movimentacao";

    private WebClient webClientSister;
    private WebClient webClientWebsag;

    public EProfessionalConfig() {
        webClientSister = WebClient.builder().baseUrl(URL_SISTER).build();
        webClientWebsag = WebClient.builder().baseUrl(URL_WEBSAG).build();
    }

    public WebClient getWebClientSister() {
        return webClientSister;
    }

    public WebClient getWebClientWebsag() {
        return webClientWebsag;
    }
}
