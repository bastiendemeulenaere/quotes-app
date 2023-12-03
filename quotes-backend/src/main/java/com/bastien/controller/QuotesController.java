package com.bastien.controller;

import com.bastien.domain.Quote;
import com.bastien.services.QuotesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/quotes")
public class QuotesController {

    private QuotesService service;

    @PostMapping
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote) {
        Quote savedQuote = service.createQuote(quote);
        return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Quote>> getAllQuotes() {
        List<Quote> quotes = service.getAllQuotes();
        return ResponseEntity.ok(quotes);
    }

    @GetMapping("{id}/description")
    public ResponseEntity<String> getQuoteDescriptionById(@PathVariable("id") int id) {
        String description = service.getQuoteDescriptionById(id);
        return ResponseEntity.ok(description);
    }

    @GetMapping("{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable("id") int quoteId) {
        Quote foundQuote = service.getQuoteById(quoteId);
        return ResponseEntity.ok(foundQuote);
    }

    @PutMapping("{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable("id") int id, @RequestBody Quote updatedQuote) {
        Quote quote = service.updateQuote(id, updatedQuote);
        return ResponseEntity.ok(quote);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteQuote(@PathVariable("id") int id) {
        service.deleteQuote(id);
        return ResponseEntity.ok("Employee with id: " + id + " deleted successfully");
    }

}
