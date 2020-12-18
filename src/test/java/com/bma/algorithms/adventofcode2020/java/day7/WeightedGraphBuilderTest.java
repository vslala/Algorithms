package com.bma.algorithms.adventofcode2020.java.day7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class WeightedGraphBuilderTest {

    private static final String PATH =  "/Users/in-varun.shrivastava/Code/src/github.com/java/Algorithms/src/main/java/com/bma/algorithms/adventofcode2020/inputs/day7test.txt";

    private WeightedGraphBuilder wgb;

    @BeforeEach
    void setup()  {
        wgb = new WeightedGraphBuilder();
    }

    @Test
    void itShouldBuildWeightedGraphFromFile() {
        WeightedGraph  wg = wgb.buildFromFileInput(Path.of(PATH));
        assertNotNull(wg);

//        wg.print();
    }

}