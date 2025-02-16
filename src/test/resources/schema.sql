CREATE TABLE PRODUTO (
    PRODUTO_ID BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    NOME VARCHAR(50) NOT NULL,
    DESCRICAO VARCHAR(200),
    PRECO NUMERIC(10,2) NOT NULL,
    CATEGORIA VARCHAR(20) NOT NULL
);