package com.cts.homeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.homeservice.model.AddService;
import com.cts.homeservice.model.BookService;

public interface BookServiceRepository extends JpaRepository<BookService, Integer> {

	

}
