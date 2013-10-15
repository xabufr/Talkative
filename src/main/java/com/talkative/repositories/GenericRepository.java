package com.talkative.repositories;

import java.io.Serializable;

public interface GenericRepository<T> {
	T load(Serializable id);
}
