package net.chaimae.escqrsaxion.commands.dtos;


public record CreditAccountRequestDTO(String accountId, double amount, String currency) {
}