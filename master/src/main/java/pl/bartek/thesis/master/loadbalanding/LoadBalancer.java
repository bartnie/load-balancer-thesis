package pl.bartek.thesis.master.loadbalanding;

import java.net.URI;

public interface LoadBalancer {
    URI getInstanceURI();
}
