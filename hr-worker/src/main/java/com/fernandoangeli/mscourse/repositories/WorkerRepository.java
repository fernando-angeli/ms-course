package com.fernandoangeli.mscourse.repositories;

import com.fernandoangeli.mscourse.domains.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
