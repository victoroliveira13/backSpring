package br.com.victor.backSpring.controller;

import br.com.victor.backSpring.dtos.PessoaRecordDto;
import br.com.victor.backSpring.model.PessoaModel;
import br.com.victor.backSpring.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

  private final PessoaService pessoaService;

  public PessoaController(PessoaService pessoaService) {
    this.pessoaService = pessoaService;
  }

  @PostMapping
  public ResponseEntity<PessoaModel> savePessoa(@RequestBody PessoaRecordDto pessoaRecordDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.savePessoa(pessoaRecordDto));
  }
}
