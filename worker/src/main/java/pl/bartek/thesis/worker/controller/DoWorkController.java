package pl.bartek.thesis.worker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bartek.thesis.worker.service.work.WorkService;

@RestController
public class DoWorkController {
    private static final Logger LOG = LoggerFactory.getLogger(DoWorkController.class);

    private final WorkService workService;

    @Autowired
    public DoWorkController(final WorkService workService) {
        this.workService = workService;
    }

    @GetMapping("/work")
    public ResponseEntity<String> doWork(){
        LOG.info("RECEIVED work request");
        workService.doWork();

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
