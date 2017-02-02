package service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class ApplicationConfig extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public ApplicationConfig() {
		singletons.add(new Myservice());
	}
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
