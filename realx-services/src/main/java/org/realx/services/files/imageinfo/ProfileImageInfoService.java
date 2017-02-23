package org.realx.services.files.imageinfo;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.realx.core.dtos.images.base64data.Base64DataDTO;
import org.realx.core.entities.images.ProfileImageInfo;
import org.realx.core.entities.profile.common.Profile;
import org.realx.core.enums.profile.ProfileImageType;
import org.realx.core.repositories.files.images.ProfileImageInfoRepository;
import org.realx.filestore.entities.BinaryFile;
import org.realx.filestore.services.BinaryFileService;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.realx.services.keys.uuid.UUIDService;
import org.realx.services.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProfileImageInfoService extends DefaultJpaServiceImpl<ProfileImageInfo, Long, ProfileImageInfoRepository>
		implements JpaService<ProfileImageInfo, Long> {
	@Autowired
	private BinaryFileService binaryFileService;
	@Autowired
	private UUIDService UUIDService;
	@Autowired
	private ProfileImageInfoRepository profileImageInfoRepository;
	@Autowired
	private ProfileService profileService;

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public BinaryFileService getBinaryFileService() {
		return binaryFileService;
	}

	public void setBinaryFileService(BinaryFileService binaryFileService) {
		this.binaryFileService = binaryFileService;
	}

	public UUIDService getUUIDService() {
		return UUIDService;
	}

	public void setUUIDService(UUIDService uUIDService) {
		UUIDService = uUIDService;
	}

	public ProfileImageInfoRepository getProfileImageInfoRepository() {
		return profileImageInfoRepository;
	}

	public void setProfileImageInfoRepository(ProfileImageInfoRepository profileImageInfoRepository) {
		this.profileImageInfoRepository = profileImageInfoRepository;
	}

	public ProfileImageInfo findByImageId(String imageId) {
		return getProfileImageInfoRepository().findByImageId(imageId);
	}

	public ProfileImageInfo saveSpaceImageFromMultipart(MultipartFile multipartFile, Long profileId,
			ProfileImageType profileImageType) throws IOException {
		BinaryFile binaryFile = new BinaryFile();
		binaryFile.setContent(multipartFile.getBytes());
		binaryFile.setContentType(multipartFile.getContentType());
		binaryFile.setFileName(multipartFile.getOriginalFilename());
		binaryFile.setFileId(getUUIDService().getNewUUIDNoDashes());
		binaryFile = getBinaryFileService().create(binaryFile);

		ProfileImageInfo imageInfo = new ProfileImageInfo();
		imageInfo.setImageId(binaryFile.getFileId());
		imageInfo.setProfileImageType(profileImageType);

		Profile profile = getProfileService().findById(profileId);
		imageInfo.setProfile(profile);
		imageInfo = getProfileImageInfoRepository().save(imageInfo);
		return imageInfo;
	}

	public ProfileImageInfo saveSpaceImageFromBase64Data(Base64DataDTO base64DataDTO, Long profileId,
			ProfileImageType profileImageType) throws IOException {
		BinaryFile binaryFile = new BinaryFile();

		byte[] imageBytes = Base64.getDecoder().decode(base64DataDTO.getData());
		binaryFile.setContent(imageBytes);
		binaryFile.setContentType(base64DataDTO.getContentType());
		binaryFile.setFileName(base64DataDTO.getFileName());
		binaryFile.setFileId(getUUIDService().getNewUUIDNoDashes());
		binaryFile = getBinaryFileService().create(binaryFile);

		ProfileImageInfo imageInfo = new ProfileImageInfo();
		imageInfo.setImageId(binaryFile.getFileId());
		imageInfo.setProfileImageType(profileImageType);

		Profile profile = getProfileService().findById(profileId);
		imageInfo.setProfile(profile);
		imageInfo = getProfileImageInfoRepository().save(imageInfo);
		return imageInfo;
	}

	public List<ProfileImageInfo> getProfileImagesByProfileAndImageType(Long profileId,
			ProfileImageType profileImageType) {
		Profile profile = getProfileService().findById(profileId);
		return getProfileImageInfoRepository().findByProfileAndProfileImageType(profile, profileImageType);
	}

	public List<ProfileImageInfo> findTop3ByProfileAndProfileImageType(Long profileId,
			ProfileImageType profileImageType) {
		Profile profile = getProfileService().findById(profileId);
		return getProfileImageInfoRepository().findTop3ByAndProfileAndProfileImageTypeOrderByIdDesc(profile,
				profileImageType);
	}
}
