package ru.netology.domain;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {
    private Flight first = new Flight(1, 1000, "SVO", "LAX", 780);
    private Flight second = new Flight(2, 500, "SVO", "LAX", 720);
    private Flight third = new Flight(3, 300, "SVO", "IST", 180);
    private Flight forth = new Flight(4, 500, "IST", "LAX", 780);
    private Flight fifth = new Flight(5, 100, "SVO", "IST", 300);

    @Test
    public void shouldSortByPrice() {
        Flight[] expected = new Flight[]{fifth, third, second, forth, first};
        Flight[] actual = new Flight[]{first, second, third, forth, fifth};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
        }
}

