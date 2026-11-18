package net.chaimae.escqrsaxion.commands.dtos;

import net.chaimae.escqrsaxion.enums.AccountStatus;

public record UpdateAccountStatusRequestDTO(String accountId, AccountStatus status) {
}
