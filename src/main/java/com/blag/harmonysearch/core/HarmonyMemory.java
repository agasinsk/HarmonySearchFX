package com.blag.harmonysearch.core;

import com.blag.harmonysearch.helpers.BoundedTreeSet;
import lombok.Getter;
import lombok.Setter;

import java.util.SortedSet;

/**
 * Stores best solutions for harmony search algorithm
 */
@Getter
@Setter
class HarmonyMemory {

    private SortedSet<Solution> solutions;

    HarmonyMemory(int harmonyMemorySize){

        solutions = new BoundedTreeSet<>(harmonyMemorySize, new SolutionValueComparator());
    }

    Solution getBestSolution()
    {
        return solutions.first();
    }

    Solution getWorstSolution()
    {
        return solutions.last();
    }

    void clear(){
        solutions.clear();
    }

    void add(Solution solution) {
        solutions.add(solution);
    }
}