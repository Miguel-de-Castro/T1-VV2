package com.bcopstein.Negocio.servicos;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalTime;
import java.util.List;

import com.bcopstein.Aplicacao.servicos.RestricaoVendaFactory;
import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.entidades.ItemEstoque;
import com.bcopstein.Negocio.entidades.Venda;
import com.bcopstein.Negocio.repositorios.IVendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendaService {
  private IVendaRepository vendaRepository;
  private ICalculoImposto calculoImposto;
  private EstoqueService servicoEstoque;
  private ICalculoFrete calculoFrete;

  @Autowired
  public VendaService(IVendaRepository vendaRepository, ICalculoImposto calculoImposto, EstoqueService servicoEstoque, ICalculoFrete calculoFrete) {
    this.vendaRepository = vendaRepository;
    this.calculoImposto = calculoImposto;
    this.servicoEstoque = servicoEstoque;
    this.calculoFrete = calculoFrete;
  }

  public Integer cadastraVenda(Venda novaVenda) {
//    IRestricaoHorarioVenda restricaoVenda = RestricaoVendaFactory.getInstance(LocalTime.now());
//    boolean vendaIsValida = restricaoVenda.vendaIsValida(novaVenda);
//
//    if (!vendaIsValida) {
//      return 1;
//    }

    List<ItemCarrinho> produtos = novaVenda.getItensCarrinho();

    for (ItemCarrinho produto : produtos) {
      boolean podeVender = servicoEstoque.podeVender(produto.getCodProduto(), produto.getQuantidade());

      if (!podeVender) {
        return 2;
      }
    }

    for (ItemCarrinho produto : produtos) {
      ItemEstoque itemEstoque = servicoEstoque.getProduto(produto.getCodProduto());
      itemEstoque.setQuantidade(itemEstoque.getQuantidade() - produto.getQuantidade());
      servicoEstoque.atualizaProduto(itemEstoque);
    }

    this.vendaRepository.cadastra(novaVenda);

    return 0;
  }

  public Integer[] consultaVenda(List<ItemCarrinho> itens, String endereco) {
    Integer subtotal = 0;
    Integer imposto = 0;
    Double frete = 0.0;

    for (final ItemCarrinho prod : itens) {
      if (prod != null) {
        subtotal += (int) prod.getPrecoProd() * prod.getQuantidade();
      } else {
        throw new IllegalArgumentException("Codigo invalido");
      }
    }

    imposto = calculoImposto.calculaImposto(itens);

    if (endereco.equalsIgnoreCase("")){
        endereco = "portoalegre";
    }

    try {
      frete = calculoFrete.calculaFrete("portoalegre", endereco);
    } catch (URISyntaxException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    final Integer[] resp = new Integer[4];
    int freteInt = (int) Math.ceil(frete);

    resp[0] = subtotal;
    resp[1] = imposto;
    resp[2] = subtotal + imposto + freteInt;
    resp[3] = freteInt;
    

    return resp;
  }

  public List<Venda> todos() {
    return vendaRepository.todos();
  }
}
