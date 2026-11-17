package net.chaimae.escqrsaxion.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.chaimae.escqrsaxion.enums.AccountStatus;
@Getter @AllArgsConstructor
public class AccountCreatedEvent {
    private String accountId;
    private double initialBalance;
    private String currency;
    private AccountStatus status;
}
