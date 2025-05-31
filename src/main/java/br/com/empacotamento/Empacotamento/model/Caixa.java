package br.com.empacotamento.Empacotamento.model;

import java.util.ArrayList;
import java.util.List;

public class Caixa extends Produto {
    private String tipo;
    private double altura;
    private double largura;
    private double comprimento;
    private List<Produto> produtos;

    public Caixa(String tipo, double altura, double largura, double comprimento){
        super(tipo, altura, largura, comprimento);
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.produtos = new ArrayList<>();
    }

    public boolean podeAdicionar(Produto p) {
        if (p.getMaiorAltura() > altura || p.getMaiorLargura() > largura || p.getMaiorComprimento() > comprimento) {
            return false;
        }
        return true;
    }

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public String getTipo() {
        return tipo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double getVolumeTotal() {
        return altura * largura * comprimento;
    }

    public double getVolumeOcupado() {
        return produtos.stream().mapToDouble(Produto::getVolume).sum();
    }

    public double getVolumeDisponivel() {
        return getVolumeTotal() - getVolumeOcupado();
    }

    public double getAltura() {
        return altura;
    }

    public double getLargura() {
        return largura;
    }

    public double getComprimento() {
        return comprimento;
    }
}