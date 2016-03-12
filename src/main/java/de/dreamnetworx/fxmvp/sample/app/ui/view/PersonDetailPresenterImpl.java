package de.dreamnetworx.fxmvp.sample.app.ui.view;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import de.dreamnetworx.fxmvp.api.FxMvpPresenter;
import de.dreamnetworx.fxmvp.sample.app.service.PersonService;
import de.dreamnetworx.fxmvp.sample.app.ui.event.PeopleSelectionEvent;
import de.dreamnetworx.fxmvp.sample.app.ui.model.PersonViewModel;
import javafx.scene.Node;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonDetailPresenterImpl extends FxMvpPresenter<PersonDetailView> implements PersonDetailPresenter<PersonDetailView>, PersonDetailPresenter.PersonDetailViewObserver {

    private static final Logger LOG = LoggerFactory.getLogger(PersonDetailPresenterImpl.class);

    @Autowired
    private PersonService personService;

    @Override
    public void startPresenting(final Stage stage) {
    }

    @Override
    public void construct(final PersonDetailView moduleView, final Node moduleNode, final EventBus eventBus) {
        super.construct(moduleView, moduleNode, eventBus);
    }

    @Subscribe
    public void onPeopleSelectionEvent(PeopleSelectionEvent event) {
        final PersonViewModel personViewModel = personService.getDetail(event.getItem().getId());
        getView().setModel(personViewModel);
    }

    @Override
    public void onSaveClicked() {
        final PersonViewModel personViewModel =   getView().getModel();
        LOG.info("onSaveClicked {}", personViewModel);
    }


}
