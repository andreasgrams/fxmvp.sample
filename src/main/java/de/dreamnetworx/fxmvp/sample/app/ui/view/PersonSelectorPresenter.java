package de.dreamnetworx.fxmvp.sample.app.ui.view;

import de.dreamnetworx.fxmvp.api.Presenter;
import de.dreamnetworx.fxmvp.api.View;
import de.dreamnetworx.fxmvp.api.ViewObserver;
import de.dreamnetworx.fxmvp.sample.app.ui.model.PersonViewModel;

public interface PersonSelectorPresenter<V extends View> extends Presenter<V> {

    interface PersonSelectorViewObserver extends ViewObserver {

        void onPersonItemSelected(PersonViewModel model);

        //void onPersonItemSelected(PersonItemLayout source);
    }

}
