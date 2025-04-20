package com.example.dev2secops2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ServiceWeb {

    private List<Car> cars = new ArrayList<>();

    public ServiceWeb() {
        cars.add(new Car("AA11BB", "ferrari", 2000));
        cars.add(new Car("BB22CC", "porsche", 1000));
        cars.add(new Car("CC33DD", "peugeot", 500));
    }

    // Endpoint pour obtenir toutes les voitures
    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return cars;
    }

    // Endpoint pour obtenir une voiture par numéro de plaque
    @GetMapping("/cars/{plateNumber}")
    public ResponseEntity<Car> getCarByPlateNumber(@PathVariable("plateNumber") String plateNumber) {
        for (Car car : cars) {
            if (car.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                return ResponseEntity.ok(car);
            }
        }
        // Si aucune voiture n'est trouvée, renvoyer 404
        return ResponseEntity.notFound().build();
    }

    // Endpoint de test pour vérifier que l'API fonctionne
    @GetMapping("/test")
    public String test() {
        return "API is working!";
    }
}