package co.udea.ssmu.api.services.drivers.service;

import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.exception.BusinessException;
import co.udea.ssmu.api.model.jpa.model.drivers.Driver;
import co.udea.ssmu.api.model.jpa.repository.drivers.DriverRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverService {

    private final DriverRepository driverRepository;
    private final Messages messages;

    public DriverService(DriverRepository driverRepository, Messages messages) {
        this.driverRepository = driverRepository;
        this.messages = messages;
    }

    public Driver save(Driver driver) {
        Optional<Driver> driverOptional = driverRepository.findByDocumentAndDocumentType(driver.getDocument(), driver.getDocumentType());
        if (driverOptional.isPresent()) {
            throw new BusinessException(String.format(messages.get("driver.save.duplicate.document"), driver.getDocumentType(), driver.getDocument()));
        }
        return driverRepository.save(driver);
    }

    public List<Driver> findByAll() {
        return driverRepository.findAll();
    }

    public Page<Driver> getWithPage(Pageable pageable) {
        return driverRepository.findAll(pageable);
    }

    public Driver update(Driver driver) {
        Optional<Driver> driverOptional = driverRepository.findById(driver.getId());
        if (driverOptional.isEmpty()) {
            throw new BusinessException(String.format(messages.get("driver.update.does.not.exist")));
        }
        return driverRepository.save(driver);
    }

    public void delete(Integer id) {
        driverRepository.findById(id).orElseThrow(() ->
                new BusinessException(String.format(messages.get("driver.delete.find.error"), id)));
        this.driverRepository.deleteById(id);
    }
}
