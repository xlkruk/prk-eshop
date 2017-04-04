package pl.edu.pw.ii.eshop.dao.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import pl.edu.pw.ii.eshop.dao.ProductDao;
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.ProductInfo;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();

	}

	@Override
	public Product getProductById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		ProductInfo productInfo = new ProductInfo();

		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		session.flush();

		return products;
	}

	@Override
	public void deleteProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductById(id));
		session.flush();
	}

	@Override
	public void addProduct(ProductInfo productInfo) {
		Product product = productInfoToProduct(productInfo);

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();

	}

	private Product productInfoToProduct(ProductInfo productInfo) {
		Product product = new Product();
		product.setCategory(productInfo.getCategory());
		product.setCondition(productInfo.getCondition());
		product.setDescription(productInfo.getDescription());
		product.setDiscount(productInfo.getDiscount());
		product.setId(productInfo.getId());
		product.setManufacturer(productInfo.getManufacturer());
		product.setName(productInfo.getName());
		product.setPrice(productInfo.getPrice());
		product.setStatus(productInfo.getStatus());
		product.setStock(productInfo.getStock());
		if (productInfo.getProductImageAsArray() != null && productInfo.getProductImageAsArray().length > 0) {
			product.setProductImage(productInfo.getProductImageAsArray());
		}
		return product;
	}

	@Override
	public void editProduct(ProductInfo productInfo) {
		byte[] oldImage = getProductById(productInfo.getId()).getProductImage();
		Product product = productInfoToProduct(productInfo);
		if (product.getProductImage() == null) {
			product.setProductImage(oldImage);
		}
		Session session = sessionFactory.getCurrentSession();
		//session.saveOrUpdate(product);
		session.merge(product);
		session.flush();

	}

}
