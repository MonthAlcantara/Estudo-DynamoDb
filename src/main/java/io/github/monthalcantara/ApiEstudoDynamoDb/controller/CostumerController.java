package io.github.monthalcantara.ApiEstudoDynamoDb.controller;

import io.github.monthalcantara.ApiEstudoDynamoDb.dto.CostumerDTO;
import io.github.monthalcantara.ApiEstudoDynamoDb.model.Costumer;
import io.github.monthalcantara.ApiEstudoDynamoDb.service.CostumerService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1")
public class CostumerController {

    private final CostumerService costumerService;

    @PostMapping("costumer")
    public ResponseEntity<Costumer> newCostumer(@Valid @RequestBody CostumerDTO costumerDTO) {
        return new ResponseEntity(costumerService.saveCostumer(costumerDTO), HttpStatus.OK);
    }

    @GetMapping("costumer")
    public ResponseEntity<List<Costumer>> findCostumerByName(@Param("companyName") String companyName) {
        return ResponseEntity.ok(costumerService.findByCompanyName(companyName));
    }

    @GetMapping("costumer/all")
    public ResponseEntity<List<Costumer>> allCostumers() {
        return ResponseEntity.ok(costumerService.findAllCostumers());
    }
//
//    @PutMapping("costumer")
//    public ResponseEntity<Costumer> updateCostumer(@Valid @RequestBody CostumerDTO costumerDTO) {
//        Costumer costumer = costumerDTO.costumerDTOToCostumer();
//        return ResponseEntity.ok(costumerService.updateCostumer(costumerDTO));
//    }

    @DeleteMapping("costumer/{companyName}")
    public ResponseEntity<Costumer> disableCostumer(@PathVariable("companyName") String companyName) {
        return ResponseEntity.ok(costumerService.disableCostumer(companyName));
    }
}
