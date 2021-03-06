package tr.org.linux.opencourseorganizer.client.ui.desktop;

import tr.org.linux.opencourseorganizer.client.Constants;
import tr.org.linux.opencourseorganizer.client.Messages;
import tr.org.linux.opencourseorganizer.client.ui.SubjectDisplay;
import tr.org.linux.opencourseorganizer.shared.SubjectProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class SubjectView extends Composite implements SubjectDisplay {

	@UiTemplate("SubjectView.ui.xml")
	interface HomeViewUiBinder extends UiBinder<Widget, SubjectView> {}

	private static HomeViewUiBinder uiBinder = GWT.create(HomeViewUiBinder.class);

	@SuppressWarnings("unused")
	private Presenter presenter;
	@SuppressWarnings("unused")
	private final Messages messages;
	private final Constants constants;

	@UiField Label namelabel;
	@UiField Label subjectName;

	@Inject
	public SubjectView(final Messages messages, final Constants constants) {
		this.messages = messages;
		this.constants = constants;
		initWidget(uiBinder.createAndBindUi(this));
		initialize();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void loadSubject(SubjectProxy response) {
		subjectName.setText(response.getName());
	}

	private void initialize() {
		namelabel.setText(constants.subjectName());
	}

}
