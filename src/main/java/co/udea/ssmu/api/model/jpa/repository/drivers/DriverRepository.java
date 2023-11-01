package co.udea.ssmu.api.model.jpa.repository.drivers;

import co.udea.ssmu.api.model.jpa.model.drivers.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    @Query("SELECT d FROM Driver d WHERE UPPER(d.document) = UPPER(:document)" +
            " AND UPPER(d.documentType) = UPPER(:documentType)")
    Optional<Driver> findByDocumentAndDocumentType(@Param("document") String name,
                                                   @Param("documentType") String documentType);

}
