package br.com.empacotamento.Empacotamento.service;

import org.springframework.stereotype.Service;

import br.com.empacotamento.Empacotamento.dto.PedidoRequest;
import br.com.empacotamento.Empacotamento.dto.PedidoResponse;
import br.com.empacotamento.Empacotamento.model.Caixa;
import br.com.empacotamento.Empacotamento.model.Produto;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmpacotamentoService  {

    private final List<Caixa> modelosCaixas = List.of(
            new Caixa("Caixa 1", 30, 40, 80),
            new Caixa("Caixa 2", 80, 50, 40),
            new Caixa("Caixa 3", 50, 80, 60)
    );

    public List<PedidoResponse> empacotarPedidos(List<PedidoRequest> pedidos) {
        List<PedidoResponse> resposta = new ArrayList<>();

        for (PedidoRequest pedido : pedidos) {
            List<Caixa> caixasUsadas = new ArrayList<>();
            List<PedidoResponse.CaixaDTO> caixasDTO = new ArrayList<>();

            List<Produto> produtos = pedido.getProdutos().stream()
                    .map(p -> new Produto(
                            p.getProdutoId(),
                            p.getDimensoes().getAltura(),
                            p.getDimensoes().getLargura(),
                            p.getDimensoes().getComprimento()
                    ))
                    .collect(Collectors.toList());

            for (Produto produto : produtos) {
                boolean alocado = false;

                for (Caixa caixa : caixasUsadas) {
                    if (caixa.podeAdicionar(produto) && caixa.getVolumeDisponivel() >= produto.getVolume()) {
                        caixa.adicionarProduto(produto);
                        alocado = true;
                        break;
                    }
                }

                if (!alocado) {
                    boolean encaixou = false;
                    for (Caixa modelo : modelosCaixas) {
                        if (modelo.podeAdicionar(produto)) {
                            Caixa novaCaixa = new Caixa(modelo.getTipo(), modelo.getAltura(), modelo.getLargura(), modelo.getComprimento());
                            novaCaixa.adicionarProduto(produto);
                            caixasUsadas.add(novaCaixa);
                            encaixou = true;
                            break;
                        }
                    }
                    if (!encaixou) {
                        caixasDTO.add(new PedidoResponse.CaixaDTO(
                                null,
                                List.of(produto.getProdutoId()),
                                "Produto não cabe em nenhuma caixa disponível."
                        ));
                    }
                }
            }

            caixasDTO.addAll(caixasUsadas.stream()
                    .map(c -> new PedidoResponse.CaixaDTO(
                            c.getTipo(),
                            c.getProdutos().stream().map(Produto::getProdutoId).collect(Collectors.toList()),
                            null
                    ))
                    .collect(Collectors.toList()));

            resposta.add(new PedidoResponse(pedido.getPedidoId(), caixasDTO));
        }

        return resposta;
    }
}

