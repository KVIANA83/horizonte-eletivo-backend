package com.desafio.horizonteEletivo.exceptions;

public class ValidacaoException extends RuntimeException {
    
    public static final long serialVersionUID = 1L;
    
    public ValidacaoException (String mensagem) {
        super(mensagem);
    }
}