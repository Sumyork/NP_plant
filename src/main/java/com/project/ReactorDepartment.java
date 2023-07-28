package com.project;

import com.project.exception.NuclearFuelIsEmptyException;
import com.project.exception.ReactorWorkException;
import org.springframework.stereotype.Component;

@Component("reactorDepartmentBean")
public class ReactorDepartment {
    private final static int ELECTRICITY = 10_000_000;
    private int countRun = 0;
    boolean reactorWork = false;

    // Реактор запускается на 1 день и производит 10 миллионов киловатт/часов.
    public int run() {
        countRun++;

        if (countRun == 100) {
            countRun = 0;
            try {
                throw new NuclearFuelIsEmptyException();
            } catch (NuclearFuelIsEmptyException e) {
                throw new RuntimeException(e);
            }
        } else if (!reactorWork) {
            try {
                throw new ReactorWorkException();
            } catch (ReactorWorkException e) {
                System.out.println("Реактор уже работает");
            }
        }

        reactorWork = true;

        return ELECTRICITY;
    }

    public void stop() {

        if (reactorWork) {
            try {
                throw new ReactorWorkException();
            } catch (ReactorWorkException e) {
                System.out.println("Реактор уже выключен!");;
            }
        }
        reactorWork = false;
    }
}
