package Security2.Security2.controller;


import Security2.Security2.model.WishlistModel;
import Security2.Security2.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class WishlistController {
    private final WishlistService wishlistService;

    @GetMapping("/getWishlistByUserId/{userId}")
    public WishlistModel getWishlistByUserId(@PathVariable Integer userId) {
        return wishlistService.getWishlistByUserId(userId);
    }


    @PutMapping("/updateWishListByUserId/{userId}")
    public void updateWishList(@RequestBody WishlistModel wishlistModel,@PathVariable Integer userId){
        wishlistService.updateWishList(wishlistModel,userId);
    }
    @DeleteMapping("/deleteWishListByUserId/{userId}")
    public void deleteCart(@PathVariable Integer userId) {
        wishlistService.deleteWishlistByUserId(userId);
    }

}
