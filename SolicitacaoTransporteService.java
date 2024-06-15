package com.hospital.transporte.service;

import com.hospital.transporte.model.SolicitacaoTransporte;
import com.hospital.transporte.repository.SolicitacaoTransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoTransporteService {
    @Autowired
    private SolicitacaoTransporteRepository solicitacaoTransporteRepository;

    public SolicitacaoTransporte criarSolicitacao(SolicitacaoTransporte solicitacao) {
        solicitacao.setStatus("Aguardando transporte");
        return solicitacaoTransporteRepository.save(solicitacao);
    }

    public SolicitacaoTransporte aceitarSolicitacao(Long id) {
        Optional<SolicitacaoTransporte> solicitacao = solicitacaoTransporteRepository.findById(id);
        if (solicitacao.isPresent()) {
            SolicitacaoTransporte s = solicitacao.get();
            s.setStatus("Em transporte");
            return solicitacaoTransporteRepository.save(s);
        }
        return null;
    }

    public SolicitacaoTransporte recusarSolicitacao(Long id) {
        Optional<SolicitacaoTransporte> solicitacao = solicitacaoTransporteRepository.findById(id);
        if (solicitacao.isPresent()) {
            SolicitacaoTransporte s = solicitacao.get();
            s.setStatus("Recusada");
            return solicitacaoTransporteRepository.save(s);
        }
        return null;
    }

    public List<SolicitacaoTransporte> listarSolicitacoes() {
        return solicitacaoTransporteRepository.findAll();
    }
}
