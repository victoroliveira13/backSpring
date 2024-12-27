package br.com.victor.backSpring.repository;

import br.com.victor.backSpring.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaRepository extends JpaRepository<PessoaModel, UUID> {
  PessoaModel findPessoaModelByNome(String nome);
}
