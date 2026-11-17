package net.chaimae.escqrsaxion.commands.aggregates;

import lombok.extern.slf4j.Slf4j;
import net.chaimae.escqrsaxion.commands.commands.AddAccountCommand;
import net.chaimae.escqrsaxion.enums.AccountStatus;
import net.chaimae.escqrsaxion.events.AccountActivatedEvent;
import net.chaimae.escqrsaxion.events.AccountCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class AccountAggregate {
    @AggregateIdentifier
    private String accountId;
    private double balance;
    private AccountStatus status;
    //pour Axon
    public AccountAggregate() {}

    @CommandHandler
    // fct d'activation de l'aggregate, elle est appelée lors de la réception d'un AddAccountCommand
    public AccountAggregate(AddAccountCommand command) {
        log.info("########################### Add Account   command received ##########################");
        if(command.getInitialBalance() < 0) throw new IllegalArgumentException("Initial balance cannot be negative");
        AggregateLifecycle.apply(new AccountCreatedEvent(
                command.getId(),
                command.getInitialBalance(),
                command.getCurrency(),
                AccountStatus.CREATED
        ));
    }
    @EventSourcingHandler
    // fct d'evolution de l'aggregate, elle est appelée lors de la réception d'un AccountCreatedEvent
    public void on(AccountCreatedEvent event) {
        log.info("########################### Account Created Event occured ##########################");
        this.accountId = event.getAccountId();
        this.balance = event.getInitialBalance();
        this.status = event.getStatus();
    }

}
