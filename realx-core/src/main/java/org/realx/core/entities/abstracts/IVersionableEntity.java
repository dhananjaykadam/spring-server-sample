package org.realx.core.entities.abstracts;

import java.util.Date;

import org.realx.core.entities.user.User;

public interface IVersionableEntity<T> extends IAbstractEntity<T> {
	public Date getCreatedAt();

	public void setCreatedAt(Date createdAt);

	public Date getUpdatedAt();

	public void setUpdatedAt(Date updatedAt);

	public Date getDeletedAt();

	public void setDeletedAt(Date deletedAt);

	public void setCreatedBy(User createdBy);

	public User getUpdatedBy();

	public void setUpdatedBy(User updatedBy);

	public User getCreatedBy();

}
