package br.com.ibm.training.javatraining.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelicRequest {

    @JsonProperty("data")
    private String data;

    @JsonProperty("valor")
    private Double valor;
}
