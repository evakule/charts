package chart.test.contract;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserType {
  CUSTOMER("customer"),
  FUND_MANAGER("fund manager"),
  ADMIN("administrator"),
  TECH_ADMIN("technical administrator");

  @Getter
  private final String typeDefinition;
}
