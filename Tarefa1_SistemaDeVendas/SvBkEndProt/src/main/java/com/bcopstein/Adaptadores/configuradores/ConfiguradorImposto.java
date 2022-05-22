package com.bcopstein.Adaptadores.configuradores;

import com.bcopstein.Negocio.servicos.ICalculoImposto;
import com.bcopstein.Aplicacao.servicos.ImpostoUm;
import com.bcopstein.Aplicacao.servicos.ImpostoDois;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfiguradorImposto {

  @Bean
  @Primary
  @ConditionalOnProperty(name = "venda.imposto", havingValue = "um", matchIfMissing = true)
  public ICalculoImposto opcaoPaisUm() {
    return new ImpostoUm();
  }

  @Bean
  @ConditionalOnProperty(name = "venda.imposto", havingValue = "dois")
  public ICalculoImposto opcaoPaisDois() {
    return new ImpostoDois();
  }
}