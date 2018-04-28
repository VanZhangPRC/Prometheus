package kraken.basic.web.controller;

import kraken.basic.jpa.service.SystemVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/system")
public class SystemController {

    @Autowired
    private SystemVersionService versionService;

    @RequestMapping(path = "/version", method = RequestMethod.GET)
    public Object version() {
        return versionService.listVersion();
    }
}
