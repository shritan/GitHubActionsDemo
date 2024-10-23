package com.test.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class TestListPartitionExp {

    public static void main(final String[] args) {

        final List<CrewMemberKeyDTO> crewMemberKeysList = new ArrayList<>();
        // crewMemberKeysList.stream().collect(Collectors.partitioningBy(t -> t))
        for (int i = 1; i <= 20; i++) {
            final CrewMemberKeyDTO crewMemberKeyDTO = new CrewMemberKeyDTO();
            crewMemberKeyDTO.setAirlineCode(AirlineCode.AA);
            crewMemberKeyDTO.setEmployeeNumber(i);
            crewMemberKeysList.add(crewMemberKeyDTO);
        }
        for (final List<CrewMemberKeyDTO> list2 : partitionList(crewMemberKeysList, 8).toList()) {
            System.out.println(list2);
        }
        // crewMemberKeysList.stream().collect(Collectors.partitioningBy(t -> t));

        /*
         * final List<List<CrewMemberKeyDTO>> crewMemberKeyListOfLists = Lists
         * partition(crewMemberKeysList, 10);
         */
        final List<Integer> integers = getNumbersUsingIntStreamRange(1, 100);
        final List<Integer> integers2 = new ArrayList<>();
        final List<List<Integer>> inList = Lists.partition(integers, 10);
        inList.forEach(integers2::addAll);
        integers2.forEach(System.out::println);

    }

    static <T> Stream<List<T>> partitionList(final List<T> source, final int batchSize) {
        if (batchSize <= 0) {
            throw new IllegalArgumentException(String.format("The batchSize cannot be smaller than 0. Actual value: %s", batchSize));
        }
        if (source.isEmpty()) {
            return Stream.empty();
        }
        final int nrOfFullBatches = (source.size() - 1) / batchSize;
        return IntStream.rangeClosed(0, nrOfFullBatches)
            .mapToObj(batch -> {
                final int startIndex = batch * batchSize;
                final int endIndex = (batch == nrOfFullBatches) ? source.size() : (batch + 1) * batchSize;
                return source.subList(startIndex, endIndex);
            });
    }

    public static List<Integer> getNumbersUsingIntStreamRange(final int start, final int end) {
        return IntStream.rangeClosed(start, end)
            .boxed()
            .toList();
    }
}
