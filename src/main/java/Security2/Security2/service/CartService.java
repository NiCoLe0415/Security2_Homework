package Security2.Security2.service;

import Security2.Security2.model.CartModel;
import Security2.Security2.model.ProductModel;
import Security2.Security2.repository.CartRepository;
import Security2.Security2.repository.ProductRepository;
import Security2.Security2.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public CartModel getById(Integer id){
        return cartRepository.getById(id);
    }

    public List<CartModel> getAllCarts(){
        return cartRepository.findAll();
    }

    public CartModel insertCart(Integer userId, CartModel cartModel){
        userRepository.getById(userId).getCartModelList().add(cartModel);
        return cartRepository.save(cartModel);
    }

    public void updateCart(Integer cartId,List<ProductModel>list){
        cartRepository.getById(cartId).setProductModelList(list);

    }

    public void delete(Integer cartId, Integer userId) {
        userRepository.getById(userId).getCartModelList().remove(cartRepository.getById(cartId));
        cartRepository.deleteById(cartId);
    }




}
