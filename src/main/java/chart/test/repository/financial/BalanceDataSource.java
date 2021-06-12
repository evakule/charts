package chart.test.repository.financial;

import chart.test.entity.financial.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BalanceDataSource extends JpaRepository<BalanceEntity, Long> {

  Optional<BalanceEntity> findTopByAccountIdOrderByUpdateTimeDesc(Long accountId);

  @Query(value = "select * from balances where account_id = " +
          "(select id from accounts where label = ?1 limit 1) " +
          "order by update_time desc limit 1",
          nativeQuery = true)
  Optional<BalanceEntity> getBalanceByLabel(String label);
}
