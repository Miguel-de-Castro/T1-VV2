package com.bcopstein.Negocio.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "estoque")
public class ItemEstoque {

  @Id
  @Column(name = "cod_estoque")
  private Integer codEstoque;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "cod_produto")
  private Produto produto;
  private int quantidade;

  public ItemEstoque(Integer codEstoque, Produto produto, int quantidade) {
    this.codEstoque = codEstoque;
    this.produto = produto;
    this.quantidade = quantidade;
  }

  public ItemEstoque() {
  }

  public Integer getCodEstoque() {
    return codEstoque;
  }

  public void setCodEstoque(Integer codEstoque) {
    this.codEstoque = codEstoque;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

}
