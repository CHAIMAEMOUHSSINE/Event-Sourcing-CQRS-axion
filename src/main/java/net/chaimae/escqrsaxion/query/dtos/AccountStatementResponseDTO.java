package net.chaimae.escqrsaxion.query.dtos;
import net.chaimae.escqrsaxion.query.entities.Account;

import java.util.List;

public record AccountStatementResponseDTO(Account account, List<Operation> operations) {

}