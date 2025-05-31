package br.com.empacotamento.Empacotamento.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoRequest {
    @JsonProperty("pedido_id")
    private int pedidoId;

    @JsonProperty("produtos")
    private List<ProdutoDTO> produtos;

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public static class ProdutoDTO {
        @JsonProperty("produto_id")
        private String produtoId;

        @JsonProperty("dimensoes")
        private DimensoesDTO dimensoes;

        public String getProdutoId() {
            return produtoId;
        }

        public void setProdutoId(String produtoId) {
            this.produtoId = produtoId;
        }

        public DimensoesDTO getDimensoes() {
            return dimensoes;
        }

        public void setDimensoes(DimensoesDTO dimensoes) {
            this.dimensoes = dimensoes;
        }
    }

    public static class DimensoesDTO {
        @JsonProperty("altura")
        private double altura;

        @JsonProperty("largura")
        private double largura;

        @JsonProperty("comprimento")
        private double comprimento;

        public double getAltura() { return altura; }
        public void setAltura(double altura) { this.altura = altura; }

        public double getLargura() { return largura; }
        public void setLargura(double largura) { this.largura = largura; }

        public double getComprimento() { return comprimento; }
        public void setComprimento(double comprimento) { this.comprimento = comprimento; }
    }
}
