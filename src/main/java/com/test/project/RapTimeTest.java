/**
 *
 */
package com.test.project;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 */
public class RapTimeTest {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final RapTimes[] rapAry = { new RapTimes(1000, 10, 2, 3, 4, 6), new RapTimes(1001, 10, 2, 3, 4, 6),
            new RapTimes(2000, 10, 2, 3, 4, 6), new RapTimes(2002, 10, 2, 3, 4, 6) };
        final List<RapTimes> rapTimes = Arrays.asList(rapAry);
        final List<Integer> integers = Stream.of(1000, 2002).toList();
        List<RapTimes> rapTimeList =
            rapTimes.stream().filter(rapTime -> integers.stream().anyMatch(
                // t -> Objects.equals(t, rapTime.getRapTimesId())
                t -> t.equals(rapTime.getRapTimesId())))
                .toList();
        rapTimeList = rapTimeList.stream().map(t -> {
            t.setActiveInd(0);
            return t;
        }).toList();
        rapTimeList.forEach(t -> System.out.println(t.getRapTimesId() + " = AciveInd = " + t.getActiveInd()));
    }

}
