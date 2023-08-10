package com.project;

import com.project.exception.NuclearFuelIsEmptyException;
import com.project.exception.ReactorWorkException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("nuclearStationBean")
public class NuclearStation {
    private ReactorDepartment reactorDepartment;
    private SecurityDepartment securityDepartment;

    // Количество инцидентов за всё время.
    private int accidentCountAllTime = 0;

    long sumEnergy = 0;

    public NuclearStation(ReactorDepartment reactorDepartment, SecurityDepartment securityDepartment) {
        this.reactorDepartment = reactorDepartment;
        this.securityDepartment = securityDepartment;
    }

    public int getAccidentCountAllTime() {
        return accidentCountAllTime;
    }

    public void setAccidentCountAllTime(int accidentCountAllTime) {
        this.accidentCountAllTime = accidentCountAllTime;
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
        System.out.println("Количество инцидентов за год: " + securityDepartment.getCountAccidents());
        System.out.println("Атомная станция закончила работу. За год выработано " + sumEnergy + " киловатт/часов.");
        securityDepartment.reset();
    }

    public void start(int year) {
        for (int i = 0; i < year; i++) {
            startYear();
        }

        System.out.println("Количество инцидентов за всю работу станции: " + accidentCountAllTime);
    }

    public void incrementAccident(int count) {
        accidentCountAllTime += count;
    }
}
