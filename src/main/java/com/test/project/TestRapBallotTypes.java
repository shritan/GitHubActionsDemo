/**
 *
 */
package com.test.project;

import java.util.Arrays;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.test.objectmapper.RapBallotDetails;

/**
 *
 */
public class TestRapBallotTypes {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final List<String> types = Arrays.asList("MONTHLY");
        final List<RapBallotDetails> rapBallotDetails =
            Arrays.asList(new RapBallotDetails("EARLIEST", null, null, 0, 0, 0, null, 0, null, null),
                new RapBallotDetails("DAILY", null, null, 0, 0, 0, null, 0, null, null)
            // new RapBallotDetails("MONTHLY", null, null, 0, 0, 0, null, 0, null, null)
            );
        final List<String> mpaBallotTypes = rapBallotDetails.stream().map(t -> t.getBallotType()).toList();
        final List<String> commonElements = types.stream()
            .filter(mpaBallotTypes::contains)
            .toList();
        if (!CollectionUtils.isEmpty(commonElements)) {
            System.out.println(commonElements);
        }
    }

}
