package net.chaimae.escqrsaxion.commands.dtos;

public record DebitAccountRequestDTO(String accountId, double amount, String currency) {
}
