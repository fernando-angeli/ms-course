package com.fernandoangeli.hrworker.repositories;

import com.fernandoangeli.hrworker.domains.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
