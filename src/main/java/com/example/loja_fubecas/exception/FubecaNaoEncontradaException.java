package com.example.loja_fubecas.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class FubecaNaoEncontradaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FubecaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}