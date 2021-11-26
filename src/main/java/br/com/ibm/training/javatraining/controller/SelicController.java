package br.com.ibm.training.javatraining.controller;

import br.com.ibm.training.javatraining.dto.SelicRequest;
import br.com.ibm.training.javatraining.entity.SelicEntity;
import br.com.ibm.training.javatraining.service.SelicService;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/taxaselic")
public class SelicController {

    @Autowired
    private SelicService interestRatesService;

    @ApiOperation( value = "Criar uma tabela com os dados da Api Selic")
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public List<SelicRequest> saveTaxaSelic() {

        return interestRatesService.saveTaxaSelic();
    }

    @ApiOperation(value = "Criar uma tabela ----------")
    @PatchMapping("/ ")
    public SelicEntity updateTaxaSelic(@RequestParam("mes") int mes,
                                       @RequestParam("ano") int ano,
                                       @RequestParam("valor") Double valor) throws IOException {
        return interestRatesService.updateTaxaSelic(mes, ano, valor);
    }

    @ApiOperation( value = "Criar uma tabela ------")
    @GetMapping("/{ano}")
    public Double getTaxaSelicByYear(@PathVariable("ano") int ano) {

        return interestRatesService.getTaxaSelicByYear(ano);
    }

    @ApiOperation( value = "Criar uma tabela ------------")
    @GetMapping("/taxa-selics")
    public ResponseEntity<List<SelicEntity>> buscaTaxaSelics() throws NotFoundException {
        List<SelicEntity> dadosInterestRatesEntity = interestRatesService.getAllTaxaSelics();
        return new ResponseEntity<>(dadosInterestRatesEntity, HttpStatus.ACCEPTED);
    }

    @ApiOperation( value = "Criar uma tabela ----------")
    @GetMapping("/deletar/{codigo_Serie}")
    public String deleteTaxaSelic(@PathVariable("codigo_Serie") int codigo_Serie)
    {
        try
        {
            interestRatesService.deleteTaxaSelic(codigo_Serie);

        }
        catch(Exception ex)
        {
            throw ex;
        }
        return ("Valores do código série: " + codigo_Serie + " removido com sucesso");
    }
}
