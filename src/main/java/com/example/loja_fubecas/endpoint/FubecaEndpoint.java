package com.example.loja_fubecas.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.loja_fubecas.exception.FubecaNaoEncontradaException;
import com.example.loja_fubecas.model.ConsultarFubecaRequest;
import com.example.loja_fubecas.model.ConsultarFubecaResponse;

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
                // Dispara a exceção mapeada para SOAP Fault
                throw new FubecaNaoEncontradaException("Fubeca com o código " + request.getCodigo() + " não foi encontrada!");
        }

        return response;
    }
}