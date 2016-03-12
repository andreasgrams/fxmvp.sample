package de.dreamnetworx.fxmvp.sample.app.ui.view;

import de.dreamnetworx.fxmvp.api.FxMvpPresenter;
import de.dreamnetworx.fxmvp.sample.app.service.PersonService;
import de.dreamnetworx.fxmvp.sample.app.ui.event.PeopleSelectionEvent;
import de.dreamnetworx.fxmvp.sample.app.ui.model.PersonViewModel;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonSelectorPresenterImpl extends FxMvpPresenter<PersonSelectorView>
        implements PersonSelectorPresenter<PersonSelectorView>, PersonSelectorPresenter.PersonSelectorViewObserver {

    @Autowired
    private PersonService personService;

    @Override
    public void startPresenting(final Stage stage) {
        getView().setListOfPersons(personService.getPersons());
    }

    @Override
    public void onPersonItemSelected(final PersonViewModel model) {
        getEventBus().post(new PeopleSelectionEvent(model));
    }
}
