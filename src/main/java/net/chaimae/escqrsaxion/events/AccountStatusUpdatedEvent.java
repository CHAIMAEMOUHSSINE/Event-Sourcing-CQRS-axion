package net.chaimae.escqrsaxion.events;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.chaimae.escqrsaxion.enums.AccountStatus;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountStatusUpdatedEvent {
    private String accountId;
    private AccountStatus status;


}
