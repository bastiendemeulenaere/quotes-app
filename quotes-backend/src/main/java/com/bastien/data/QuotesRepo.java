package com.bastien.data;

import com.bastien.domain.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotesRepo extends JpaRepository<Quote, Integer> {
}
