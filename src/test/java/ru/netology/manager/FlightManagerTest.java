package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;
import ru.netology.domain.FlightComparator;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {
    private FlightManager manager = new FlightManager();
    FlightComparator duration = new FlightComparator();
    private Flight first = new Flight(1, 1000, "SVO", "LAX", 780);
    private Flight second = new Flight(2, 500, "SVO", "LAX", 720);
    private Flight third = new Flight(3, 300, "SVO", "IST", 180);
    private Flight forth = new Flight(4, 500, "IST", "LAX", 780);
    private Flight fifth = new Flight(5, 1000, "SVO", "LAX", 700);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
    }


    @Test
    void shouldSearchByAirportsAndSortByDuration() {
        String from = "SVO";
        String to = "LAX";
        Flight[] expected = new Flight[]{fifth, second, first};
        Flight[] actual = manager.findByDuration(from, to, duration);
        assertArrayEquals(expected, actual);
    }

}