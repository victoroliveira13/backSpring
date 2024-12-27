package br.com.victor.backSpring.dtos;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record PessoaRecordDto (
      String nome,
      List<ContactRecordDto> contatos,
      List<ProjetoRecordDto> projetos,
      String numeroDocumento
    ){
}
