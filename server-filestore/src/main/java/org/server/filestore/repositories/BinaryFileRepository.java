package org.server.filestore.repositories;

import org.server.filestore.entities.BinaryFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinaryFileRepository extends JpaRepository<BinaryFile, Long> {
	public BinaryFile findByFileId(String fileId);
}
