package org.example;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class FindingBenchamrk {
    @Benchmark
    public void finidngWrongElementsBenchmark(BenchamakrDataPreparationService benchmark) {
        ArrayList<Film> copy = new ArrayList<>(benchmark.testList);
        FindingAndDeletingWrongData.findWrongData(copy);
    }
}
