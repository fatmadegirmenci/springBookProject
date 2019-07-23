package springbookproject.springbookproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbookproject.springbookproject.Dao.InventoryDaoImpl;
import springbookproject.springbookproject.Domain.Book;
import springbookproject.springbookproject.Domain.Inventory;
import javax.transaction.Transactional;

@Component
@Transactional
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryDaoImpl inventoryDao;

    @Override
    public void create(Inventory inventory) {
        inventoryDao.create(inventory);
    }

    @Override
    public void addBook(Book book) {
   //     inventoryDao.addBook(book);
    }

    @Override
    public void deleteBook(Book book) {
        inventoryDao.deleteBook(book);
    }

    @Override
    public Inventory getById(Long id) {
        return inventoryDao.getById(id);
    }

    @Override
    public void setBookCount(Long book_id, int bookCount) {
        inventoryDao.setBookCount(book_id, bookCount);
    }

    @Override
    public void decreaseBookCount(Long book_id) {
        inventoryDao.decreaseBookCount(book_id);
    }

    @Override
    public void increaseBookCount(Long book_id) {
        inventoryDao.increaseBookCount(book_id);
    }

}
