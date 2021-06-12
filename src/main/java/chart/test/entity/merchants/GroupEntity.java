package chart.test.entity.merchants;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "groups")
public class GroupEntity {

  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;
}
