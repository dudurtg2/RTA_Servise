package com.example.empresa.services;

import org.springframework.stereotype.Service;

@Service
public class ValidateServise {
    public String cpf(String cpf) {
        String cpfInValidate = cpf.replaceAll("[^\\d]", "");
        
        if (cpfInValidate.length() != 11) {
            return null;
        }
        
        if (!isValidCPF(cpfInValidate)) {
            return null;
        }
        
        return cpfInValidate.substring(0, 3) + "." + cpfInValidate.substring(3, 6) + "." + cpfInValidate.substring(6, 9) + "-" + cpfInValidate.substring(9);
    }
    
    private boolean isValidCPF(String cpf) {
        int soma = 0;
        int peso = 10;
        
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * peso;
            peso--;
        }
        
        int dv = soma % 11;
        if (dv < 2) {
            dv = 0;
        } else {
            dv = 11 - dv;
        }
        
        if (String.valueOf(dv).equals(String.valueOf(cpf.charAt(9)))) {
            soma = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * peso;
                peso--;
            }
            
            dv = soma % 11;
            if (dv < 2) {
                dv = 0;
            } else {
                dv = 11 - dv;
            }
            
            if (String.valueOf(dv).equals(String.valueOf(cpf.charAt(10)))) {
                return true;
            }
        }
        
        return false;
    }


    public String cnpj(String cnpj) {
        String cnpjInValidate = cnpj.replaceAll("[^\\d]", "");
    
        if (cnpjInValidate.length() != 14) {
            return null;
        }
    
        if (!isValidCNPJ(cnpjInValidate)) {
            return null;
        }
    
        return cnpjInValidate.substring(0, 2) + "." + 
               cnpjInValidate.substring(2, 5) + "." + 
               cnpjInValidate.substring(5, 8) + "/" + 
               cnpjInValidate.substring(8, 12) + "-" + 
               cnpjInValidate.substring(12);
    }
    
    
    public boolean isValidCNPJ(String cnpj) {
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }
    
        int[] pesos1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    
        int soma = 0;
        for (int i = 0; i < 12; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * pesos1[i];
        }
        int dv1 = soma % 11 < 2 ? 0 : 11 - (soma % 11);
    
        if (dv1 != Character.getNumericValue(cnpj.charAt(12))) {
            return false;
        }
    
        soma = 0;
        for (int i = 0; i < 13; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * pesos2[i];
        }
        int dv2 = soma % 11 < 2 ? 0 : 11 - (soma % 11);
    
        return dv2 == Character.getNumericValue(cnpj.charAt(13));
    } 
}
