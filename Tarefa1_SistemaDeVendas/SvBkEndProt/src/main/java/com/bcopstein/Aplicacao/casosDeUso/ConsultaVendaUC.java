package com.bcopstein.Aplicacao.casosDeUso;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.Negocio.servicos.ProdutoService;
import com.bcopstein.Aplicacao.dtos.ParamSubtotal_DTO;
import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.entidades.Produto;
import com.bcopstein.Negocio.servicos.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaVendaUC {
  private VendaService servicoVenda;
  private ProdutoService servicoProduto;

  @Autowired
  public ConsultaVendaUC(VendaService servicoVenda, ProdutoService servicoProduto) {
    this.servicoVenda = servicoVenda;
    this.servicoProduto = servicoProduto;
  }

  public Integer[] executar(ParamSubtotal_DTO dto) {
    List<ItemCarrinho> itens = new ArrayList<>(0);
    List<Produto> produtos = servicoProduto.todos();

    for (ItemCarrinho item : dto.getItens() ) {
      Produto novoProduto = produtos.stream().filter(p -> p.getCodigo() == item.getCodProduto()).findFirst().orElse(null);
      itens.add(new ItemCarrinho(novoProduto.getCodigo(), Double.valueOf(novoProduto.getPreco()).intValue(),
          item.getQuantidade()));
    }

    return servicoVenda.consultaVenda(itens,dto.getEndereco());
  }
}
