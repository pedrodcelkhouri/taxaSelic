package br.com.ibm.training.javatraining.service;

import br.com.ibm.training.javatraining.dto.SelicRequest;
import br.com.ibm.training.javatraining.entity.SelicEntity;
import br.com.ibm.training.javatraining.integration.client.SelicFeign;
import br.com.ibm.training.javatraining.repositories.SelicRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SelicServiceImplement implements SelicService {
    @Autowired
    private SelicFeign interestRatesFeignClient;

    @Autowired
    private SelicRepository interestRatesRepository;


    @Override
    public List<SelicRequest> saveTaxaSelic() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<SelicRequest> interestRatesRequest = interestRatesFeignClient.onboardingDadosSelic();
        interestRatesRequest.forEach(taxaSelicRequest1 -> {LocalDate transformacaoDeData = LocalDate.parse(String.valueOf(taxaSelicRequest1.getData()), dtf);
            Double transformacaoDeValor = Double.parseDouble(String.valueOf(taxaSelicRequest1.getValor()));

            SelicEntity dadosInterestRatesEntity = new SelicEntity();
            dadosInterestRatesEntity.setData(transformacaoDeData);
            dadosInterestRatesEntity.setValor(transformacaoDeValor);
            interestRatesRepository.save(dadosInterestRatesEntity);

        });
        return interestRatesRequest;
    }



    @Override
    public Double getTaxaSelicByYear(int ano) {

        List<SelicEntity> acumuloAnualEntities = interestRatesRepository.findAll();
        Double resposta = acumuloAnualEntities.stream()
                .filter(taxaSelic -> taxaSelic.getData().getYear() == ano)
                .map(taxaSelic -> taxaSelic.getValor())
                .reduce(0.0, Double::sum);

        return resposta;
    }

    @Override
    public List<SelicEntity> getAllTaxaSelics() throws NotFoundException {

        List<SelicEntity> dadosInterestRatesEntity = interestRatesRepository.findAll();

        if (dadosInterestRatesEntity.isEmpty()) {
            throw new NotFoundException("Não há registro dessa data.");
        }
        return dadosInterestRatesEntity;
    }

    @Override
    public SelicEntity updateTaxaSelic(int mes, int ano, Double valor) throws IOException {

        List<SelicEntity> acumuloEntities = interestRatesRepository.findAll();

        Optional<SelicEntity> respostaOptional = acumuloEntities.stream()
                .filter(taxaSelic -> taxaSelic.getData().getYear() == ano)
                .filter(taxaSelic -> taxaSelic.getData().getMonth() == Month.of(mes))
                .findFirst();

        if (!respostaOptional.isPresent()){
            throw new IOException("Não encontrou.");
        }
        SelicEntity resposta = respostaOptional.get();

        resposta.setValor(valor);

        return interestRatesRepository.save(resposta);
    }

    @Override
    public void deleteTaxaSelic(int codigo_Serie) {

        List<SelicEntity> acumuloEntities = interestRatesRepository.findAll();

        List<SelicEntity> resposta = acumuloEntities.stream()
                .filter(taxaSelic -> taxaSelic.getCodigo_Serie() == codigo_Serie)
                .collect(Collectors.toList());

        resposta.forEach(taxaSelic -> {
            interestRatesRepository.deleteById(taxaSelic.getCodigo_Serie());
        });
    }


}
