package tn.esprit.rh.achat.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.StockServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class StockMockitoTest {

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
        // Store the stock ID in a variable
        Long stockId = stock.getIdStock(); // Ensure stockId is not null if that is part of the test case

// Use assertThrows to check for NullPointerException when retrieving stock
        NullPointerException exception = assertThrows(NullPointerException.class, () -> stockService.retrieveStock(stockId));

// Optionally, you can add additional assertions on the exception if needed
        assertNotNull(exception);


        assertEquals("Stock not found", exception.getMessage());
    }

    @Test
    void retrieveAllStock_ShouldReturnListOfStocks() {
        // Arrange
        when(stockRepository.findAll()).thenReturn(List.of(stock));

        // Act
        List<Stock> result = stockService.retrieveAllStock();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(stock.getTitle(), result.get(0).getTitle());
    }
}