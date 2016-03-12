package de.dreamnetworx.fxmvp.sample.app.ui.view;

import de.dreamnetworx.fxmvp.api.View;
import de.dreamnetworx.fxmvp.sample.app.ui.model.PersonViewModel;

import java.util.List;

public interface PersonSelectorView extends View<PersonSelectorPresenter.PersonSelectorViewObserver> {

    void setListOfPersons(List<PersonViewModel> listOfPersons);
}
