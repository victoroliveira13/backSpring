package br.com.victor.backSpring.service;

import br.com.victor.backSpring.dtos.PessoaRecordDto;
import br.com.victor.backSpring.model.ContactModel;
import br.com.victor.backSpring.model.DocumentoModel;
import br.com.victor.backSpring.model.PessoaModel;
import br.com.victor.backSpring.model.ProjetoModel;
import br.com.victor.backSpring.repository.ContactRepository;
import br.com.victor.backSpring.repository.DocumentoRepository;
import br.com.victor.backSpring.repository.PessoaRepository;
import br.com.victor.backSpring.repository.ProjetoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PessoaService {

  private final PessoaRepository pessoaRepository;
  private final ProjetoRepository projetoRepository;

  public PessoaService(PessoaRepository pessoaRepository, ContactRepository contactRepository, ProjetoRepository projetoRepository, DocumentoRepository documentoRepository) {
    this.pessoaRepository = pessoaRepository;
    this.projetoRepository = projetoRepository;
  }

  @Transactional
  public PessoaModel savePessoa(PessoaRecordDto pessoaRecordDto) {
    PessoaModel pessoa = new PessoaModel();
    pessoa.setNome(pessoaRecordDto.nome());

    // Contatos
    Set<ContactModel> contatos = pessoaRecordDto.contatos().stream().map(contatoDto -> {
      ContactModel contato = new ContactModel();
      contato.setEmail(contatoDto.email());
      contato.setPhone(contatoDto.phone());
      contato.setPessoa(pessoa); // Estabelecendo a relação bidirecional
      return contato;
    }).collect(Collectors.toSet());
    pessoa.setContatos(contatos);

    // Projetos
    Set<ProjetoModel> projetos = pessoaRecordDto.projetos().stream().map(projetoDto -> {
      // Buscar ou criar um projeto com base no nome
      return projetoRepository.findByNome(projetoDto.nome())
          .orElseGet(() -> {
            ProjetoModel novoProjeto = new ProjetoModel();
            novoProjeto.setNome(projetoDto.nome());
            return projetoRepository.save(novoProjeto);
          });
    }).collect(Collectors.toSet());
    pessoa.setProjetos(projetos);

    DocumentoModel documento = new DocumentoModel();
    documento.setNumero(pessoaRecordDto.numeroDocumento());
    documento.setPessoa(pessoa);
    pessoa.setDocumento(documento);

    System.out.println("Pessoa a ser salva: " + pessoa);
    pessoa.getContatos().forEach(contato -> System.out.println("Contato associado: " + contato));

    return pessoaRepository.save(pessoa);
  }


}
