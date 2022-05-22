package com.bcopstein;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bcopstein"})
@EnableJpaRepositories(basePackages = {"com.bcopstein"})
@EntityScan(basePackages = {"com.bcopstein"}) 
public class SvBkPrototipo {
  public static void main(String[] args) {
    SpringApplication.run(SvBkPrototipo.class, args);
  }
}
//file:///C:/Users/Miguel_Castro/Desktop/Pucrs/T1-ProjArq/Tarefa1_SistemaDeVendas/SvFtEt6/index.html