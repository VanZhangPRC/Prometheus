package kraken.pandora.service;

import kraken.pandora.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void deleteByName(String name) {
        userRepository.deleteByName(name);
    }

    @Transactional
    public void deleteByOrgId(Integer orgId) {
        userRepository.deleteByOrgId(orgId);
    }

    @Transactional
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

}
