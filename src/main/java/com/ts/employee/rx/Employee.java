package com.ts.employee.rx;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  private String id;
  private Long empId;
  private String name;
  private Integer salary;
  private String depid;
  private String email;


}
