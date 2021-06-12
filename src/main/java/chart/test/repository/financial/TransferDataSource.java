package chart.test.repository.financial;

import chart.test.entity.financial.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferDataSource extends JpaRepository<TransferEntity, Long> {

  List<TransferEntity> getAllByAccountId(Long accountId);
}
