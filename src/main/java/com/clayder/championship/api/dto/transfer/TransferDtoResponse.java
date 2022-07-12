package com.clayder.championship.api.dto.transfer;

import com.clayder.championship.api.entity.TeamEntity;
import com.clayder.championship.core.dto.AbstractDtoCore;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransferDtoResponse extends AbstractDtoCore {
    private TeamEntity originTeam;
    private TeamEntity destinationTeam;
    private LocalDate date;
    private Double amount;
}
