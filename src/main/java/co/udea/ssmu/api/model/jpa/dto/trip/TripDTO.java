package co.udea.ssmu.api.model.jpa.dto.trip;

import co.udea.ssmu.api.model.jpa.dto.vehicles.VehicleDTO;

import java.time.LocalDateTime;

public class TripDTO {

    private Integer id;
    private Integer origin;
    private String destination;
    private String observation;
    private String passengers;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private Integer vehicleCode;
    private VehicleDTO vehicle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrigin() {
        return origin;
    }

    public void setOrigin(Integer origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Integer getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(Integer vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }
}
