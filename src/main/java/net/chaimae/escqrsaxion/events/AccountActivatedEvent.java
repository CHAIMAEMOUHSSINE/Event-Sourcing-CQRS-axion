package net.chaimae.escqrsaxion.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.chaimae.escqrsaxion.enums.AccountStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccountActivatedEvent {
    private String accountId;
    private AccountStatus status;


}
