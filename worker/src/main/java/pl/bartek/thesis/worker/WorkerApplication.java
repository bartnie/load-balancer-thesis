package pl.bartek.thesis.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WorkerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(WorkerApplication.class, args);
    }

}
