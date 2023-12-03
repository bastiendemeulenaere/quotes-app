package com.bastien.services;

import com.bastien.data.QuotesRepo;
import com.bastien.domain.Quote;
import com.bastien.util.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuotesService {
    private QuotesRepo repo;

    public List<Quote> getAllQuotes() {
        return repo.findAll();
    }

    public Quote createQuote(Quote quote) {
        return repo.save(quote);
    }

    public Quote getQuoteById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quote does not exist with id: " + id));
    }

    public Quote updateQuote(int id, Quote updatedQuote) {
        Quote existingQuote = getQuoteById(id);
            return repo.save(existingQuote);
    }

    public void deleteQuote(int id) {
        getQuoteById(id);
        repo.deleteById(id);
    }

    public String getQuoteDescriptionById(int id) {
        return getQuoteById(id).getDescription();
    }
}
