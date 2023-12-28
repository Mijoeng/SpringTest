package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.jpa.jpaBookRepository;
import com.example.demo.vo.Book;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BookController {

	@Autowired
	
	jpaBookRepository jpaBook;
	@RequestMapping(value="/selectBook")
	public ModelAndView viewBook1(HttpServletRequest request) {
		String bookid=request.getParameter("bookid");
		
		Book b = jpaBook.getById(bookid);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", b);
		mav.setViewName("selectBookOne");
		
		return mav;
	}
	
	@RequestMapping(value="/insertBookForm")
	public ModelAndView insertBook1() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("insertBook");
		
		return mav;
	}
	@RequestMapping(value="/insertBookControl")
	public ModelAndView insertBook2(HttpServletRequest request) {
		
		String num=request.getParameter("bookid");
		String name=request.getParameter("bookname");
		String pub=request.getParameter("publisher");
		String pri=request.getParameter("price");
		
		Book book = new Book();
		book.setBookid(num);
		book.setBookname(name);
		book.setPublisher(pub);
		book.setPrice(pri);
		
		jpaBook.save(book);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "도서 정보가 추가 되었습니다");
		mav.setViewName("insertBookResult");
		
		return mav;
		
	}
}
