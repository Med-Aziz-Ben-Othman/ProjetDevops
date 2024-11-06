package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class StockTest {

    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    private Stock stock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        stock = new Stock();
        stock.setIdStock(1);
        stock.setTitle("Test Stock");
    }

    @Test
    void addStock_ShouldReturnStock_WhenStockIsValid() {
        // Arrange
        when(stockRepository.save(any(Stock.class))).thenReturn(stock);

        // Act
        Stock result = stockService.addStock(stock);

        // Assert
        assertNotNull(result);
        assertEquals(stock.getIdStock(), result.getIdStock());
        assertEquals(stock.getTitle(), result.getTitle());
        verify(stockRepository, times(1)).save(stock);
    }

    
    @Test
    void retrieveStock_ShouldReturnStock_WhenStockExists() {
        // Arrange
        when(stockRepository.findById(stock.getIdStock())).thenReturn(Optional.of(stock));

        // Act
        Stock result = stockService.retrieveStock(stock.getIdStock());

        // Assert
        assertNotNull(result);
        assertEquals(stock.getIdStock(), result.getIdStock());
        assertEquals(stock.getTitle(), result.getTitle());
    }

    @Test
    void retrieveStock_ShouldThrowException_WhenStockDoesNotExist() {
        // Arrange
        when(stockRepository.findById(stock.getIdStock())).thenReturn(Optional.empty());

        // Act & Assert
// Retrieve the stock ID once and store it in a variable
        Long stockId = stock.getIdStock(); // Ensure this does not return null if that is part of the concern

// Use assertThrows to check for NullPointerException when retrieving stock
        NullPointerException exception = assertThrows(NullPointerException.class, () -> stockService.retrieveStock(stockId));

// Optionally, you can add additional assertions on the exception if needed
        assertNotNull(exception);
        assertEquals("Stock not found", exception.getMessage());
    }

    @Test
    void retrieveStock_ShouldThrowException_WhenIdIsInvalid() {
        // Act & Assert
        Exception exception = assertThrows(NullPointerException.class, () -> stockService.retrieveStock(null));
        assertEquals("Stock not found", exception.getMessage());
    }

    @Test
    void retrieveAllStock_ShouldReturnListOfStocks() {
        // Arrange
        List<Stock> stockList = new ArrayList<>();
        stockList.add(stock);
        when(stockRepository.findAll()).thenReturn(stockList);

        // Act
        List<Stock> result = stockService.retrieveAllStock();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(stock.getTitle(), result.get(0).getTitle());
    }

    @Test
    void retrieveAllStock_ShouldReturnEmptyList_WhenNoStocksExist() {
        // Arrange
        when(stockRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<Stock> result = stockService.retrieveAllStock();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void retrieveAllStock_ShouldReturnMultipleStocks_WhenStocksExist() {
        // Arrange
        Stock stock2 = new Stock();
        stock2.setIdStock(2);
        stock2.setTitle("Test Stock 2");
        List<Stock> stockList = new ArrayList<>();
        stockList.add(stock);
        stockList.add(stock2);
        when(stockRepository.findAll()).thenReturn(stockList);

        // Act
        List<Stock> result = stockService.retrieveAllStock();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(stock.getTitle(), result.get(0).getTitle());
        assertEquals(stock2.getTitle(), result.get(1).getTitle());
    }
}
