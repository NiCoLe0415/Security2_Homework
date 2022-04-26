package Security2.Security2.service;

import Security2.Security2.model.WishlistModel;
import Security2.Security2.repository.UserRepository;
import Security2.Security2.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WishlistService {
    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;

    public WishlistModel getWishlistByUserId(Integer userId) {
        return userRepository.getById(userId).getWishlistModel();
    }

    public void updateWishList(WishlistModel wishlistModel, Integer userId){
        userRepository.getById(userId).setWishlistModel(wishlistModel);
    }

    public void deleteWishlistByUserId(Integer userId) {
        userRepository.getById(userId).setWishlistModel(null);
        wishlistRepository.deleteAll();
    }




}
