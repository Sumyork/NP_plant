package com.project;

import com.project.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        NuclearStation nuclearStation = context.getBean("nuclearStationBean", NuclearStation.class);
        nuclearStation.start(3);

        context.close();
    }
}
