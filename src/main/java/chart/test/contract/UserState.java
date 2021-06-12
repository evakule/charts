package chart.test.contract;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserState {

  MAIN_MENU("Main menu"),
  STATISTIC("Statistics"),
  ACCOUNTS("Accounts"),
  ACCOUNT("Account"),
  GROUPS("Groups"),
  GROUP("Group"),
  NOTIFICATIONS("Notifications"),
  ABOUT_COMPANY("About Company"),
  PNL_CHART("PNL Chart"),
  REPORT("Report"),
  ACCOUNT_TO_GROUP("Account to group");

  private final String title;
}
