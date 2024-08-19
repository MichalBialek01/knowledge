package org.example;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;

@State(Scope.Benchmark)

public class BenchamakrDataPreparationService {
    ArrayList<Film> testList;

    @Param({"1000", "10000", "100000","500000","1000000"})
    private int size;

    @Setup(Level.Trial)
    public void prepare() {
        testList = new DataService().readFromCSV(new ArrayList<>());

    }
}