package pl.edu.pw.ii.eshop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pl.edu.pw.ii.eshop.dao.CustomerDao;
import pl.edu.pw.ii.eshop.dao.ProductDao;
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.ProductInfo;
import pl.edu.pw.ii.eshop.service.ProductService;

/**
 * Klasa implementująca inteffejs {@link ProductService}. Wykorzystuje
 * implementację intefejsu {@link ProductDao} do komunikaacji z warstwą dostępu
 * do danych.
 * 
 * @author Agnieszka Świderska
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getProductList() {
		return productDao.getAllProducts();
	}

	@Override
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);

	}

	@Override
	public void editProduct(Product product) {
		productDao.editProduct(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);

	}

	@Override
	public void editProduct(ProductInfo productInfo) {
		importImage(productInfo);
		byte[] oldImage = getProductById(productInfo.getId()).getProductImage();
		Product product = productInfoToProduct(productInfo);
		if (product.getProductImage() == null) {
			product.setProductImage(oldImage);
		}
		productDao.editProduct(product);
	}

	private void importImage(ProductInfo productInfo) {
		MultipartFile productImage = productInfo.getProductImage();
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productInfo.setProductImageAsArray(productImage.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed", e);
			}
		}
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
		// sprawdzenie czy dodano obrazek do modyfikacji
		if (productInfo.getProductImageAsArray() != null && productInfo.getProductImageAsArray().length > 0) {
			product.setProductImage(productInfo.getProductImageAsArray());
		}
		return product;
	}

	@Override
	public void addProduct(ProductInfo productInfo) {
		importImage(productInfo);
		addProduct(productInfoToProduct(productInfo));
	}

	@Override
	public List<Product> getProductListByCategory(String category) {
		return productDao.getProductsByCategory(category);
	}

}
