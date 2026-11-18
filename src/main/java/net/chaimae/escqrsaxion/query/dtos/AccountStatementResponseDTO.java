package net.chaimae.escqrsaxion.query.dtos;
import net.chaimae.escqrsaxion.query.entities.Account;
import net.chaimae.escqrsaxion.query.entities.Operation;

import java.util.List;

public record AccountStatementResponseDTO(Account account, List<Operation> operations) {

}