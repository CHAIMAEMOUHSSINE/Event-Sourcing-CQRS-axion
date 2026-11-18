package net.chaimae.escqrsaxion.query.repository;

import net.chaimae.escqrsaxion.query.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation,Long> {
    List<Operation> findByAccountId(String id);
}