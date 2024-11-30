package com.example.empresa.services;

public class ValidacaoService {

    /**
     * Valida um CEP e o formata corretamente.
     * 
     * Se o CEP for inv lido, o m todo retorna a string null.
     * 
     * @param cep O CEP a ser validado.
     * @return O CEP formatado corretamente, ou null se o CEP for inv lido.
     */
    public String Cep(String cep) {
        String cepInValidate = cep.replaceAll("[^\\d]", "");
        
        if (cepInValidate.length() != 8) {
            return null;
        }

        return cepInValidate.substring(0, 5) + "-" + cepInValidate.substring(5);
    }
    
    /**
     * Valida um CPF e o formata corretamente.
     * 
     * Se o CPF for inv lido, o m todo retorna a string null.
     * 
     * @param cpf O CPF a ser validado.
     * @return O CPF formatado corretamente, ou null se o CPF for inv lido.
     */
    public String Cpf(String cpf) {
        String cpfInValidate = cpf.replaceAll("[^\\d]", "");
        
        if (cpfInValidate.length() != 11) {
            return null;
        }
        
        if (!isValidCPF(cpfInValidate)) {
            return null;
        }
        
        return cpfInValidate.substring(0, 3) + "." + cpfInValidate.substring(3, 6) + "." + cpfInValidate.substring(6, 9) + "-" + cpfInValidate.substring(9);
    }
    
    /**
     * Valida um CPF de acordo com a regra de validao do Brasil.
     * 
     * Se o CPF for v lido, o m todo retorna true.
     * Caso contr rio, retorna false.
     * 
     * @param cpf O CPF a ser validado.
     * @return true se o CPF for v lido, false caso contr rio.
     */
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

    /**
     * Valida um CNPJ e o formata corretamente.
     * 
     * Se o CNPJ for inv lido, o m todo retorna a string null.
     * 
     * @param cnpj O CNPJ a ser validado.
     * @return O CNPJ formatado corretamente, ou null se o CNPJ for inv lido.
     */
    public String Cnpj(String cnpj) {
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
    
    
    /**
     * Valida um CNPJ de acordo com a regra de validação do Brasil.
     * 
     * O método verifica os dígitos verificadores do CNPJ para determinar sua validade.
     * 
     * @param cnpj O CNPJ a ser validado.
     * @return true se o CNPJ for válido, false caso contrário.
     */
    public boolean isValidCNPJ(String cnpj) {
        int soma = 0;
        int peso = 5;
        int dv1, dv2;
        
        for (int i = 0; i < 12; i++) {
            soma += Integer.parseInt(String.valueOf(cnpj.charAt(i))) * peso;
            peso--;
        }
        
        dv1 = soma % 11;
        if (dv1 < 2) {
            dv1 = 0;
        } else {
            dv1 = 11 - dv1;
        }
        
        if (String.valueOf(dv1).equals(String.valueOf(cnpj.charAt(12)))) {
            soma = 0;
            peso = 6;
            for (int i = 0; i < 13; i++) {
                soma += Integer.parseInt(String.valueOf(cnpj.charAt(i))) * peso;
                peso--;
            }
            
            dv2 = soma % 11;
            if (dv2 < 2) {
                dv2 = 0;
            } else {
                dv2 = 11 - dv2;
            }
            
            if (String.valueOf(dv2).equals(String.valueOf(cnpj.charAt(13)))) {
                return true;
            }
        }
        
        return false;
    }
}

