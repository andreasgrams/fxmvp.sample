package de.dreamnetworx.fxmvp.sample.app.ui.view;

import de.dreamnetworx.fxmvp.api.Presenter;
import de.dreamnetworx.fxmvp.api.View;
import de.dreamnetworx.fxmvp.api.ViewObserver;

public interface PersonDetailPresenter<V extends View> extends Presenter<V> {

    interface PersonDetailViewObserver extends ViewObserver {

        void onSaveClicked();

    }
}
