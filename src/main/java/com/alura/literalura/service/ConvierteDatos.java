package com.alura.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {

    // 1. Instancia única, final y configurada
    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            // 2. Retorno directo del mapeo
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            // 3. Error descriptivo para facilitar el debug
            throw new RuntimeException("Error al transformar el JSON a la clase: " 
                + clase.getSimpleName() + ". Verifique el formato.", e);
        }
    }
}