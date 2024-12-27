package br.com.victor.backSpring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "DOCUMENTO")
public class DocumentoModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private String numero;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @OneToOne
  @JoinColumn(name = "pessoa_id")
  private PessoaModel pessoa;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String nome) {
    this.numero = nome;
  }

  public PessoaModel getPessoa() {
    return pessoa;
  }

  public void setPessoa(PessoaModel pessoa) {
    this.pessoa = pessoa;
  }
}
