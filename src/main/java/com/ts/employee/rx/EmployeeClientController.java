package com.ts.employee.rx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class EmployeeClientController {

  @Autowired
  WebClient webClient;


  @GetMapping("/employees")
  public Flux<Employee> getEmployees() {
    return webClient.get().uri("/api/employees").retrieve().bodyToFlux(Employee.class);

  }


  @PostMapping("/employee/create")
  public Mono<Employee> createEmployee(@RequestBody Employee emp) {
    return webClient.post().uri("/api/employee/create").syncBody(emp).retrieve()
        .bodyToMono(Employee.class);
  }



}
