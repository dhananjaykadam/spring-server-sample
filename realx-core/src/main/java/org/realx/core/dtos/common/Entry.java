package org.realx.core.dtos.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Entry<T> {
	private T entry;
	private String description;
	private long size;

	public Entry(T t) {
		this.entry = t;
		setSize();
	}

	public Entry(T entry, String description) {
		this.entry = entry;
		this.description = description;
		setSize();
	}

	public Entry() {
	}

	public Entry<T> build() {
		return this;
	}

	public Entry<T> entry(T entry) {
		this.entry = entry;
		setSize();
		return this;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public T getEntry() {
		return entry;
	}

	public void setEntry(T entry) {
		this.entry = entry;
		setSize();
	}

	public long setSize() {
		if (entry instanceof List<?>)
			setSize(((List<?>) entry).size());
		return getSize();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
