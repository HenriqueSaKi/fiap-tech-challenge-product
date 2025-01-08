package br.com.fiap.tech_challenge.product.core.application.exception;

public class ErroAoCadastrarProdutoException extends RuntimeException {
    public ErroAoCadastrarProdutoException(String message) {
        super(message);
    }
}