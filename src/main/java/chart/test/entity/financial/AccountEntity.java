package chart.test.entity.financial;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "accounts")
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public class AccountEntity {

  @Id
  @Column(name = "id")
  private Long id;

  @Getter
  @Column(name = "account_currency")
  private String accountCurrency;

  @Getter
  @Column(name = "allow_open_new_positions")
  private Boolean allowOpenNewPositions;

  @Getter
  @Column(name = "api_key")
  private String apiKey;

  @Getter
  @Column(name = "api_secret")
  private String apiSecret;

  @Getter
  @Column(name = "comment")
  private String comment;

  @Getter
  @Setter
  @Column(name = "datasourceid")
  private Integer dataSourceId;

  @Getter
  @Type(type = "list-array")
  @Column(name = "groups", columnDefinition = "integer[]")
  private List<Integer> groups;

  @Getter
  @Column(name = "high_water_mark")
  private BigDecimal highWaterMark;

  @Getter
  @Column(name = "is_enabled")
  private Boolean isEnabled;

  @Getter
  @Column(name = "label")
  private String label;

  @Getter
  @Column(name = "launch_time")
  private ZonedDateTime launchTime;

  @Getter
  @Column(name = "max_drawdown_value")
  private BigDecimal maxDrawdownValue;

  @Getter
  @Column(name = "performance_fee_rate")
  private BigDecimal performanceFeeRate;

  @Getter
  @Column(name = "portfolio_name")
  private String portfolioName;

  @Getter
  @Column(name = "trading_volume")
  private BigDecimal tradingVolume;

  public final BigDecimal getTradingVolumeWithScale() {
    return tradingVolume.setScale(2, RoundingMode.HALF_EVEN);
  }

  public final BigDecimal getMaxDrawdownValueWithScale() {
    return maxDrawdownValue.setScale(2, RoundingMode.HALF_EVEN);
  }
}
