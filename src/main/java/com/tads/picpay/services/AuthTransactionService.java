package com.tads.picpay.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthTransactionService {
    private static final String MOCK_URL = "https://run.mocky.io/v3/7ccc331b-69c1-44d3-8667-ada265afa8cd";
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthTransactionService.class);
    public static boolean authorizeTransaction() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(MOCK_URL, String.class);
        LOGGER.info("Verificando o serviço externo para autorização.");
        // Verificar se a resposta contém a mensagem "Autorizado"
        return response != null && response.contains("\"message\": \"Autorizado\"");
    }

}
