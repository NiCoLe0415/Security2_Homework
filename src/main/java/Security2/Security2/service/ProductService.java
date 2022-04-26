package Security2.Security2.service;

import Security2.Security2.model.ProductModel;
import Security2.Security2.repository.CartRepository;
import Security2.Security2.repository.ProductRepository;
import Security2.Security2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public List<ProductModel> getAllProducts(){
        return productRepository.findAll();
    }

    public ProductModel getProductById(Integer prodId){
        return productRepository.getById(prodId);
    }

    public ProductModel addProductToCart(Integer cartId, ProductModel productModel){
        cartRepository.getById(cartId).getProductModelList().add(productModel);
        return productRepository.save(productModel);
    }

    public ProductModel addProductToWishlist(ProductModel productModel, Integer userId) {
        userRepository.getById(userId).getWishlistModel().getProductModelList().add(productModel);
        return productRepository.save(productModel);
    }

    public void updateProduct(Integer prodId,ProductModel productModel){
        productRepository.getById(prodId).setName(productModel.getName());
        productRepository.getById(prodId).setPrice(productModel.getPrice());
        productRepository.getById(prodId).setQuantity(productModel.getQuantity());
        productRepository.save(productModel);
    }
    public void deleteProductFromCart(Integer cartId, Integer prodId){
        cartRepository.getById(cartId).getProductModelList().remove(productRepository.getById(prodId));
        productRepository.deleteById(prodId);
    }

    public void deleteProductFromWishlist(Integer userId, Integer prodId) {
        userRepository.getById(userId).getWishlistModel().getProductModelList().remove(productRepository.getById(prodId));
        productRepository.deleteById(prodId);
    }

}
