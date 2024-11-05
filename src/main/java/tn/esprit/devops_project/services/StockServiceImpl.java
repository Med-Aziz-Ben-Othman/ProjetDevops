package tn.esprit.devops_project.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.devops_project.services.Iservices.IStockService;
import tn.esprit.devops_project.entities.StockDTO;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StockServiceImpl implements IStockService {

   private final StockRepository stockRepository;

    @Override
    public StockDTO addStock(StockDTO stock) {
        return stockRepository.save(stock);
    }

    @Override
    public StockDTO retrieveStock(Long id) {
        return stockRepository.findById(id).orElseThrow(() -> new NullPointerException("Stock not found"));
    }

    @Override
    public List<StockDTO> retrieveAllStock() {
        return stockRepository.findAll();
    }



}
