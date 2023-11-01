package co.udea.ssmu.api.model.jpa.dto.drivers;

import co.udea.ssmu.api.model.jpa.dto.vehicles.VehicleDTO;
import co.udea.ssmu.api.utils.common.StateDriverEnum;

import java.time.LocalDateTime;

public class DriverDTO {

    private Integer id;
    private String names;
    private String surnames;
    private String email;
    private String age;
    private Integer documentType;
    private String document;
    private LocalDateTime admissionDate;
    private StateDriverEnum state;
    private VehicleDTO vehicle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Integer documentType) {
        this.documentType = documentType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDateTime getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDateTime admissionDate) {
        this.admissionDate = admissionDate;
    }

    public StateDriverEnum getState() {
        return state;
    }

    public void setState(StateDriverEnum state) {
        this.state = state;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }
}
