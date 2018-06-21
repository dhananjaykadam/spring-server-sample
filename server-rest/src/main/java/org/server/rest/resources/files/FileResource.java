package org.server.rest.resources.files;

import java.io.IOException;
import java.util.List;

import org.server.core.dtos.common.Entry;
import org.server.core.dtos.images.base64data.Base64DataDTO;
import org.server.core.entities.images.ProfileImageInfo;
import org.server.core.enums.images.DefaultImagesIdEnum;
import org.server.core.enums.profile.ProfileImageType;
import org.server.core.exceptions.handleradvice.NotFoundException;
import org.server.filestore.entities.BinaryFile;
import org.server.services.files.FileService;
import org.server.services.files.imageinfo.ProfileImageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("files")
public class FileResource {

	@Autowired
	private FileService fileService;
	@Autowired
	private ProfileImageInfoService profileImageInfoService;

	public ProfileImageInfoService getProfileImageInfoService() {
		return profileImageInfoService;
	}

	public void setProfileImageInfoService(ProfileImageInfoService profileImageInfoService) {
		this.profileImageInfoService = profileImageInfoService;
	}

	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	@RequestMapping(value = "id/{fileStoreId}")
	public ResponseEntity<Void> getFileById(@PathVariable("fileStoreId") String fileStoreId) {
		return null;
	}

	@RequestMapping(value = "images/profile/{profileId}/{profileImageType}", method = RequestMethod.POST)
	public ResponseEntity<ProfileImageInfo> addProfilePhotos(@RequestPart("profileImage") MultipartFile profilePhoto,
			@PathVariable("profileId") Long profileId,
			@PathVariable("profileImageType") ProfileImageType profileImageType) throws IOException {
		ProfileImageInfo profileImageInfo = getProfileImageInfoService().saveSpaceImageFromMultipart(profilePhoto,
				profileId, profileImageType);
		return ResponseEntity.ok().body(profileImageInfo);
	}

	@RequestMapping(value = "images/profile/{profileId}/{profileImageType}/base64", method = RequestMethod.POST)
	public ResponseEntity<ProfileImageInfo> addProfilePhotosFrombase64(@RequestBody Base64DataDTO base64DataDTO,
			@PathVariable("profileId") Long profileId,
			@PathVariable("profileImageType") ProfileImageType profileImageType) throws IOException {
		ProfileImageInfo profileImageInfo = getProfileImageInfoService().saveSpaceImageFromBase64Data(base64DataDTO,
				profileId, profileImageType);
		return ResponseEntity.ok().body(profileImageInfo);
	}

	@RequestMapping(value = "images/profile/{profileId}/{profileImageType}", method = RequestMethod.GET)
	public ResponseEntity<Entry<List<ProfileImageInfo>>> getGalleryPhotos(@PathVariable("profileId") Long profileId,
			@PathVariable("profileImageType") ProfileImageType profileImageType) {
		List<ProfileImageInfo> profileImageInfos = getProfileImageInfoService()
				.findTop3ByProfileAndProfileImageType(profileId, profileImageType);
		Entry<List<ProfileImageInfo>> entry = new Entry<>();
		entry.setEntry(profileImageInfos);
		return ResponseEntity.ok().body(entry);
	}

	@RequestMapping(value = "images/profile/{profileId}/{profileImageType}/default", method = RequestMethod.GET)
	public ResponseEntity<Resource> getDefaultProfilePhoto(@PathVariable("profileId") Long profileId,
			@PathVariable("profileImageType") ProfileImageType profileImageType) {
		List<ProfileImageInfo> profileImageInfos = getProfileImageInfoService()
				.findTop3ByProfileAndProfileImageType(profileId, profileImageType);
		if (profileImageInfos != null && !profileImageInfos.isEmpty()) {
			BinaryFile binaryFile = getFileService()
					.getProfileImageByFileStoreId(profileImageInfos.get(0).getImageId());
			if (binaryFile != null) {
				Resource resource = new ByteArrayResource(binaryFile.getContent());
				return ResponseEntity.ok().contentType(MediaType.parseMediaType(binaryFile.getContentType()))
						.body(resource);
			}
		}
		throw new NotFoundException("Default profile image not found");
	}

	// @RequestMapping(value = "images/{imageId}/spaces/{spaceId}")
	// public ResponseEntity<Resource> getSpaceImage(@PathVariable("imageId")
	// String imageId,
	// @PathVariable("spaceId") String spaceId) {
	// BinaryFile binaryFile =
	// getFileService().getSpaceImageByFileStoreId(imageId);
	// if (binaryFile != null) {
	// Resource resource = new ByteArrayResource(binaryFile.getContent());
	// return
	// ResponseEntity.ok().contentType(MediaType.parseMediaType(binaryFile.getContentType()))
	// .body(resource);
	// }
	// throw new NotFoundException("Image Not Found");
	// }

	@RequestMapping(value = "images/{imageId}/profile/{profileId}")
	public ResponseEntity<Resource> getProfileImage(@PathVariable("imageId") String imageId,
			@PathVariable("profileId") String profileId) {
		BinaryFile binaryFile = getFileService().getProfileImageByFileStoreId(imageId);
		if (binaryFile != null) {
			Resource resource = new ByteArrayResource(binaryFile.getContent());
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(binaryFile.getContentType()))
					.body(resource);
		}
		throw new NotFoundException("Image Not Found");
	}

	@RequestMapping(value = "images/default/type/{defaultImageType}")
	public ResponseEntity<Resource> getProfileImage(
			@PathVariable("defaultImageType") DefaultImagesIdEnum defaultImagesIdEnum) {
		BinaryFile binaryFile = getFileService().getProfileImageByDefaultPhotoId(defaultImagesIdEnum);
		if (binaryFile != null) {
			Resource resource = new ByteArrayResource(binaryFile.getContent());
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(binaryFile.getContentType()))
					.body(resource);
		}
		throw new NotFoundException("Image Not Found");
	}

}
