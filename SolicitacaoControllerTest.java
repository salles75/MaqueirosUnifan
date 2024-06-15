package com.hospital.transporte.controller;

import com.hospital.transporte.model.SolicitacaoTransporte;
import com.hospital.transporte.service.SolicitacaoTransporteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SolicitacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SolicitacaoTransporteService solicitacaoTransporteService;

    @Test
    public void testCriarSolicitacao() throws Exception {
        Solicit
