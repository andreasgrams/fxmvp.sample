package de.dreamnetworx.fxmvp.sample.app.ui.view;

import de.dreamnetworx.fxmvp.sample.app.ui.model.PersonViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonDetailViewImpl implements PersonDetailView, Initializable {

    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtSurname;
    @FXML
    private Button btnSave;
    @FXML
    private AnchorPane layout;

    private PersonDetailPresenter.PersonDetailViewObserver viewObserver;

    private PersonViewModel personViewModel;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        btnSave.setOnAction(event -> viewObserver.onSaveClicked());
    }

    private void writeChangeablePropertiesBack() {
        this.personViewModel.setFirstName(txtFirstName.getText());
        this.personViewModel.setSurname(txtSurname.getText());
    }

    @Override
    public PersonViewModel getModel() {
        writeChangeablePropertiesBack();
        return personViewModel;
    }

    @Override
    public void setModel(final PersonViewModel personViewModel) {
        this.personViewModel = personViewModel;
        txtFirstName.setText(personViewModel.getFirstName());
        txtSurname.setText(personViewModel.getSurname());
    }

    @Override
    public void setViewObserver(final PersonDetailPresenter.PersonDetailViewObserver viewObserver) {
        this.viewObserver = viewObserver;
    }
}
