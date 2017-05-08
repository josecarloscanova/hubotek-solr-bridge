package org.hubotek;

public interface Dispatcher<T> {

	void send(T t);
	
}
