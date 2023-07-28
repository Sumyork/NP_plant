package com.project;

import com.project.exception.NuclearFuelIsEmptyException;
import org.springframework.stereotype.Component;

@Component("nuclearStationBean")
public class NuclearStation {
    ReactorDepartment reactorDepartment = new ReactorDepartment();

    long sumEnergy = 0;

    public NuclearStation(ReactorDepartment reactorDepartment) {
        this.reactorDepartment = reactorDepartment;
    }

    // Запускает годовой цикл производства электричества.
    public void startYear() {
        System.out.println("Атомная станция начала работу.");

        for (int i = 1; i <= 365; i++) {

            if (i % 100 != 0) {
                int electricEnergy = reactorDepartment.run();

                sumEnergy += electricEnergy;

            } else {
                reactorDepartment.stop();
                try {
                    throw new NuclearFuelIsEmptyException();
                } catch (NuclearFuelIsEmptyException e) {
                    System.out.println("Внимание! Происходят работы на атомной станции! Электричества нет!");
                }

            }
        }

        reactorDepartment.stop();

        System.out.println("Атомная станция закончила работу. За год выработано " + sumEnergy + " киловатт/часов.");
    }

    public void start(int year) {
        for (int i = 0; i < year; i++) {
            startYear();
        }
    }
}
