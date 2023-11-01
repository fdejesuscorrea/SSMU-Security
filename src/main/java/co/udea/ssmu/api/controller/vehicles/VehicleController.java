package co.udea.ssmu.api.controller.vehicles;

import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.common.StandardResponse;
import co.udea.ssmu.api.model.jpa.dto.vehicles.VehicleDTO;
import co.udea.ssmu.api.utils.exception.DataBaseException;
import co.udea.ssmu.api.services.vehicles.facade.VehicleFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Vehicles", description = "Gestión de vehículos")
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleFacade vehicleFacade;
    private final Messages messages;

    public VehicleController(VehicleFacade vehicleFacade, Messages messages) {
        this.vehicleFacade = vehicleFacade;
        this.messages = messages;
    }

    @PostMapping("/save")
    @Operation(summary = "Permite guardar un vehículo")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = VehicleDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "El vehículo fue guardado exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<VehicleDTO>> save(@Valid @RequestBody VehicleDTO Vehicle) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("vehicle.save.successful"),
                vehicleFacade.save(Vehicle)));
    }

    @GetMapping("/get-all")
    @Operation(summary = "Permite consultar todos los vehículos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = List.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "Los vehículos fueron consultados exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<List<VehicleDTO>>> findAll() {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("vehicle.get.all.successful"),
                vehicleFacade.findByAll()));
    }

    @GetMapping("/get-all/filter")
    @Operation(summary = "Consultar los vehículos paginado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Los vehículos fueron consultados exitosamente",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Page.class)))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")
    })
    public ResponseEntity<StandardResponse<Page<VehicleDTO>>> getWithPage(
            @Parameter(description = "Página para la cual se desean recibir los resultados (0..N)")
            @RequestParam(defaultValue = "0") Integer page,
            @Parameter(description = "Número de registros por página.")
            @RequestParam(defaultValue = "10") Integer size,
            @Parameter(description = "Criterio de ordenamiento en el formato: campo(,asc|desc). "
                    + "por defecto el ordenamiento es asc. "
                    + "Se permite múltiple criterio de ordenamiento.")
            @RequestParam(defaultValue = "id,asc") String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.asc(sort.split(",")[0])));

        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("vehicle.get.all.filter.successful"),
                vehicleFacade.getWithPage(pageable)));
    }

    @PutMapping("/update")
    @Operation(summary = "Permite actualizar un vehículo")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = VehicleDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "El país fue habilitado exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<VehicleDTO>> update(@Valid @RequestBody VehicleDTO Vehicle) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("vehicle.update.successful"),
                vehicleFacade.update(Vehicle)));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Permite eliminar un vehículo")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "El vehículo fue eliminada exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Void>> delete(@PathVariable Integer id) {
        try {
            vehicleFacade.delete(id);
            return ResponseEntity.ok(new StandardResponse<>(messages.get("vehicle.delete.successful"), StandardResponse.StatusStandardResponse.OK));
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(messages.get("vehicle.delete.error"));
        }
    }

}
