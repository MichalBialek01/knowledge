package org.example;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Comparator;
import java.util.Optional;

@State(Scope.Benchmark)
class Film {
    private int id;
    private String title;
    private Optional<Integer> rating;

    public Film(int id, String title, Optional<Integer> rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;
    }
    public static final Comparator<Film> BY_RATING = Comparator.comparing(
            film -> film.rating.orElse(null),
            Comparator.nullsLast(Comparator.naturalOrder())
    );


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Optional<Integer> getRating() {
        return rating;
    }
}