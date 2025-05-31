package br.com.empacotamento.Empacotamento;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EmpacotamentoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testEmpacotamentoEndpoint() throws Exception {
        String entradaJson = Files.readString(new ClassPathResource("entrada.json").getFile().toPath());
        String saidaEsperadaJson = Files.readString(new ClassPathResource("saida.json").getFile().toPath());

        mockMvc.perform(post("/api/empacotar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(entradaJson))
                .andExpect(status().isOk())
                .andExpect(content().json(saidaEsperadaJson));
    }
}