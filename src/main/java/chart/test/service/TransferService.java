package chart.test.service;

import chart.test.entity.financial.TransferEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import chart.test.repository.financial.TransferData;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferService {
  private final TransferData transferData;

  public List<TransferEntity> getAllByAccountId(Long id) {
    return transferData.getAllByAccountId(id);
  }
}
