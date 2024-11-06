package tn.esprit.devops_project.services.Iservices;

import tn.esprit.devops_project.entities.StockDTO;

import java.util.List;

public interface IStockService {

    StockDTO addStock(StockDTO stock);
    StockDTO retrieveStock(Long id);
    List<StockDTO> retrieveAllStock();

}
