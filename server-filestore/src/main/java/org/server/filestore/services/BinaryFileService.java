package org.server.filestore.services;

import org.server.filestore.entities.BinaryFile;
import org.server.filestore.entities.abstracts.AbstractJpaService;
import org.server.filestore.repositories.BinaryFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BinaryFileService implements AbstractJpaService<BinaryFile> {
	@Autowired
	private BinaryFileRepository fileRepository;

	public BinaryFileRepository getFileRepository() {
		return fileRepository;
	}

	public void setFileRepository(BinaryFileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}

	@Override
	public BinaryFile create(BinaryFile entity) {
		return getFileRepository().save(entity);
	}

	@Override
	public BinaryFile update(BinaryFile entity) {
		return getFileRepository().save(entity);
	}

	@Override
	public void delete(BinaryFile entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public BinaryFile findById(Long id) {
		return getFileRepository().findOne(id);
	}

	public BinaryFile findByFileId(String fileId) {
		return getFileRepository().findByFileId(fileId);
	}
}
