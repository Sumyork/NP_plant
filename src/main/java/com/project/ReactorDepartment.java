package com.project;

import com.project.exception.NuclearFuelIsEmptyException;
import com.project.exception.ReactorWorkException;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

@Component("reactorDepartmentBean")
public class ReactorDepartment {
    private final static int ELECTRICITY = 10_000_000;
    private int countRun = 0;
    private boolean reactorWork = false;

    // Реактор запускается на 1 день и производит 10 миллионов киловатт/часов.
    public int run() throws NuclearFuelIsEmptyException {
        countRun++;

//        System.out.println("Запуск: " + countRun);
        try {
            if (countRun == 100) {
                countRun = 0;

                throw new NuclearFuelIsEmptyException();
            } else if (reactorWork == true) {
                throw new ReactorWorkException("Реактор уже работает!");
            } else {
                reactorWork = true;
            }
        } catch (ReactorWorkException e) {
            e.getMessage();
        }

//        System.out.println("Включили реактор");

        return ELECTRICITY;
    }

    public void stop() {

        if (reactorWork == false) {
            try {
                throw new ReactorWorkException("Реактор выключен!");
            } catch (ReactorWorkException e) {
                e.getMessage();
            }
        }
        reactorWork = false;

//        System.out.println("Остановили реактор.");
    }

    public int getCountRun() {
        return countRun;
    }

    public void setCountRun(int countRun) {
        this.countRun = countRun;
    }
}
