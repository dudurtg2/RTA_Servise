package com.example.empresa.services;

/**
 * Serviço responsável por realizar validações de dados como o formato de CEP.
 * 
 * A classe contém métodos para validar e formatar entradas específicas, como o CEP, garantindo que os dados estejam no formato adequado.
 */
public class ValidacaoService {

    /**
     * Valida o formato do CEP fornecido e o retorna no formato adequado.
     * 
     * A validação garante que o CEP tenha exatamente 8 dígitos numéricos.
     * Se o CEP for inválido, o método retorna "invalido". Caso contrário, retorna o CEP formatado no padrão XXXXX-XXX.
     * 
     * @param cep o CEP a ser validado e formatado.
     * @return o CEP formatado no padrão XXXXX-XXX, ou "invalido" caso o CEP não seja válido.
     */
    public String Cep(String cep) {
        // Remove caracteres não numéricos do CEP
        String cepInValidate = cep.replaceAll("[^\\d]", "");
        
        // Verifica se o CEP possui exatamente 8 dígitos
        if (cepInValidate.length() != 8) {
            return "invalido"; // Retorna "invalido" caso o CEP não tenha 8 dígitos
        }

        // Retorna o CEP formatado no padrão XXXXX-XXX
        return cepInValidate.substring(0, 5) + "-" + cepInValidate.substring(5);
    }
}
