package net.chaimae.escqrsaxion.query.handlers;

import net.chaimae.escqrsaxion.query.dtos.AccountStatementResponseDTO;
import net.chaimae.escqrsaxion.query.entities.Account;
import net.chaimae.escqrsaxion.query.entities.Operation;
import net.chaimae.escqrsaxion.query.queries.GetAccountStatementQuery;
import net.chaimae.escqrsaxion.query.queries.GetAllAccountsQuery;
import net.chaimae.escqrsaxion.query.queries.WatchEventQuery;
import net.chaimae.escqrsaxion.query.repository.AccountRepository;
import net.chaimae.escqrsaxion.query.repository.OperationRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountQueryHandler {
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;

    public AccountQueryHandler(AccountRepository accountRepository, OperationRepository operationRepository) {
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }
    @QueryHandler
    public List<Account> on(GetAllAccountsQuery query){
        return accountRepository.findAll();
    }

    @QueryHandler
    public AccountStatementResponseDTO on(GetAccountStatementQuery query){
        Account account = accountRepository.findById(query.getAccountId()).get();
        List<Operation> operations = operationRepository.findByAccountId(query.getAccountId());
        return new AccountStatementResponseDTO(account, operations);
    }

    @QueryHandler
    public Operation on(WatchEventQuery query){
        return Operation.builder().build();
    }

}