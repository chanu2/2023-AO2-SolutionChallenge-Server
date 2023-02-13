package gdsc.RunEatServer.domain.asset.repository;

import gdsc.RunEatServer.domain.asset.entity.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfileImageRepository extends JpaRepository<Long, ProfileImage> {

    @Query(value = "SELECT * FROM tbl_profile_image order by RAND() limit 1", nativeQuery = true)
    Optional<ProfileImage> findRandomProfileImage();
    
}
