package pl.bartek.thesis.worker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.bartek.thesis.worker.configuration.CurrentWorkerConfiguration;
import pl.bartek.thesis.worker.dto.configuration.WorkerConfigurationDto;

import javax.validation.Valid;

@RestController("/configuration")
public class ConfigurationController {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationController.class);

    private final CurrentWorkerConfiguration currentConfiguration;

    @Autowired
    public ConfigurationController(final CurrentWorkerConfiguration currentConfiguration) {
        this.currentConfiguration = currentConfiguration;
    }

    @PostMapping
    public ResponseEntity<String> setConfiguration(@Valid @RequestBody final WorkerConfigurationDto configurationDto) {
        LOG.info("RECEIVED configuration: " + configurationDto);
        currentConfiguration.changeConfiguration(configurationDto);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<WorkerConfigurationDto> getConfiguration() {
        final WorkerConfigurationDto currentConfigurationDto = currentConfiguration.gatCurrentConfigurationDto();
        LOG.info("SENDING configuration: " + currentConfigurationDto);

        return new ResponseEntity<>(currentConfigurationDto, HttpStatus.ACCEPTED);
    }
}
