package de.dreamnetworx.fxmvp.sample.app.ui.layout;

import de.dreamnetworx.fxmvp.api.ViewObserver;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class AppLayoutViewImpl implements AppLayoutView, Initializable {

    @FXML
    private AnchorPane menuPane;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonSync;
    @FXML
    private AnchorPane contentPane;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

    }

    @Override
    public AnchorPane getMenuPane() {
        return menuPane;
    }

    @Override
    public Button getButtonAdd() {
        return buttonAdd;
    }

    @Override
    public Button getButtonSync() {
        return buttonSync;
    }

    @Override
    public AnchorPane getContentPane() {
        return contentPane;
    }

    @Override
    public void setViewObserver(final ViewObserver viewObserver) {

    }
}
