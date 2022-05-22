package com.bcopstein.Negocio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemCarrinho {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer codigo;

  @Column(name = "cod_produto")
  private Integer codProduto;
  private Integer precoProd;
  private int quantidade;

  public ItemCarrinho(Integer codProduto, Integer precoProd, int quantidade) {
    this.codProduto = codProduto;
    this.precoProd = precoProd;
    this.quantidade = quantidade;
  }

  public ItemCarrinho() {

  }

 public Integer getCodProduto() {
    return codProduto;
  }

  public void setCodProduto(Integer codProduto) {
    this.codProduto = codProduto;
  }

  public Integer getPrecoProd() {
    return precoProd;
  }

  public void setPrecoProd(Integer precoProd) {
    this.precoProd = precoProd;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

 

  @Override
  public String toString() {
    return "ItemCarrinho [codProduto=" + codProduto + ", codigo=" + codigo + ", precoProd=" + precoProd
        + ", quantidade=" + quantidade + "]";
  }
}
