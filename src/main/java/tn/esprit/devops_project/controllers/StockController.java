package tn.esprit.devops_project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.StockDTO;
import tn.esprit.devops_project.services.Iservices.IStockService;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/stocks")  // Ajout d'un chemin de base pour améliorer l'organisation des routes

public class StockController {

    private final IStockService stockService;

    // Ajout de validation des données d'entrée
    @PostMapping
    public ResponseEntity<StockDTO> addStock(@Valid @RequestBody StockDTO stock) {
        StockDTO createdStock = stockService.addStock(stock);
        return new ResponseEntity<>(createdStock, HttpStatus.CREATED);  // Retour avec le code 201 pour "créé"
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> retrieveStock(@PathVariable Long id) {
        Optional<StockDTO> stock = Optional.ofNullable(stockService.retrieveStock(id));

        return stock
                .map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));  // Retour 404 si pas trouvé
    }

    @GetMapping
    public ResponseEntity<List<StockDTO>> retrieveAllStock() {
        List<StockDTO> stocks = stockService.retrieveAllStock();
        if (stocks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Retour 204 si la liste est vide
        }
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }
}
