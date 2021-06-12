package chart.test.entity.financial;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "transfers")
public class TransferEntity {
  @Id
  @Column(name = "tx_id")
  private Long txId;

  @Column(name = "account_id")
  private Long accountId;

  @Column(name = "amount", precision = 20, scale = 8)
  private BigDecimal amount;

  @Column(name = "asset")
  private String asset;

  @Column(name = "status")
  private String status;

  @Column(name = "timestamp")
  private ZonedDateTime timestamp;

  @Column(name = "transfer_counterparty")
  private String transferCounterparty;

  @Column(name = "type")
  private String type;

}
