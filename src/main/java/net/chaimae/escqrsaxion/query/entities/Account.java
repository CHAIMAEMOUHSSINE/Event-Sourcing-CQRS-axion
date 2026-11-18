package net.chaimae.escqrsaxion.query.entities;


import jakarta.persistence.*;
import lombok.*;
import net.chaimae.escqrsaxion.enums.AccountStatus;


import java.time.Instant;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Account {
    @Id
    private String id;
    private Instant createdAt;
    private double balance;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private String currency;
}