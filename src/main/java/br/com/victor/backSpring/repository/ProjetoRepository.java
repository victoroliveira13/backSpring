package br.com.victor.backSpring.repository;

import br.com.victor.backSpring.model.ProjetoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProjetoRepository extends JpaRepository<ProjetoModel, UUID> {
  Optional<ProjetoModel> findByNome(String nome);
}