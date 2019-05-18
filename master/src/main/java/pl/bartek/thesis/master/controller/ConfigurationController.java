package pl.bartek.thesis.master.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.bartek.thesis.master.domain.test.specification.TestSpecification;
import pl.bartek.thesis.master.domain.worker.configuraton.WorkerConfiguration;
import pl.bartek.thesis.master.service.configuration.ConfigurationService;
import pl.bartek.thesis.master.service.test.TestService;

import static pl.bartek.thesis.master.cache.configuration.WorkerConfigurationCache.CACHE;

@Controller
public class ConfigurationController {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationController.class);

    private final ConfigurationService configurationService;
    private final TestService testService;

    @Autowired
    public ConfigurationController(final ConfigurationService configurationService, final TestService testService) {
        this.configurationService = configurationService;
        this.testService = testService;
    }

    @GetMapping("/")
    public String getConfigurePage(final Model model) {
        model.addAttribute("worker1", CACHE.get("127.0.0.1"));
        model.addAttribute("worker2", CACHE.get("255.127.0.1"));
        model.addAttribute("testSpecification", new TestSpecification());
        return "configurePage";
    }

    @PostMapping("/send")
    public String sendConfiguration(@ModelAttribute("worker") final WorkerConfiguration configuration,
                                    final RedirectAttributes redirectAttributes) {
        CACHE.put(configuration.getIp(), configuration);
        LOG.info("SENDING CONFIGURATION " + configuration);

        configurationService.sendConfiguration(configuration);
        redirectAttributes.addFlashAttribute("message",
                String.format("Configuration sent succesfully to worker service with IP: %s!", configuration.getIp()));
        return "redirect:/";
    }

    @PostMapping("/test")
    public String testLoadBalancer(@ModelAttribute("testSpecification") final TestSpecification testSpecification,
                                   final RedirectAttributes redirectAttributes) {
        LOG.info("RUN TEST " + testSpecification);

        testService.testLoadBalancer(testSpecification);
        redirectAttributes.addFlashAttribute("message", "Test ran succesfully!");
        return "redirect:/";
    }
}
