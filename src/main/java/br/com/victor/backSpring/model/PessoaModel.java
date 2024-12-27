package br.com.victor.backSpring.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "PESSOA")
public class PessoaModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private String nome;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ContactModel> contatos = new HashSet<>();

  @ManyToMany
  @JoinTable(
      name = "PESSOA_PROJETO",
      joinColumns = @JoinColumn(name = "pessoa_id"),
      inverseJoinColumns = @JoinColumn(name = "projeto_id")
  )
  private Set<ProjetoModel> projetos = new HashSet<>();

  @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
  private DocumentoModel documento;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Set<ContactModel> getContatos() {
    return contatos;
  }

  public void setContatos(Set<ContactModel> contatos) {
    this.contatos = contatos;
  }

  public Set<ProjetoModel> getProjetos() {
    return projetos;
  }

  public void setProjetos(Set<ProjetoModel> projetos) {
    this.projetos = projetos;
  }

  public DocumentoModel getDocumento() {
    return documento;
  }

  public void setDocumento(DocumentoModel documento) {
    this.documento = documento;
  }
}
