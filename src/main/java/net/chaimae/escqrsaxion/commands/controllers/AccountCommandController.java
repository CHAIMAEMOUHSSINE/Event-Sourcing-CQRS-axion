package net.chaimae.escqrsaxion.commands.controllers;

import net.chaimae.escqrsaxion.commands.commands.AddAccountCommand;
import net.chaimae.escqrsaxion.commands.commands.CreditAccountCommand;
import net.chaimae.escqrsaxion.commands.commands.DebitAccountCommand;
import net.chaimae.escqrsaxion.commands.commands.UpdateAccountStatusCommand;
import net.chaimae.escqrsaxion.commands.dtos.AddNewAccountRequestDTO;
import net.chaimae.escqrsaxion.commands.dtos.CreditAccountRequestDTO;
import net.chaimae.escqrsaxion.commands.dtos.DebitAccountRequestDTO;
import net.chaimae.escqrsaxion.commands.dtos.UpdateAccountStatusRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("commands/accounts")
public class AccountCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    public AccountCommandController(CommandGateway commandGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }

    @PostMapping("/add")
    public String addNewAccount(@RequestBody AddNewAccountRequestDTO request){
        CompletableFuture<String> response = commandGateway.send(new AddAccountCommand(
                UUID.randomUUID().toString(),
                request.initialBalance(),
                request.currency()
        ));
        return response.join();

    }


    @PostMapping("/credit")
    public CompletableFuture<String> creditAccount(@RequestBody CreditAccountRequestDTO request){
        CompletableFuture<String> result = this.commandGateway.send(new CreditAccountCommand(
                request.accountId(),
                request.amount(),
                request.currency()
        ));
        return result;
    }

    @PostMapping("/debit")
    public CompletableFuture<String> debitAccount(@RequestBody DebitAccountRequestDTO request){
        CompletableFuture<String> result = this.commandGateway.send(new DebitAccountCommand(
                request.accountId(),
                request.amount(),
                request.currency()
        ));
        return result;
    }

    @PutMapping("/updateStatus")
    public CompletableFuture<String> updateAccountStatus(@RequestBody UpdateAccountStatusRequestDTO request){
        CompletableFuture<String> result = this.commandGateway.send(new UpdateAccountStatusCommand(
                request.accountId(),
                request.status()
        ));
        return result;

    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception ex) {
        return ex.getMessage();
    }

    @GetMapping("/events/{accountId}")
    public Stream eventStore(@PathVariable String accountId) {
        return eventStore.readEvents(accountId).asStream();
    }
}


}
