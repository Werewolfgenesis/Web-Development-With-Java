package labs.week3.task0;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookStore implements Store {
    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean add(Book o) {
        if (this.books.contains(o)) {
            return false;
        } else {
            this.books.add(o);
            return true;
        }
    }

    @Override
    public void remove(Book o) {
        this.books.remove(o);
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        List<Book> booksWithAuthor = new ArrayList<>();
        for (Book b :
                this.books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                booksWithAuthor.add(b);
            }
        }
        return booksWithAuthor;
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        List<Book> publishedAfter = new ArrayList<>();
        for (Book b :
                this.books) {
            if (b.getPublishedYear().isAfter(from)) {
                publishedAfter.add(b);
            }
        }
        return publishedAfter;
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        List<Book> booksBetween = new ArrayList<>();
        for (Book b :
                this.books) {
            if (b.getPublishedYear().isAfter(from) &&
                    b.getPublishedYear().isBefore(to)) {
                booksBetween.add(b);
            }
        }
        return booksBetween;
    }

    @Override
    public void clear() {
        this.books.clear();
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        Map<String, List<Book>> library = new HashMap<>();

        for (Book b :
                this.books) {
            if (library.containsKey(b.getAuthor())) {
                library.get(b.getAuthor()).add(b);
            } else {
                library.put(b.getAuthor(), Arrays.asList(b));
            }
        }

        return library;
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        Map<String, List<Book>> library = new HashMap<>();

        for (Book b :
                this.books) {
            if (library.containsKey(b.getPublisher())) {
                library.get(b.getPublisher()).add(b);
            } else {
                library.put(b.getPublisher(), Arrays.asList(b));
            }
        }

        return library;
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        return this.books.stream().filter(bookPredicate).collect(Collectors.toList());
    }


}
