package br.com.ibm.training.javatraining.integration.client;


import br.com.ibm.training.javatraining.dto.SelicRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "taxaselic", url = "https://api.bcb.gov.br/dados/serie/bcdata.sgs.4390/dados?formato=json")
public interface SelicFeign {
    @GetMapping("")
    List<SelicRequest> onboardingDadosSelic();
}
