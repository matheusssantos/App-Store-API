package com.pucrs.api.enums;

public enum SubscriptionStatusEnum {
  NEW(0),
  PENDING_PAYMENT(1),
  ACTIVE(2),
  CANCELED(3);

  private final int code;

  SubscriptionStatusEnum(int code) {
    this.code = code;
  } 

  public int getCode() {
    return code;
  }
}
