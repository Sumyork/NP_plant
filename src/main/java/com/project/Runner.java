package com.project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(String.class);

        NuclearStation nuclearStation = context.getBean("nuclearStationBean", NuclearStation.class);
        nuclearStation.start(3);

        context.close();

    }
}
