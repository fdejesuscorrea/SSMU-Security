package co.udea.ssmu.api.model.jpa.mapper.vehicles;

import co.udea.ssmu.api.model.jpa.dto.vehicles.VehicleDTO;
import co.udea.ssmu.api.model.jpa.model.vehicles.Vehicle;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.mapper.drivers.DriverMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DriverMapper.class})
public interface VehicleMapper extends EntityMapper<VehicleDTO, Vehicle> {
}
