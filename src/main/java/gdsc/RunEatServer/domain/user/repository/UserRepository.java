package gdsc.RunEatServer.domain.user.repository;

import gdsc.RunEatServer.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    Slice<User> findBy(Pageable pageable);
}