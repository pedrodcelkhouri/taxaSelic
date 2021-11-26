package br.com.ibm.training.javatraining.service;

import br.com.ibm.training.javatraining.dto.SelicRequest;
import br.com.ibm.training.javatraining.entity.SelicEntity;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.List;

public interface SelicService {

    public List<SelicRequest> saveTaxaSelic();

    public Double getTaxaSelicByYear(int ano);

    public List<SelicEntity> getAllTaxaSelics() throws NotFoundException;

    public SelicEntity updateTaxaSelic(int mes, int ano, Double valor) throws IOException;

    public void deleteTaxaSelic(int codigo_Serie);


}

