package com.talkative.repositories;

public interface GenericRepository<T> {
	T load(long id);
}
