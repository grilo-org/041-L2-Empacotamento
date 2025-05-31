package br.com.empacotamento.Empacotamento.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class PedidoResponse {

    @JsonProperty("pedido_id")
    private int pedidoId;

    @JsonProperty("caixas")
    private List<CaixaDTO> caixas;

    public PedidoResponse() {}

    public PedidoResponse(int pedidoId, List<CaixaDTO> caixas) {
        this.pedidoId = pedidoId;
        this.caixas = caixas;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public List<CaixaDTO> getCaixas() {
        return caixas;
    }

    public void setCaixas(List<CaixaDTO> caixas) {
        this.caixas = caixas;
    }

    public static class CaixaDTO {

        @JsonProperty("caixa_id")
        private String caixaId;

        @JsonProperty("produtos")
        private List<String> produtos;

        @JsonProperty("observacao")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String observacao;

        public CaixaDTO() {}

        public CaixaDTO(String caixaId, List<String> produtos, String observacao) {
            this.caixaId = caixaId;
            this.produtos = produtos;
            this.observacao = observacao;
        }

        public String getCaixaId() {
            return caixaId;
        }

        public void setCaixaId(String caixaId) {
            this.caixaId = caixaId;
        }

        public List<String> getProdutos() {
            return produtos;
        }

        public void setProdutos(List<String> produtos) {
            this.produtos = produtos;
        }

        public String getObservacao() {
            return observacao;
        }

        public void setObservacao(String observacao) {
            this.observacao = observacao;
        }
    }
}


