package com.thevalenciandev.algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindApartmentTest {

    @Test
    void canSpotRequirementsAvailableInDifferentIndices() {
        List<String> requirements = List.of("gym", "store");
        List<Map<String, Boolean>> blocks = List.of(
                Map.of("gym", true, "store", false),
                Map.of("gym", false, "store", false),
                Map.of("gym", false, "store", true)
        );

        int index = FindApartment.find(requirements, blocks);

        assertEquals(1, index);
    }

    @Test
    void canSpotRequirementsAvailableInSameIndex() {
        List<String> requirements = List.of("gym", "store");
        List<Map<String, Boolean>> blocks = List.of(
                Map.of("gym", true, "store", false),
                Map.of("gym", false, "store", true),
                Map.of("gym", true, "store", true)
        );

        int index = FindApartment.find(requirements, blocks);

        assertEquals(2, index);
    }

    @Test
    void providesFirstIndexFoundIfMultipleAvailable() {
        List<String> requirements = List.of("gym", "store");
        List<Map<String, Boolean>> blocks = List.of(
                Map.of("gym", true, "store", true),
                Map.of("gym", false, "store", true),
                Map.of("gym", true, "store", true)
        );

        int index = FindApartment.find(requirements, blocks);

        assertEquals(0, index);
    }

    @Test
    void returnsMinusOneIfNoOptionAvailableWithAllRequirements() {
        List<String> requirements = List.of("gym", "store");
        List<Map<String, Boolean>> blocks = List.of(
                Map.of("gym", false, "store", true),
                Map.of("gym", false, "store", true),
                Map.of("gym", false, "store", true)
        );

        int index = FindApartment.find(requirements, blocks);

        assertEquals(-1, index);
    }

}