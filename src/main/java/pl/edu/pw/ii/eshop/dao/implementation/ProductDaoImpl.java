package pl.edu.pw.ii.eshop.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pw.ii.eshop.dao.ProductDao;
import pl.edu.pw.ii.eshop.model.Product;

/**
 * Klasa implementuj�ca interfejs {@link ProductDao} przy u�yciu ORM hibernate
 * 
 * @author �ukasz Kruk
 *
 */

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		// utrwalenie produktu
		session.saveOrUpdate(product);
		session.flush();

	}

	@Override
	public Product getProductById(int id) {
		Session session = sessionFactory.getCurrentSession();
		// pobranie produktu o zadanym id
		Product product = (Product) session.get(Product.class, id);
		session.flush();
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		// prygotowanie zapytania zwracaj�cego wszystkie produkty
		Query query = session.createQuery("from Product");
		// wykonanie zapytania i przypisanie wynik�w
		List<Product> products = query.list();
		session.flush();
		return products;
	}

	@Override
	public void deleteProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		// usuni�cie produktu
		session.delete(product);
		session.flush();
	}

	@Override
	public void editProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		// utrwalenie produktu
		session.merge(product);
		session.flush();

	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		Session session = sessionFactory.getCurrentSession();
		// przygotowanie zapytania pobieraj�cego produkty o zadanej kategorii
		Query query = session.createQuery("from Product where category=?");
		// ustawienie parametr�w zapytania
		query.setString(0, category);
		// wykonanie zapytania oraz przypisanie wynik�w
		List<Product> products = query.list();
		session.flush();
		return products;
	}

}
