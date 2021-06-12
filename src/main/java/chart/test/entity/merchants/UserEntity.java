package chart.test.entity.merchants;

import chart.test.contract.UserState;
import chart.test.contract.UserType;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "telegram_users")
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "user_name", columnDefinition = "text")
  private String userName;

  @Column(name = "customer_name", columnDefinition = "text")
  private String customerName;

  @Column(name = "first_name", columnDefinition = "text")
  private String firstName;

  @Column(name = "last_name", columnDefinition = "text")
  private String lastName;

  @Column(name = "state", columnDefinition = "text")
  @Enumerated(EnumType.STRING)
  private UserState state;

  @Column(name = "available_groups", columnDefinition = "integer[]")
  @Type(type = "list-array")
  private List<Integer> availableGroups;

  @Column(name = "actions_count")
  private Integer actionsCount;

  @Column(name = "activation_token", columnDefinition = "text")
  private String activationToken;

  @Column(name = "first_action_time")
  private ZonedDateTime firstActionTime;

  @Column(name = "is_token_activated")
  private Boolean isTokenActivated;

  @Column(name = "last_action_time")
  private ZonedDateTime lastActionTime;

  @Column(name = "selected_group")
  private Integer selectedGroup;

  @Column(name = "message_id")
  private Integer messageId;

  @Column(name = "user_type", columnDefinition = "text")
  @Enumerated(EnumType.STRING)
  private UserType userType;

  @Column(name = "notification_daily")
  private Boolean notificationDaily;

  @Column(name = "notification_trade_action")
  private Boolean notificationTradeAction;

  @Column(name = "selected_account")
  private Integer selectedAccount;

  @Column(name = "notification_weekly")
  private Boolean notificationWeekly;

  @Column(name = "bot_id")
  private Integer botId;
}
