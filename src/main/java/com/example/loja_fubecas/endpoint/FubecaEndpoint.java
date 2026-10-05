package com.example.loja_fubecas.endpoint;

import com.example.loja_fubecas.model.ConsultarFubecaRequest;
import com.example.loja_fubecas.model.ConsultarFubecaResponse;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FubecaEndpoint {

    private static final String NAMESPACE = "http://lojadefubecas.com/fubecas";

    @PayloadRoot(namespace = NAMESPACE, localPart = "consultarFubecaRequest")
    @ResponsePayload
    public ConsultarFubecaResponse consultarFubeca(@RequestPayload ConsultarFubecaRequest request) {
        ConsultarFubecaResponse response = new ConsultarFubecaResponse();

        switch (request.getCodigo()) {
            case 1:
                response.setNome("Bolinha Tradicional");
                response.setTipo("Olho de Gato");
                response.setPreco(0.50);
                response.setQuantidadeEstoque(150);
                break;
            case 2:
                response.setNome("Bolinha Zoião");
                response.setTipo("Vidro Especial 25mm");
                response.setPreco(2.50);
                response.setQuantidadeEstoque(35);
                break;
            case 3:
                response.setNome("Bolinha Leiteira");
                response.setTipo("Opaca Branca");
                response.setPreco(1.00);
                response.setQuantidadeEstoque(80);
                break;
            default:
                response.setNome("Item não encontrado");
                response.setTipo("-");
                response.setPreco(0.0);
                response.setQuantidadeEstoque(0);
                break;
        }

        return response;
    }
}