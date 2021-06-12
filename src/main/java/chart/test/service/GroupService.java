package chart.test.service;

import chart.test.entity.merchants.GroupEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import chart.test.repository.merchants.GroupRepository;

@Service
@RequiredArgsConstructor
public class GroupService {

  private final GroupRepository groupRepository;

  public GroupEntity getById(Integer id) {
    return groupRepository.findById(id)
            .orElseGet(GroupEntity::new);
  }
}
