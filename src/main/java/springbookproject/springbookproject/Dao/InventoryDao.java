package springbookproject.springbookproject.Dao;

import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Inventory;

public interface InventoryDao {

    public void create(Inventory inventory);
   // public void addBook(Book book);
    public void deleteBook(Book book);
    public Inventory getById(Long id);
    public void setBookCount(Long book_id, int bookCount);
    public void decreaseBookCount(Long book_id);
    public void increaseBookCount(Long book_id);
}
