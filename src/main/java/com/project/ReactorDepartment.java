package com.project;

import com.project.exception.ReactorWorkException;
import org.springframework.stereotype.Component;

@Component("reactorDepartmentBean")
public class ReactorDepartment {
    private final static int ELECTRICITY = 10_000_000;
    private int countRun = 0;
    boolean reactorWork = false;

    public int run() {

        reactorWork = false;

        if (reactorWork == true) {
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

        reactorWork = true;

        if (reactorWork == false) {
            try {
                throw new ReactorWorkException();
            } catch (ReactorWorkException e) {
                System.out.println("Реактор уже выключен!");;
            }
        }
        reactorWork = false;
    }
}
