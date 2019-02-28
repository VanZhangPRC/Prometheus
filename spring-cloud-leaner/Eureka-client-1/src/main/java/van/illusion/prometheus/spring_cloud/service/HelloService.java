package van.illusion.prometheus.spring_cloud.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public Object hello() {
        return "Hello - HelloService";
    }
}
