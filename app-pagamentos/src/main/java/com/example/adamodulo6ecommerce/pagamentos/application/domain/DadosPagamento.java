package com.example.adamodulo6ecommerce.pagamentos.application.domain;

import lombok.Data;

@Data
public class DadosPagamento {

    private String id;
    private TipoPagamento tipoPagamento;
    private String numeroCartao;
    private String nomeTitular;
    private String dataValidade;
    private String codigoSeguranca;
}
