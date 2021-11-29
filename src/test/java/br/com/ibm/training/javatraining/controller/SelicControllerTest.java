package br.com.ibm.training.javatraining.controller;

import br.com.ibm.training.javatraining.dto.SelicRequest;
import br.com.ibm.training.javatraining.entity.SelicEntity;
import br.com.ibm.training.javatraining.service.SelicService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class SelicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SelicService interestRatesService;

    @Test
    public void salvarComSucesso() throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String data = "01/06/1986";
        Double valor = Double.parseDouble("1.26");

        SelicEntity dadoInterestRatesEntity = new SelicEntity();
        dadoInterestRatesEntity.setValor(valor);
        dadoInterestRatesEntity.setData(LocalDate.parse(data, formatter));

        List<SelicRequest> interestRatesRequest = new ArrayList<>();

        when(interestRatesService.saveTaxaSelic())
                .thenReturn((interestRatesRequest));

        MvcResult resposta = mockMvc.perform(MockMvcRequestBuilders.post("/v1/taxaselic/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(interestRatesRequest)))
                .andExpect(MockMvcResultMatchers.status().is(201)).andReturn();

        Assert.assertNotNull(resposta);
    }


}
