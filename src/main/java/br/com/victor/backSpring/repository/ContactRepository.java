package br.com.victor.backSpring.repository;

import br.com.victor.backSpring.model.ContactModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<ContactModel, UUID> {
}