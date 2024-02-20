/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MedicalSuppliesSystem.MedicalSupplies.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

/**
 *
 * @author Waleed.Mohamed
 */
public class ClassUtil {

    static Logger logger = LoggerFactory.getLogger(ClassUtil.class);

    public static <T> T convertJsonToDto(String dataEncoded, Class<T> clazz) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(dataEncoded);
            String decodedString = new String(decodedBytes);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(decodedString, clazz);
        } catch (JsonProcessingException e) {
            logger.error("error while converting Json to object list " + e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
