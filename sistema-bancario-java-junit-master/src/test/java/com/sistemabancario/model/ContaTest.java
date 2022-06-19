package com.sistemabancario.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {

  //@Test
  //void setNumeroR1() {
  //Conta conta = new Conta();
  //conta.setNumero("123");
   //}

    @Test
    void setNumeroR1a() {
    final Conta conta = new Conta();
    final String invalido = "123";
    assertThrows(IllegalArgumentException.class, 
    () -> conta.setNumero(invalido));
    final String obtido = conta.getNumero();
    assertNotEquals(invalido,obtido);

    }
    @Test
    void setNumeroR1b() {
    final Conta conta = new Conta();
    final String invalido = "abcde-f";
    //aassertThrows == tem que dar erro
    assertThrows(IllegalArgumentException.class, () -> conta.setNumero(invalido));
    }

    @Test
    void setNumeroR1c() {
    final Conta conta = new Conta();
    final String invalido= "12345-f";
    assertThrows(IllegalArgumentException.class,
    () -> conta.setNumero(invalido));

    }

    @Test
    void setNumeroR1d() {
    final Conta conta = new Conta();
    final String esperado = "12345-6";
    assertThrows(IllegalArgumentException.class,
    () -> conta.setNumero(esperado));
    final String obtido = conta.getNumero();
    assertNotEquals(esperado,obtido);

 }

@Test
void testSetLimiteContaNãoEspecial(){
  final Conta instance = new Conta();
  final double limite = 1000;
  assertThrows(IllegalStateException.class,()-> instance.setLimite(limite));
}

@Test
void testHistoricoNotNull(){
  final Conta instance = new Conta();
  assertNotNull(instance.getMovimentacoes());
}

@Test
void testGetSaldoTotal(){
final double limite = 500;
final double esperado = Limite;
final Conta instance = new Conta();
instance.setEspecial(true);
instance.setLimite(limite);
final double obtido = instance.getSaldoTotal();
assertEquals(esperado,obtido);  
}


    @Test
    void testDepositoDinheiro(){
      final double limite = 500.6, deposito = 500.8, esperado = 1001.4;
      final Conta instance = new Conta();
      instance.setEspecial(true);
      instance.setLimite(limite);
      instance.depositoDinheiro(deposito);

      final double obtido = instance.getSaldoTotal();
      assertEquals(esperado,obtido);
    }

     @Test
    void testDepositoDinheiro(){
  final double limite = 500, deposito = 500, esperado = 1000;
      final Conta instance = new Conta();
      instance.setEspecial(true);
      instance.setLimite(limite);
      instance.depositoDinheiro(deposito);

      final double obtido = instance.getSaldoTotal();
      assertEquals(esperado,obtido, 0.001);

    }

}
