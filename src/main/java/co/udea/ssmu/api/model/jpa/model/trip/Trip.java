package co.udea.ssmu.api.model.jpa.model.trip;

import co.udea.ssmu.api.model.jpa.model.vehicles.Vehicle;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "origin")
    private Integer origin;

    @NotNull
    @Column(name = "destination")
    private String destination;

    @Column(name = "observation", length = 1000)
    private String observation;

    @NotNull
    @Column(name = "passengers")
    private String passengers;

    @NotNull
    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @NotNull
    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @NotNull
    @Column(name = "fk_vehicle", nullable = false)
    private Integer vehicleCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_vehicle", insertable = false, updatable = false)
    private Vehicle vehicle;

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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
