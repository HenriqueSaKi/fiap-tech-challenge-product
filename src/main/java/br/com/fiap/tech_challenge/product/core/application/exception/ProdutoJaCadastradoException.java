package br.com.fiap.tech_challenge.product.core.application.exception;

public class ProdutoJaCadastradoException extends RuntimeException{
    public ProdutoJaCadastradoException(String message) {
        super(message);
    }
}
