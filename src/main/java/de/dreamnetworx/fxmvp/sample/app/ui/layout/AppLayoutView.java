package de.dreamnetworx.fxmvp.sample.app.ui.layout;

import de.dreamnetworx.fxmvp.api.View;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public interface AppLayoutView extends View {

    AnchorPane getMenuPane();

    Button getButtonAdd();

    Button getButtonSync();

    AnchorPane getContentPane();
}
