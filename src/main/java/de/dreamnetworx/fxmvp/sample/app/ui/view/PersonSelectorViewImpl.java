package de.dreamnetworx.fxmvp.sample.app.ui.view;

import de.dreamnetworx.fxmvp.sample.app.ui.model.PersonViewModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PersonSelectorViewImpl implements PersonSelectorView, Initializable {

    @FXML
    private ListView<PersonViewModel> personListView;

    private PersonSelectorPresenter.PersonSelectorViewObserver viewObserver;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        personListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PersonViewModel>() {
            @Override
            public void changed(final ObservableValue<? extends PersonViewModel> observable, final PersonViewModel oldValue, final PersonViewModel newValue) {
                viewObserver.onPersonItemSelected(newValue);
            }
        });
    }

    @Override
    public void setViewObserver(final PersonSelectorPresenter.PersonSelectorViewObserver viewObserver) {
        this.viewObserver = viewObserver;
    }

    @Override
    public void setListOfPersons(List<PersonViewModel> listOfPersons){
        final ObservableList<PersonViewModel> observableList = FXCollections.observableArrayList(listOfPersons);
        personListView.setItems(observableList);
    }
}
