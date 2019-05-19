package pl.bartek.thesis.master.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("lb-worker-service")
public interface WorkerClient {

    @GetMapping("/work")
    void doWork();
}
