package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;
import ru.netology.manager.FlightManager;

import static org.junit.jupiter.api.Assertions.*;

class FlightRepositoryTest {
    private FlightRepository repository = new FlightRepository();
    private Flight first = new Flight(1, 1000, "SVO", "LAX", 780);
    private Flight second = new Flight(2, 500, "SVO", "LAX", 720);
    private Flight third = new Flight(3, 300, "SVO", "IST", 180);
    private Flight forth = new Flight(4, 500, "IST", "LAX", 780);
    private Flight fifth = new Flight(5, 100, "SVO", "IST", 300);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        repository.save(fifth);
    }

    @Test
    void shouldSearchByAirports() {
        String from = "SVO";
        String to = "IST";
        Flight[] expected = new Flight[]{third, fifth};
        Flight[] actual = repository.findByAirports(from, to);
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldRemoveByIdIfExist() {
        int idToRemove = 4;
        repository.removeById(idToRemove);
        Flight[] expected = new Flight[]{first, second, third, fifth};
        Flight[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldRemoveByIdIfNotExist() {
        int idToRemove = 6;
        repository.removeById(idToRemove);
        Flight[] expected = new Flight[]{first, second, third, forth, fifth};
        Flight[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
