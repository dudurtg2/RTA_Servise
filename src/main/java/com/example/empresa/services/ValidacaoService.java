package com.example.empresa.services;

public class ValidacaoService {
    public String Cep(String cep) {
        String cepInValidate = cep.replaceAll("[^\\d]", "");
        
        if (cepInValidate.length() != 8) {
            return "invalido"; 
        }

        return cepInValidate.substring(0, 5) + "-" + cepInValidate.substring(5);
        // testy
    }
    
}
