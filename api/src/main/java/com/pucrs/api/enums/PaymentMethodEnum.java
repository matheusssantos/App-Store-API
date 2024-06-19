package com.pucrs.api.enums;

public enum PaymentMethodEnum {
  MONEY(0),
  PIX(1),
  CREDIT_CARD(2);

  private final int code;

  PaymentMethodEnum(int code) {
    this.code = code;
  } 

  public int getCode() {
    return code;
  }
}
