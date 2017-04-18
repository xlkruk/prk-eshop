package pl.edu.pw.ii.eshop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.pw.ii.eshop.dao.ProductDao;
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.ProductInfo;
import pl.edu.pw.ii.eshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
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
		byte[] oldImage = getProductById(productInfo.getId()).getProductImage();
		Product product = productInfoToProduct(productInfo);
		if (product.getProductImage() == null) {
			product.setProductImage(oldImage);
		}
		productDao.editProduct(product);		
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
	public void addProduct(ProductInfo productInfo) {
		addProduct(productInfoToProduct(productInfo));		
	}

}
