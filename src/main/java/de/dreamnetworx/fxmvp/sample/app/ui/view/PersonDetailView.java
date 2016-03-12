package de.dreamnetworx.fxmvp.sample.app.ui.view;

import de.dreamnetworx.fxmvp.api.View;
import de.dreamnetworx.fxmvp.sample.app.ui.model.PersonViewModel;

public interface PersonDetailView extends View<PersonDetailPresenter.PersonDetailViewObserver> {

    PersonViewModel getModel();

    void setModel(PersonViewModel personViewModel);

}
