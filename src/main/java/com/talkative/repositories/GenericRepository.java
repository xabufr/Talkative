package com.talkative.repositories;

import java.util.List;

public interface GenericRepository<T> {
	T load(long id);
	
	List<T> loadAll();
}
