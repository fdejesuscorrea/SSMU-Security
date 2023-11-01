package co.udea.ssmu.api.model.jpa.model.vehicles;

import co.udea.ssmu.api.model.jpa.model.trip.Trip;
import co.udea.ssmu.api.model.jpa.model.drivers.Driver;
import co.udea.ssmu.api.utils.common.VehicleStatusEnum;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "ability")
    private String ability;

    @NotNull
    @Column(name = "state")
    private VehicleStatusEnum state = VehicleStatusEnum.active;

    @Column(name = "mechanic")
    private String mechanic;

    @NotNull
    @Column(name = "model")
    private String model;

    @NotNull
    @Column(name = "allows_pets")
    private Boolean allowsPets = Boolean.TRUE;

    @Column(name = "admission_date")
    private LocalDateTime admissionDate;

    @Column(name = "fk_driver")
    private Integer driverCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_driver", insertable = false, updatable = false)
    private Driver driver;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<Trip> trips;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public VehicleStatusEnum getState() {
        return state;
    }

    public void setState(VehicleStatusEnum state) {
        this.state = state;
    }

    public String getMechanic() {
        return mechanic;
    }

    public void setMechanic(String mechanic) {
        this.mechanic = mechanic;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getAllowsPets() {
        return allowsPets;
    }

    public void setAllowsPets(Boolean allowsPets) {
        this.allowsPets = allowsPets;
    }

    public LocalDateTime getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDateTime admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Integer getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(Integer driverCode) {
        this.driverCode = driverCode;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
