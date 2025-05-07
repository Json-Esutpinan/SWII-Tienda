package co.edu.poli.Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void suscribir(Observer observer) {
        observers.add(observer);
    }

    public void desuscribir(Observer observer) {
        observers.remove(observer);
    }

    public void notificarDto(double porcentaje) {
        for (Observer observer : observers) {
            observer.actualizarPrecio(porcentaje);
        }
    }
    public List<Observer> getObservers() {
        return Collections.unmodifiableList(observers);
    }
}
