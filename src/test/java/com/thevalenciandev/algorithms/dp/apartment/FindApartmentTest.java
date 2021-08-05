package com.thevalenciandev.algorithms.dp.apartment;

import com.thevalenciandev.algorithms.dp.apartment.Building;
import com.thevalenciandev.algorithms.dp.apartment.FindApartment;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindApartmentTest {

    static final Building GYM = new Building("gym");
    static final Building STORE = new Building("store");

    @Test
    void canSpotRequirementsAvailableInDifferentIndices() {
        List<Building> requirements = List.of(GYM, STORE);
        List<Map<Building, Boolean>> blocks = List.of(
                Map.of(GYM, true, STORE, false),
                Map.of(GYM, false, STORE, false),
                Map.of(GYM, false, STORE, true)
        );

        int index = FindApartment.find(requirements, blocks);

        assertEquals(1, index);
    }

    @Test
    void canSpotRequirementsAvailableInSameIndex() {
        List<Building> requirements = List.of(GYM, STORE);
        List<Map<Building, Boolean>> blocks = List.of(
                Map.of(GYM, true, STORE, false),
                Map.of(GYM, false, STORE, true),
                Map.of(GYM, true, STORE, true)
        );

        int index = FindApartment.find(requirements, blocks);

        assertEquals(2, index);
    }

    @Test
    void providesFirstIndexFoundIfMultipleAvailable() {
        List<Building> requirements = List.of(GYM, STORE);
        List<Map<Building, Boolean>> blocks = List.of(
                Map.of(GYM, true, STORE, true),
                Map.of(GYM, false, STORE, true),
                Map.of(GYM, true, STORE, true)
        );

        int index = FindApartment.find(requirements, blocks);

        assertEquals(0, index);
    }

    @Test
    void returnsMinusOneIfNoOptionAvailableWithAllRequirements() {
        List<Building> requirements = List.of(GYM, STORE);
        List<Map<Building, Boolean>> blocks = List.of(
                Map.of(GYM, false, STORE, true),
                Map.of(GYM, false, STORE, true),
                Map.of(GYM, false, STORE, true)
        );

        int index = FindApartment.find(requirements, blocks);

        assertEquals(-1, index);

        System.out.println("abcde".substring(3, 4));
    }

    @Test
    void dynamicProgrammingTest() {
        List<Building> requirements = List.of(GYM, STORE);
        List<Map<Building, Boolean>> blocks = List.of(
                Map.of(GYM, false, STORE, true),
                Map.of(GYM, false, STORE, false),
                Map.of(GYM, false, STORE, false),
                Map.of(GYM, false, STORE, false),
                Map.of(GYM, false, STORE, false),
                Map.of(GYM, false, STORE, false),
                Map.of(GYM, false, STORE, false),
                Map.of(GYM, false, STORE, true),
                Map.of(GYM, true, STORE, true)
        );

        int index = FindApartment.find(requirements, blocks);

        assertEquals(8, index);
    }

}