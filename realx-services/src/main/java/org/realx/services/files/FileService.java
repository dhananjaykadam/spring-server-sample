package org.realx.services.files;

import org.realx.core.entities.images.ProfileImageInfo;
import org.realx.core.enums.images.DefaultImagesIdEnum;
import org.realx.filestore.entities.BinaryFile;
import org.realx.filestore.services.BinaryFileService;
import org.realx.services.files.imageinfo.ProfileImageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {
	@Autowired
	private BinaryFileService binaryFileService;
	@Autowired
	private ProfileImageInfoService profileImageInfoService;

	public ProfileImageInfoService getProfileImageInfoService() {
		return profileImageInfoService;
	}

	public void setProfileImageInfoService(ProfileImageInfoService profileImageInfoService) {
		this.profileImageInfoService = profileImageInfoService;
	}

	public BinaryFileService getBinaryFileService() {
		return binaryFileService;
	}

	public BinaryFile getProfileImageByFileStoreId(String id) {
		ProfileImageInfo imageInfo = getProfileImageInfoService().findByImageId(id);
		if (imageInfo != null) {
			BinaryFile binaryFile = getBinaryFileService().findByFileId(imageInfo.getImageId());
			return binaryFile;
		}
		return null;
	}

	public BinaryFile getProfileImageByDefaultPhotoId(DefaultImagesIdEnum id) {
		BinaryFile binaryFile = getBinaryFileService().findByFileId(id.getValue());
		return binaryFile;
	}
}
