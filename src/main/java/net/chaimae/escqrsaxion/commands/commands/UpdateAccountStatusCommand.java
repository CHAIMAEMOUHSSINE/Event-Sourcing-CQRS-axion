package net.chaimae.escqrsaxion.commands.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.chaimae.escqrsaxion.enums.AccountStatus;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter @AllArgsConstructor
public class UpdateAccountStatusCommand {
    @TargetAggregateIdentifier
    private String id;
    private AccountStatus status;

}