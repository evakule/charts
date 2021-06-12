package chart.test.entity.financial;

import chart.test.contract.UpdateReason;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "balances")
public class BalanceEntity {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "account_id")
  private Long accountId;

  @Column(name = "balance_bnb", precision = 20, scale = 8)
  private BigDecimal balanceBnb;

  @Column(name = "balance_btc", precision = 20, scale = 8)
  private BigDecimal balanceBtc;

  @Column(name = "balance_busd", precision = 20, scale = 8)
  private BigDecimal balanceBusd;

  @Column(name = "balance_total", precision = 20, scale = 2)
  private BigDecimal balanceTotal;

  @Column(name = "balance_usdt", precision = 20, scale = 8)
  private BigDecimal balanceUsdt;

  @Column(name = "bnbusdt_price", precision = 20, scale = 2)
  private BigDecimal bnbusdtPrice;

  @Column(name = "btcbusd_price", precision = 20, scale = 2)
  private BigDecimal btcbusdPrice;

  @Column(name = "btcusdt_price", precision = 20, scale = 2)
  private BigDecimal btcusdtPrice;

  @Column(name = "update_reason")
  @Enumerated(EnumType.STRING)
  private UpdateReason updateReason;

  @Column(name = "update_time")
  private ZonedDateTime updateTime;
}
