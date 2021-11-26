package br.com.ibm.training.javatraining.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="taxa_selic_tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SelicEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @JsonProperty("codigo_Serie")
    private Long codigo_Serie;

    @Column(nullable = false)
    private LocalDate data;

    @Column (nullable = false)
    private Double valor;
}