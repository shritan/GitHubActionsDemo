/**
 *@author Mohan Rao
 */
package com.test.objectmapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RapBallotRequest {
    private RapBallotDetails rapBallotDetails;
}
