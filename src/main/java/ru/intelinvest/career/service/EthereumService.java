package ru.intelinvest.career.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.intelinvest.career.models.Stock;

import java.util.*;

@Service
@RequiredArgsConstructor
public class EthereumService {
    private final RestTemplate restTemplate;


    public String getBalance(String address){
        Map<String, String> map = new HashMap<>();
        map.put("module", "account");
        map.put("action", "balance");
        map.put("address", address);
        map.put("tag", "latest");
        map.put("apikey", "YourApiKeyToken");



        JsonNode response = restTemplate.getForObject(
                "https://api.etherscan.io/api?module={module}&action={action}&address={address}&tag={tag}&apikey={apikey}",
                JsonNode.class,
                map
        );

        String res = response.get("result").textValue();
        StringBuilder sb = new StringBuilder();

        if(res.length() <= 18) for(int i = 0; i <= 18 - res.length(); i++) sb.append("0");

        sb.append(res);
        res = sb.toString();

        return res.substring(0, res.length() - 18) + "." + res.substring(res.length() - 18 , res.length());
    }
}
