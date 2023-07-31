package com.project;

import com.project.exception.NuclearFuelIsEmptyException;
import com.project.exception.ReactorWorkException;
import org.springframework.stereotype.Component;

@Component("nuclearStationBean")
public class NuclearStation {
    ReactorDepartment reactorDepartment;

    long sumEnergy = 0;

    public NuclearStation(ReactorDepartment reactorDepartment) {
        this.reactorDepartment = reactorDepartment;
    }

    // Запускает годовой цикл производства электричества.
    public void startYear() {
        System.out.println("Атомная станция начала работу.");

        for (int i = 1; i <= 365; i++) {
            try {
                int electricEnergy = reactorDepartment.run();
                sumEnergy += electricEnergy;
                reactorDepartment.stop();
            } catch (NuclearFuelIsEmptyException | ReactorWorkException e) {
                System.out.println("Внимание! Происходят работы на атомной станции! Электричества нет!");;
            }
        }

        System.out.println("Атомная станция закончила работу. За год выработано " + sumEnergy + " киловатт/часов.");
    }

    public void start(int year) {
        for (int i = 0; i < year; i++) {
            startYear();
        }
    }
}
