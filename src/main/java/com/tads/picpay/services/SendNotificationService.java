package com.tads.picpay.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SendNotificationService {
    private static final String MOCK_URL = "https://run.mocky.io/v3/3e88b1eb-40f6-40af-baf7-1668f933fb85";
    private static final Logger LOGGER = LoggerFactory.getLogger(SendNotificationService.class);

    public static boolean send() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(MOCK_URL, String.class);
        LOGGER.info("Enviando notificação...");
        return response != null && response.contains("\"message\": \"Notificação enviada.\"");
    }
}
