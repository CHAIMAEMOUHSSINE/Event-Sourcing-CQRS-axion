package net.chaimae.escqrsaxion.query.repository;
import net.chaimae.escqrsaxion.query.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}