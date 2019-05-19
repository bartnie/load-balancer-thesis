package pl.bartek.thesis.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MasterApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MasterApplication.class, args);
    }

}
