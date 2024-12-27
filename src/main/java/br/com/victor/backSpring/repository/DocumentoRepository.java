package br.com.victor.backSpring.repository;

import br.com.victor.backSpring.model.DocumentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentoRepository extends JpaRepository<DocumentoModel, UUID> {
}
