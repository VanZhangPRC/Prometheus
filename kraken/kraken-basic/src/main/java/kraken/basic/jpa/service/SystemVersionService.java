package kraken.basic.jpa.service;

import kraken.basic.jpa.orm.SystemVersion;
import kraken.basic.jpa.repository.SystemVersionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemVersionService {

    @Autowired
    private SystemVersionRepo versionRepo;

    public List<SystemVersion> listVersion() {
        return versionRepo.findAll();
    }
}
