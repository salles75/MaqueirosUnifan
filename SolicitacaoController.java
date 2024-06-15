package com.hospital.transporte.controller;

import com.hospital.transporte.model.SolicitacaoTransporte;
import com.hospital.transporte.service.SolicitacaoTransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {
    @Autowired
    private SolicitacaoTransporteService solicitacaoTransporteService;

    @PostMapping
    public ResponseEntity<SolicitacaoTransporte> criarSolicitacao(@RequestBody SolicitacaoTransporte solicitacao) {
        SolicitacaoTransporte novaSolicitacao = solicitacaoTransporteService.criarSolicitacao(solicitacao);
        return ResponseEntity.status(201).body(novaSolicitacao);
    }

    @PutMapping("/{id}/aceitar")
    public ResponseEntity<SolicitacaoTransporte> aceitarSolicitacao(@PathVariable Long id) {
        SolicitacaoTransporte solicitacaoAtualizada = solicitacaoTransporteService.aceitarSolicitacao(id);
        return solicitacaoAtualizada != null ? ResponseEntity.ok(solicitacaoAtualizada) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/recusar")
    public ResponseEntity<SolicitacaoTransporte> recusarSolicitacao(@PathVariable Long id) {
        SolicitacaoTransporte solicitacaoAtualizada = solicitacaoTransporteService.recusarSolicitacao(id);
        return solicitacaoAtualizada != null ? ResponseEntity.ok(solicitacaoAtualizada) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<SolicitacaoTransporte> listarSolicitacoes() {
        return solicitacaoTransporteService.listarSolicitacoes();
    }
}
