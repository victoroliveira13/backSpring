package br.com.victor.backSpring.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "CONTACT")
public class ContactModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private String email;

  @Column
  private String phone;

  @ManyToOne
  @JoinColumn(name = "idPessoa", nullable = false)
  private PessoaModel pessoa;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public PessoaModel getPessoa() {
    return pessoa;
  }

  public void setPessoa(PessoaModel pessoa) {
    this.pessoa = pessoa;
  }

}
