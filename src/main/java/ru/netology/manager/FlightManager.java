package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

import java.util.Arrays;
import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlightManager {
    private FlightRepository repository = new FlightRepository();

    public void add(Flight item) {
        repository.save(item);
    }

    public Flight[] getAll() {
        return repository.findAll();
    }

    public Flight[] searchBy(String from, String to) {
        Flight[] result = repository.findByAirports(from, to);
        Arrays.sort(result);
        return result;
    }
}

