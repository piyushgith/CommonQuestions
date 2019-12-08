package com.java.thread.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import com.java.collection.helper.Book;

public class ConcurrencyExample1 {
	// We can use Runnable with Executors
	public static void main(String[] args) {
		List<Book> list = Arrays.asList(new Book(1, "Ramayan"), new Book(2, "Mahabharat"));

		ExecutorService service = Executors.newFixedThreadPool(2);

		Runnable r1 = () -> list.forEach(Book::print);
		// service.execute(r1);

		// System.out.println("======================================");

		Runnable r2 = () -> {
			Consumer<Book> style = (Book b) -> System.out
					.println("Book Id:" + b.getId() + ", Book Name:" + b.getName());
			list.forEach(style);
		};

		// service.execute(r2);

		try {
			service.execute(r1);
			System.out.println("======================================");
			service.execute(r2);
		} catch (Exception e) {

		} finally {
			if (!service.isShutdown()) {
				service.shutdown();
				System.out.println("Executor shutdown now!!");
			}
		}

	}

}
