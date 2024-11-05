package tn.esprit.devops_project.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.StockDTO;
import tn.esprit.devops_project.services.Iservices.IStockService;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor

public class StockController {

    private final IStockService stockService;

    @PostMapping("/stock")
    StockDTO addStock(@RequestBody StockDTO stock){
        return stockService.addStock(stock);
    }

    @GetMapping("/stock/{id}")
    StockDTO retrieveStock(@PathVariable Long id){
        return stockService.retrieveStock(id);
    }

    @GetMapping("/stock")
    List<StockDTO> retrieveAllStock(){
        return stockService.retrieveAllStock();
    }


}
