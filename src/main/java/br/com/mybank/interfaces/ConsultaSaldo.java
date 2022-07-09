package br.com.mybank.interfaces;
import java.math.BigDecimal;

public interface ConsultaSaldo {

  /**
   * Implementar na conta corrente e conta poupanca
   */
  public BigDecimal consultarSaldo();
}
