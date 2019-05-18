package pl.bartek.thesis.master.service.test;

import pl.bartek.thesis.master.domain.test.result.TestResult;
import pl.bartek.thesis.master.domain.test.specification.TestSpecification;

public interface TestService {
    TestResult testLoadBalancer(final TestSpecification testSpecification);
}
