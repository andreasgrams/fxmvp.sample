package de.dreamnetworx.fxmvp.sample.app.ui.layout;

import de.dreamnetworx.fxmvp.api.FxMvpAppMvpPresenter;
import de.dreamnetworx.fxmvp.api.FxMvpResult;
import de.dreamnetworx.fxmvp.sample.app.ui.view.PersonDetailPresenter;
import de.dreamnetworx.fxmvp.sample.app.ui.view.PersonDetailView;
import de.dreamnetworx.fxmvp.sample.app.ui.view.PersonSelectorPresenter;
import de.dreamnetworx.fxmvp.sample.app.ui.view.PersonSelectorView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * The job from FxMvpAppMvpPresenter is to create and initialize the sub presenters und setup the
 * application layout.
 *
 */
public class AppLayoutPresenterImpl extends FxMvpAppMvpPresenter<AppLayoutView> implements AppLayoutPresenter<AppLayoutView> {

    private static final Logger LOG = LoggerFactory.getLogger(AppLayoutPresenterImpl.class);

    /**
     * Presenter to view the person details
     */
    private PersonDetailPresenter<PersonDetailView> personDetailPresenter;

    /**
     * Presenter to select a person
     */
    private PersonSelectorPresenter<PersonSelectorView> personSelectorPresenter;

    @Override
    public void startPresenting(Stage stage) {

        //Initialize another FXML View with presenter. Only the fxml file is needed!
        final FxMvpResult personDetailView = initFxPresenter(stage, "PersonDetailView");
        //the FxMvpResult provides access to viewNode, view and presenter. The viewNode can be add
        //to the application layout.
        getView().getContentPane().getChildren().add(personDetailView.getNode());

        final FxMvpResult personSelectorView = initFxPresenter(stage, "PersonSelectorView");
        getView().getMenuPane().getChildren().add(personSelectorView.getNode());

        //bind something...
        getView().getButtonAdd().setOnAction(event -> LOG.info("button add clicked"));

        getView().getButtonSync().setOnAction(event -> LOG.info("button sync"));

        //delegate to layout...
        final Scene scene = new Scene((Parent) getViewNode(), 700, 550);
        stage.setScene(scene);
        stage.setTitle("FxMVP Application");
        addStyleClass(scene,"style/style.css");
        stage.show();
    }

    private void addStyleClass(final Scene scene, String path) {
        String css;
        try {
            css = new ClassPathResource(path).getURL().toExternalForm();
            scene.getStylesheets().add(css);
        } catch (IOException e) {
            LOG.warn("stylesheet wurde nicht gefunden {}", path );
        }
    }
}
