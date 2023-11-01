package co.udea.ssmu.api.model.jpa.dto.vehicles;

import co.udea.ssmu.api.model.jpa.dto.drivers.DriverDTO;
import co.udea.ssmu.api.utils.common.VehicleStatusEnum;

import java.time.LocalDateTime;

public class VehicleDTO {

    private Integer id;
    private String name;
    private String ability;
    private VehicleStatusEnum state;
    private String mechanic;
    private String model;
    private Boolean allowsPets;
    private LocalDateTime admissionDate;
    private Integer driverCode;

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

}
