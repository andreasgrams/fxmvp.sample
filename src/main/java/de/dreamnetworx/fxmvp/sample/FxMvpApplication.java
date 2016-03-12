package de.dreamnetworx.fxmvp.sample;

import com.google.common.eventbus.EventBus;
import de.dreamnetworx.fxmvp.api.FxMvpBootstrapApplication;
import de.dreamnetworx.fxmvp.api.FxMvpPresenter;
import de.dreamnetworx.fxmvp.api.FxMvpResult;
import de.dreamnetworx.fxmvp.sample.app.ui.layout.AppLayoutPresenter;
import de.dreamnetworx.fxmvp.sample.app.ui.layout.AppLayoutPresenterImpl;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;

import java.net.URL;
import java.util.ResourceBundle;

public class FxMvpApplication extends FxMvpBootstrapApplication implements Initializable {

    private EventBus eventBus = new EventBus();

    public FxMvpApplication() {
        super();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final SpringApplication app = new SpringApplication(ApplicationContext.class);
        final org.springframework.context.ApplicationContext context = app.run();

        FxMvpResult fxMvpResult = initializeMvpApp(context, "AppLayoutView");

        AppLayoutPresenter appLayoutPresenter = new AppLayoutPresenterImpl();
        ((FxMvpPresenter) appLayoutPresenter).construct(fxMvpResult.getView(), fxMvpResult.getNode(), eventBus);
        appLayoutPresenter.startPresenting(primaryStage);

    }

    public void initialize(final URL location, final ResourceBundle resources) {

    }
}
