package com.example.demo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;
import com.example.demo.vo.Book;

@Repository
public interface jpaBookRepository extends JpaRepository<Book, String> {
	public List <Book> findByBookid(String bookid);

	
}
