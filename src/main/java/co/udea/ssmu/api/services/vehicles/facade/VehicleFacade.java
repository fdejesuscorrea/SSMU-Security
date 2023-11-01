package co.udea.ssmu.api.services.vehicles.facade;

import co.udea.ssmu.api.model.jpa.dto.vehicles.VehicleDTO;
import co.udea.ssmu.api.model.jpa.mapper.vehicles.VehicleMapper;
import co.udea.ssmu.api.model.jpa.model.vehicles.Vehicle;
import co.udea.ssmu.api.services.vehicles.service.VehicleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleFacade {

    private final VehicleService vehicleService;
    private final VehicleMapper vehicleMapper;

    public VehicleFacade(VehicleService vehicleService,
                         VehicleMapper vehicleMapper) {
        this.vehicleService = vehicleService;
        this.vehicleMapper = vehicleMapper;
    }

    public VehicleDTO save(VehicleDTO vehicle) {
        return vehicleMapper.toDto(vehicleService.save(vehicleMapper.toEntity(vehicle)));
    }

    public List<VehicleDTO> findByAll() {
        List<Vehicle> vehicles = vehicleService.findByAll();
        return vehicleMapper.toDto(vehicles);
    }

    public Page<VehicleDTO> getWithPage(Pageable pageable) {
        return vehicleService.getWithPage(pageable).map(vehicleMapper::toDto);
    }

    public VehicleDTO update(VehicleDTO vehicle) {
        return vehicleMapper.toDto(vehicleService.save(vehicleMapper.toEntity(vehicle)));
    }

    public void delete(Integer id) {
        vehicleService.delete(id);
    }

}
