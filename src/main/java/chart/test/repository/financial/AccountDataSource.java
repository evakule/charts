package chart.test.repository.financial;

import chart.test.entity.financial.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountDataSource extends JpaRepository<AccountEntity, Long> {

  @Query(value = "select * from accounts where ?1 = ANY(groups)", nativeQuery = true)
  Optional<List<AccountEntity>> getAccountsByGroup(Integer groupId);

}
