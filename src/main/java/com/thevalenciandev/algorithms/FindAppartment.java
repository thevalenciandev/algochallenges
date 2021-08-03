package com.thevalenciandev.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Find the apartment that minimises the furthest distance that you'd have to walk to
 * to get to all the buildings that you value
 */
public class FindAppartment {

    public static final int INITIAL_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Collection<String> requirements = List.of("gym", "store");

        List<Map<String, Boolean>> blocks = List.of(
                Map.of("gym", true, "store", false),
                Map.of("gym", false, "store", false),
//                Map.of("gym", false, "store", false),
                Map.of("gym", false, "store", true)
        );

        // i = 0                distAt0:gym=MAX,store=MAX
        // i = 0, leftIndex = 0 distAt0:gym=0,store=MAX
        // no more left...
        // i = 0, rghtIndex = 1 distAt0:gym=0,store=MAX
        // i = 0, rghtIndex = 2 distAt0:gym=0,store=2
        // found both. Stop iterating
        // Furthest distance = max (0, 2) -> 2

        List<Map<String, Integer>> distances = prepareIndices(requirements, blocks.size());
        // traverse blocks and for each, calculate min distance to requirements, to left and right
        for (int i = 0; i < blocks.size(); i++) {
            // 0. calc itself
            Map<String, Integer> distancesFromIndex = distances.get(i);
            if (allDistancesCalculatedForIndex(distancesFromIndex)) {
                continue;
            }

            updateDistances(0, requirements, distancesFromIndex, blocks.get(i));

            // 1. iterate left
            for (int leftIndex = i - 1; leftIndex >= 0; leftIndex--) {
                if (allDistancesCalculatedForIndex(distancesFromIndex)) {
                    break;
                }
                int distance = Math.abs(i - leftIndex);
                updateDistances(distance, requirements, distancesFromIndex, blocks.get(leftIndex));
            }
            // 2. iterate right
            for (int rightIndex = i + 1; rightIndex < blocks.size(); rightIndex++) {
                if (allDistancesCalculatedForIndex(distancesFromIndex)) {
                    break;
                }
                int distance = rightIndex - i;
                updateDistances(distance, requirements, distancesFromIndex, blocks.get(rightIndex));
            }
        }

        // Determine index from which we minimise the furthest distance to all requirements
        int minDistance = INITIAL_VALUE;
        int index = -1;
        for (int i = 0; i < distances.size(); i++) {
            Map<String, Integer> distancesAtIndex = distances.get(i);
            // This .get() is safe as we assume that all indexes have all "requirements", and have hence been initialised.
            int maxForIndex = distancesAtIndex.values().stream().max(Integer::compareTo).get();
            if (maxForIndex < minDistance) {
                minDistance = maxForIndex;
                index = i;
            }
            minDistance = Math.min(minDistance, maxForIndex);
        }
        System.out.println("Index that minimises the furthest distance to all requirements is " + index + ", with distance " + minDistance);
    }

    private static boolean allDistancesCalculatedForIndex(Map<String, Integer> distancesFromIndex) {
        return distancesFromIndex.values().stream().noneMatch(dist -> dist.equals(INITIAL_VALUE));
    }

    private static void updateDistances(int newDistance, Collection<String> requirements, Map<String, Integer> distancesFromIndex, Map<String, Boolean> buildingsAtIndex) {
        // Calculate distances from the current index to the requirements
        for (String building : requirements) {
            boolean found = buildingsAtIndex.get(building);
            if (found) {
                // recalc distance
                // This unboxing is safe as we assume that all indexes have all "requirements", and have hence been initialised.
                distancesFromIndex.compute(building, (b, currDist) -> Math.min(currDist, newDistance));
            }
        }
    }

    private static List<Map<String, Integer>> prepareIndices(Collection<String> reqs, int size) {
        List<Map<String, Integer>> distances = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            // initialise distances to requirements with maximum values
            distances.add(reqs.stream().collect(Collectors.toMap(building -> building, distance -> INITIAL_VALUE)));
        }
        return distances;
    }
}
