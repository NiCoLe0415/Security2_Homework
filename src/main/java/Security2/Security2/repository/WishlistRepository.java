package Security2.Security2.repository;


import Security2.Security2.model.WishlistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistModel,Integer> {
}
