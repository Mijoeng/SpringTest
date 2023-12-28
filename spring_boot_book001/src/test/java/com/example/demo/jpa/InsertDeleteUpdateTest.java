package com.example.demo.jpa;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.vo.Book;

@SpringBootTest
public class InsertDeleteUpdateTest {
	@Autowired
	
	jpaBookRepository jpaBook;
	
	@Test
	
	void insertUpdateDelete() {
		Book book01 = new Book();
		book01.setBookid("90");
		book01.setBookname("미정이는최고야");
		book01.setPrice("99000");
		book01.setPublisher("미정사랑");
		
		jpaBook.save(book01);
		
		Optional<Book> selectList = jpaBook.findById("9");
		Book book02=selectList.get();
		book02.setPrice("88000");
		jpaBook.save(book02);
		
		jpaBook.deleteById("4");
	}

}
