package br.com.empacotamento.Empacotamento.model;

public class Produto {
    private String produtoId;
    private double altura;
    private double largura;
    private double comprimento;

    public Produto(String produtoId, double altura, double largura, double comprimento) {
        this.produtoId = produtoId;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public double getVolume() {
        return altura * largura * comprimento;
    }

    public String getProdutoId() { return produtoId; }
    public double getMaiorAltura() { return altura; }
    public double getMaiorLargura() { return largura; }
    public double getMaiorComprimento() { return comprimento; }
}

