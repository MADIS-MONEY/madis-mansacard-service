package com.madisfinance.mansacardservice.service;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.madisfinance.mansacardservice.dto.BalanceCardRequest;
import com.madisfinance.mansacardservice.dto.BalanceCardResponse;
import com.madisfinance.mansacardservice.dto.CreateCardRequest;
import com.madisfinance.mansacardservice.dto.CreateCardResponse;
import com.madisfinance.mansacardservice.dto.HistoryCardRequest;
import com.madisfinance.mansacardservice.dto.HistoryCardResponse;
import com.madisfinance.mansacardservice.dto.OperationCardRequest;
import com.madisfinance.mansacardservice.dto.OperationCardResponse;
import com.madisfinance.mansacardservice.dto.OrderStockRequest;
import com.madisfinance.mansacardservice.dto.OrderStockResponse;
import com.madisfinance.mansacardservice.dto.RechargeCardRequest;
import com.madisfinance.mansacardservice.dto.RechargeCardResponse;
import com.madisfinance.mansacardservice.dto.exception.InvalidAgentCredentialsException;

import jakarta.xml.bind.DatatypeConverter;

@Service
public class MansaBankCardManagementRestTemplateService {

    @Value("${mansa.phrase}")
    private String phrase;
    @Value("${mansa.pinagent}")
    private String pinNumber;
    @Value("${mansa.agentnumber}")
    private String agentNumber;
    @Value("${mansa.baseurl}")
    private String baseUrl;
    private static final String AES_CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";

    private final RestTemplate restTemplate;

    
    public MansaBankCardManagementRestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CreateCardResponse createCard(CreateCardRequest request) throws InvalidAgentCredentialsException {
        this.validateAgent(request.getNumeroAgent(), request.getPinAgent());
        request.setNumeroAgent(agentNumber);
        request.setPinAgent(pinNumber);
        return restTemplate.postForObject(baseUrl + "/create_card/madis", request, CreateCardResponse.class);
    }

    private void validateAgent(String numeroAgent, String pinAgent) {
        if (!numeroAgent.equals(agentNumber) || !pinAgent.equals(pinNumber)){
            throw new InvalidAgentCredentialsException("Invalid agent credentials");
        }
    }
    

    public OrderStockResponse orderStock(OrderStockRequest request) throws InvalidAgentCredentialsException {
        this.validateAgent(request.getNumeroAgent(), request.getPinAgent());
        request.setNumeroAgent(agentNumber);
        request.setPinAgent(pinNumber);
        return restTemplate.postForObject(baseUrl + "/order_stock/madis", request, OrderStockResponse.class);
    }

    public OperationCardResponse operationCard(OperationCardRequest request) throws InvalidAgentCredentialsException {
        this.validateAgent(request.getNumeroAgent(), request.getPinAgent());
        request.setNumeroAgent(agentNumber);
        request.setPinAgent(pinNumber);
        try {
            String encryptedClientNumber = this.encryptSensibleData(request.getNumeroClient(), phrase);
            request.setNumeroClient(encryptedClientNumber);
        } catch (InvalidKeyException | JsonProcessingException | NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return restTemplate.postForObject(baseUrl + "/operation_card/madis", request, OperationCardResponse.class);
    }

    public BalanceCardResponse getBalance(BalanceCardRequest request) throws InvalidAgentCredentialsException {
        this.validateAgent(request.getNumeroAgent(), request.getPinAgent());
        request.setNumeroAgent(agentNumber);
        request.setPinAgent(pinNumber);
        try {
            String encryptedClientNumber = this.encryptSensibleData(request.getNumeroClient(), phrase);
            System.out.println("encryptedClientNumber: " + encryptedClientNumber);

            String encryptedCompte = this.encryptSensibleData(request.getCompte(), phrase);
            System.out.println("encryptedCompte: " + encryptedCompte);
            request.setNumeroClient(encryptedClientNumber);
            request.setCompte(encryptedCompte);
        } catch (InvalidKeyException | JsonProcessingException | NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            System.err.println("Error encrypting client number: " + e.getMessage());
        }
        System.out.println(request);
        return restTemplate.postForObject(baseUrl + "/balance_card/madis", request, BalanceCardResponse.class);
    }

    public RechargeCardResponse rechargeCard(RechargeCardRequest request) throws InvalidAgentCredentialsException {
        this.validateAgent(request.getNumeroAgent(), request.getPinAgent());
        request.setNumeroAgent(agentNumber);
        request.setPinAgent(pinNumber);
        return restTemplate.postForObject(baseUrl + "/recharge_card/madis", request, RechargeCardResponse.class);
    }

    public HistoryCardResponse getHistory(HistoryCardRequest request) throws InvalidAgentCredentialsException {
        this.validateAgent(request.getNumeroAgent(), request.getPinAgent());
        request.setNumeroAgent(agentNumber);
        request.setPinAgent(pinNumber);
        return restTemplate.postForObject(baseUrl + "/history/madis", request, HistoryCardResponse.class);
    }

    public String encryptSensibleData(String data, String passphrase) throws InvalidKeyException,
            NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, JsonProcessingException {

        // 1. Convert passphrase (hexadecimal string) to binary secret key
        byte[] secretKeyBytes = DatatypeConverter.parseHexBinary(passphrase);
        SecretKeySpec secretKey = new SecretKeySpec(secretKeyBytes, "AES");

        // 2. Generate random Initialization Vector (IV)
        SecureRandom secureRandom = new SecureRandom();
        byte[] ivBytes = new byte[16]; // IV length for AES-256-CBC is 16 bytes
        secureRandom.nextBytes(ivBytes);
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        // 3. Initialize Cipher for AES-256-CBC encryption
        Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        // 4. Encrypt the data
        byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        String encryptedData = Base64.getEncoder().encodeToString(encryptedBytes);

        // 5. Base64 encode the IV
        String ivBase64 = Base64.getEncoder().encodeToString(ivBytes);

        // 6. Create JSON object
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonNode = objectMapper.createObjectNode();
        jsonNode.put("iv", ivBase64);
        jsonNode.put("data", encryptedData);

        // 7. Convert JSON object to JSON string
        String jsonString = objectMapper.writeValueAsString(jsonNode);

        // 8. Base64 encode the JSON string
        return Base64.getEncoder().encodeToString(jsonString.getBytes(StandardCharsets.UTF_8));
    }
}
