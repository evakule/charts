package controller;

import chart.test.contract.UpdateReason;
import chart.test.entity.financial.BalanceEntity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
  private static final String BALANCES = "C:/Users/enric/Desktop/balances_202106122024.csv";
  private static final String BALANCES_OUTPUT = "C:/Users/egor.vakulenko/Desktop/output.csv";

  public static void main(String[] args) {
    getBalances().forEach(System.out::println);
  }

  private static List<BalanceEntity> getBalances() {
    int counter = 0;
    String row;
    List<BalanceEntity> balances = new ArrayList<>();
    try (
            BufferedReader csvReader = new BufferedReader(new FileReader(BALANCES));
    ) {
      while ((row = csvReader.readLine()) != null) {
        if (counter > 0) {
          String[] rowColumns = row.split(",");
          BalanceEntity balanceEntity = buildBalanceEntity(rowColumns);
          balances.add(balanceEntity);
        }
        counter++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return balances;
  }

  private static BalanceEntity buildBalanceEntity(String[] rowColumns) {
    BalanceEntity balanceEntity = new BalanceEntity();
    balanceEntity.setId(rowColumns[0]);
    balanceEntity.setAccountId(Long.valueOf(rowColumns[1]));
    balanceEntity.setBalanceBtc(new BigDecimal(rowColumns[2]));
    balanceEntity.setBalanceTotal(new BigDecimal(rowColumns[3]));
    balanceEntity.setBalanceUsdt(new BigDecimal(rowColumns[4]));
    balanceEntity.setUpdateReason(UpdateReason.valueOf(rowColumns[5]));
    balanceEntity.setUpdateTime(getTimeFromString(rowColumns[6]));
    balanceEntity.setBalanceBnb(new BigDecimal(rowColumns[7]));
    balanceEntity.setBnbusdtPrice(new BigDecimal(rowColumns[8]));
    balanceEntity.setBtcusdtPrice(new BigDecimal(rowColumns[9]));
    balanceEntity.setBalanceBusd(new BigDecimal(rowColumns[10]));
    balanceEntity.setBtcbusdPrice(new BigDecimal(rowColumns[11]));
    return balanceEntity;
  }

  private static ZonedDateTime getTimeFromString(String timeStr) {
    return LocalDate.parse(
            timeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    ).atStartOfDay(ZoneId.systemDefault());
  }

}
