package tr.org.linux.opencourseorganizer.server.domain;

import tr.org.linux.opencourseorganizer.server.ioc.DaoModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class GuiceServiceLocator implements ServiceLocator {

	private final Injector injector = Guice.createInjector(new DaoModule());

	@Override
	public Object getInstance(Class<?> clazz) {
		return injector.getInstance(clazz);
	}

}
