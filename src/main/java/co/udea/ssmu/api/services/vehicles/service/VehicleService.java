package co.udea.ssmu.api.services.vehicles.service;

import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.exception.BusinessException;
import co.udea.ssmu.api.model.jpa.model.vehicles.Vehicle;
import co.udea.ssmu.api.model.jpa.repository.vehicles.VehicleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final Messages messages;

    public VehicleService(VehicleRepository vehicleRepository, Messages messages) {
        this.vehicleRepository = vehicleRepository;
        this.messages = messages;
    }

    public Vehicle save(Vehicle vehicle) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findByName(vehicle.getName());
        if (vehicleOptional.isPresent()) {
            throw new BusinessException(String.format(messages.get("vehicle.save.duplicate.name"), vehicle.getName()));
        }
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> findByAll() {
        return vehicleRepository.findAll();
    }

    public Page<Vehicle> getWithPage(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }

    public Vehicle update(Vehicle vehicle) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicle.getId());
        if (vehicleOptional.isEmpty()) {
            throw new BusinessException(String.format(messages.get("vehicle.update.does.not.exist")));
        }
        return vehicleRepository.save(vehicle);
    }

    public void delete(Integer id) {
        vehicleRepository.findById(id).orElseThrow(() ->
                new BusinessException(String.format(messages.get("vehicle.delete.find.error"), id)));
        this.vehicleRepository.deleteById(id);
    }

}
