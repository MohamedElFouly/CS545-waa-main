package miu.edu.demo.service.Impl;

import miu.edu.demo.domain.Logger;
import miu.edu.demo.repo.LoggerRepo;
import miu.edu.demo.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService {

    @Autowired
    LoggerRepo loggerRepo;

    @Override
    public void save(Logger logger) {
        loggerRepo.save(logger);
    }
}
