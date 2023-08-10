package com.project;

import com.project.exception.NuclearFuelIsEmptyException;
import com.project.exception.ReactorWorkException;
import org.springframework.stereotype.Component;

@Component("reactorDepartmentBean")
public class ReactorDepartment {
    private final static int ELECTRICITY = 10_000_000;
    private int countRun = 0;
    private boolean reactorWork = false;

    private SecurityDepartment securityDepartment;

    public ReactorDepartment(SecurityDepartment securityDepartment) {
        this.securityDepartment = securityDepartment;
    }

    // Реактор запускается на 1 день и производит 10 миллионов киловатт/часов.
    public int run() throws NuclearFuelIsEmptyException, ReactorWorkException {
        countRun++;

//        System.out.println("Запуск: " + countRun);

        if (countRun == 100) {
            countRun = 0;
            securityDepartment.addAccident();
            throw new NuclearFuelIsEmptyException();
        } else if (reactorWork == true) {
            securityDepartment.addAccident();
            throw new ReactorWorkException("Реактор уже работает!");
        } else {
            reactorWork = true;
        }
//        System.out.println("Включили реактор");
        return ELECTRICITY;
    }

    public void stop() throws ReactorWorkException {

        if (reactorWork == false) {
            throw new ReactorWorkException("Реактор выключен!");
        } else {
            reactorWork = false;
        }

//        System.out.println("Остановили реактор.");
    }

    public int getCountRun() {
        return countRun;
    }

    public void setCountRun(int countRun) {
        this.countRun = countRun;
    }
}
