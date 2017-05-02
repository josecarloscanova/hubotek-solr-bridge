package org.hubotek;

import java.io.Serializable;

public interface Base<T> extends Serializable{

	T getId();
	
	void setId(T t);
	
}
