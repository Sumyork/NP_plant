package com.project;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// Отдел безопасности.

@Component("securityDepartmentBean")
public class SecurityDepartment {

    // Количество инцидентов за период.
    private int accidentCountPeriod = 0;

    private NuclearStation nuclearStation;

    @Lazy
    public SecurityDepartment(NuclearStation nuclearStation) {
        this.nuclearStation = nuclearStation;
    }

    public void addAccident() {
        accidentCountPeriod += 1;
    }

    public int getCountAccidents() {
        return accidentCountPeriod;
    }

    // Сброс счетчика инцидентов.
    public void reset() {
//        accidentCountPeriod += nuclearStation.getAccidentCountAllTime();
        accidentCountPeriod = 0;
    }
}
