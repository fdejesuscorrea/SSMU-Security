package co.udea.ssmu.api.model.jpa.mapper.trip;

import co.udea.ssmu.api.model.jpa.dto.trip.TripDTO;
import co.udea.ssmu.api.model.jpa.model.trip.Trip;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TripMapper extends EntityMapper<TripDTO, Trip> {
}
