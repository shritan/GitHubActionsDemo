package com.test.archive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestPilotList {

    public static void main(final String[] args) {
        final List<PilotDetails> pilotDetails1 = new ArrayList<>(
                List.of(new PilotDetails(1, "jose", "ght"), new PilotDetails(2, "Larry", " Abx"), new PilotDetails(3, "Abc", "xyz"),
                    new PilotDetails(4, "def", "gh")));

        final List<PilotDetails> pilotDetails2 = new ArrayList<>(
                List.of(new PilotDetails(3, "Abc", "xyz"), new PilotDetails(4, "Larry", " Abx"), new PilotDetails(5, "Abc", "xyz"),
                    new PilotDetails(6, "def", "gh")));
        pilotDetails1.addAll(pilotDetails2);
        // pilotDetails1.forEach(t -> System.out.println(t.getPilotId() + "," + t.getFirstName() +
        // "," + t.getLastName()));
        System.out.println("suze " + pilotDetails1.size());
        final Map<Integer, PilotDetails> map = new HashMap<>();
        fillPilotDetailsMap(map, pilotDetails1);
        System.out.println(map.size());
    }

    private static void fillPilotDetailsMap(final Map<Integer, PilotDetails> map, final List<PilotDetails> pilotDetails) {
        // map = pilotDetails.stream().collect(Collectors.toMap(PilotDetails::getPilotId, p1 -> p1,
        // (p1, p2) -> p1));
        pilotDetails.stream().forEach(t -> {
            map.put(t.getPilotId(), t);
        });
        map.values().stream().forEach(t -> System.out.println(t));
    }

}
