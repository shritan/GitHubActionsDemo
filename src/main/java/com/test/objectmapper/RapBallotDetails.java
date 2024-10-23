/**
 *
 */
package com.test.objectmapper;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RapBallotDetails {
    private String ballotType;

    private String contractMonth;

    private LocalDate dailyRapDate;

    private int employeeId;

    private int createdBy;

    private int activeInd;

    private List<RapBallotTimes> rapBallotTimes;

    private int standingInd;

    private LocalDate earliestRapTime;

    private LocalDate latestRapTime;
}
