package org.server.core.repositories.files.images;

import java.util.List;

import org.server.core.entities.images.ProfileImageInfo;
import org.server.core.entities.profile.common.Profile;
import org.server.core.enums.profile.ProfileImageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileImageInfoRepository extends JpaRepository<ProfileImageInfo, Long> {
	public ProfileImageInfo findByImageId(String imageId);

	public List<ProfileImageInfo> findByProfileAndProfileImageType(Profile profile, ProfileImageType profileImageType);

	public List<ProfileImageInfo> findTop3ByAndProfileAndProfileImageTypeOrderByIdDesc(Profile profile,
			ProfileImageType profileImageType);
}
