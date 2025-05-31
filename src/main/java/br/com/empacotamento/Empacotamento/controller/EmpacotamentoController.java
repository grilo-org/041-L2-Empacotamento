package br.com.empacotamento.Empacotamento.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.empacotamento.Empacotamento.dto.PedidoResponse;
import br.com.empacotamento.Empacotamento.dto.PedidoWrapper;
import br.com.empacotamento.Empacotamento.service.EmpacotamentoService;

import java.util.List;

@RestController
@RequestMapping("/api/empacotar")
@Tag(name = "Empacotamento")
public class EmpacotamentoController {

    @Autowired
    private EmpacotamentoService empacotamentoService;

    @PostMapping
    @Operation(
        summary = "Empacotar pedidos com base nas dimensões dos produtos",
        description = "Recebe um wrapper com os pedidos e retorna uma lista de respostas com o empacotamento realizado"
    )
    public ResponseEntity<List<PedidoResponse>> empacotar(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Wrapper contendo os pedidos a serem empacotados",
            required = true
        )
        @RequestBody PedidoWrapper pedidos) {
        try {
            return ResponseEntity.ok(empacotamentoService.empacotarPedidos(pedidos.getPedidos()));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}