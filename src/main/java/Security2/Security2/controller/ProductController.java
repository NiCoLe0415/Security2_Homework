package Security2.Security2.controller;

import Security2.Security2.model.ProductModel;
import Security2.Security2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getProductById/{prodId}")
    public ProductModel getProductById(@PathVariable Integer prodId) {
        return productService.getProductById(prodId);
    }

    @GetMapping("/getAllProducts")
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/productsToCart/{cartId}")
    public ProductModel addProductToCart(@RequestBody ProductModel productModel, @PathVariable Integer cartId) {
        return productService.addProductToCart(cartId,productModel);
    }

    @PostMapping("/productsToWishlist/{userId}")
    public ProductModel addProductToWishList(@RequestBody ProductModel product, @PathVariable Integer userId) {
        return productService.addProductToWishlist(product, userId);
    }

    @PutMapping("/updateProduct/{id}")
    public void updateProduct(@RequestBody ProductModel productModel, @PathVariable Integer prodId){
        productService.updateProduct(prodId,productModel);
    }

    @DeleteMapping("/deleteProductFromCart/{cartId}/{prodId}")
    public void deleteProductFromCart(@PathVariable Integer cartId, @PathVariable Integer prodId) {
        productService.deleteProductFromCart(cartId, prodId);
    }

    @DeleteMapping("/productFromWishlist/{cartId}/{prodId}")
    public void deleteProductFromWishlist(@PathVariable Integer cartId, @PathVariable Integer prodId) {
        productService.deleteProductFromWishlist(cartId, prodId);

    }



}
