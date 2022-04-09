package miu.edu.demo.repo;

import miu.edu.demo.domain.Logger;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepo extends CrudRepository<Logger, Long> {
}
