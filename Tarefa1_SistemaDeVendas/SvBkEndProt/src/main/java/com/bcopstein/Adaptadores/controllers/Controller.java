package com.bcopstein.Adaptadores.controllers;

import java.util.List;

import com.bcopstein.Aplicacao.dtos.ParamSubtotal_DTO;
import com.bcopstein.Aplicacao.casosDeUso.CadastraProdutos;
import com.bcopstein.Aplicacao.casosDeUso.CadastraVendaUC;
import com.bcopstein.Aplicacao.casosDeUso.ConsultaProdutosUC;
import com.bcopstein.Aplicacao.casosDeUso.ConsultaVendaUC;
import com.bcopstein.Aplicacao.casosDeUso.ConsultaVendasUC;
import com.bcopstein.Aplicacao.casosDeUso.VerificaEstoqueProdutoUC;
import com.bcopstein.Negocio.entidades.Produto;
import com.bcopstein.Negocio.entidades.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class Controller {
  private VerificaEstoqueProdutoUC verificaEstoqueProduto;
  private CadastraVendaUC cadastraVenda;
  private ConsultaVendaUC consultaVenda;
  private ConsultaVendasUC consultaVendas;
  private ConsultaProdutosUC consultaProdutos;
  private CadastraProdutos cadastraProdutos;

  @Autowired
  public Controller(VerificaEstoqueProdutoUC verificaEstoqueProdutoUC, CadastraVendaUC cadastraVenda,
      ConsultaVendaUC consultaVenda, ConsultaVendasUC consultaVendas, ConsultaProdutosUC consultaProdutos, CadastraProdutos cadastraProdutos) {
    this.verificaEstoqueProduto = verificaEstoqueProdutoUC;
    this.cadastraVenda = cadastraVenda;
    this.consultaVenda = consultaVenda;
    this.consultaVendas = consultaVendas;
    this.consultaProdutos = consultaProdutos;
    this.cadastraProdutos = cadastraProdutos;
  }

  @GetMapping("/produtos")
  @CrossOrigin(origins = "*")
  public List<Produto> listaProdutos() {
    return consultaProdutos.executar();
  }

  @GetMapping("/autorizacao")
  @CrossOrigin(origins = "*")
  public boolean podeVender(@RequestParam final Integer codProd, @RequestParam final Integer qtdade) {
    return verificaEstoqueProduto.executar(codProd, qtdade);
  }

  @PostMapping("/confirmacao")
  @CrossOrigin(origins = "*")
  public Integer confirmaVenda(@RequestBody final ParamSubtotal_DTO dto) {
    return cadastraVenda.executar(dto);
  }

  @PostMapping("/subtotal")
  @CrossOrigin(origins = "*")
  public Integer[] calculaSubtotal(@RequestBody final ParamSubtotal_DTO dto) {
    return consultaVenda.executar(dto);
  }

  @GetMapping("/historico")
  @CrossOrigin(origins = "*")
  public List<Venda> vendasEfetuadas() {
    return consultaVendas.executar();
  }

  @PostMapping("/criarProdutos")
  @CrossOrigin(origins = "*")
  public void criarProdutos() {
    cadastraProdutos.executar();
  }
}
