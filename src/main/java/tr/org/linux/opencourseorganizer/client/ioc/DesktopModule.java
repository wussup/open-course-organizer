package tr.org.linux.opencourseorganizer.client.ioc;

import tr.org.linux.opencourseorganizer.client.application.App;
import tr.org.linux.opencourseorganizer.client.application.DesktopApp;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class DesktopModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(App.class).to(DesktopApp.class).in(Singleton.class);
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		bind(PlaceController.class).toProvider(PlaceControllerProvider.class).in(Singleton.class);
	}

	static class PlaceControllerProvider implements Provider<PlaceController> {

		private final PlaceController placeController;

		@SuppressWarnings("deprecation")
		@Inject
		public PlaceControllerProvider(EventBus eventBus) {
			placeController = new PlaceController(eventBus);
		}

		public PlaceController get() {
			return placeController;
		}

	}

}
