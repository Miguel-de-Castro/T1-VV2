package com.bcopstein.Aplicacao.casosDeUso;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.entidades.Produto;
import com.bcopstein.Negocio.entidades.Venda;
import com.bcopstein.Negocio.servicos.ProdutoService;
import com.bcopstein.Negocio.servicos.VendaService;
import com.bcopstein.Aplicacao.dtos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraVendaUC {
  private VendaService servicoVenda;
  private ProdutoService servicoProduto;

  @Autowired
  public CadastraVendaUC(VendaService servicoVenda, ProdutoService servicoProduto) {
    this.servicoVenda = servicoVenda;
    this.servicoProduto = servicoProduto;
  }

  public Integer executar(ParamSubtotal_DTO dto) {

    List<ItemCarrinho> itens = new ArrayList<>(0);
    List<Produto> produtos = servicoProduto.todos();

    for (ItemCarrinho item : dto.getItens()) {
      Produto novoProduto = produtos.stream().filter(p -> p.getCodigo() == item.getCodProduto() ).findFirst().orElse(null);
      itens.add(new ItemCarrinho(novoProduto.getCodigo(), Double.valueOf(novoProduto.getPreco()).intValue(),
          item.getQuantidade()));
    }

    // Erro calculo do frete
    Integer[] valores = servicoVenda.consultaVenda(itens , dto.getEndereco());
    if(valores[3] == 0){
      return 3;
    }

    Venda novaVenda = new Venda(valores[0], valores[1], valores[2], itens);
    return servicoVenda.cadastraVenda(novaVenda);
  }
}
