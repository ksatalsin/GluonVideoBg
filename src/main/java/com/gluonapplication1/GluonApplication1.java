package com.gluonapplication1;

import com.gluonapplication1.views.CommentsView;
import com.gluonapplication1.views.EditionView;
import com.gluonapplication1.views.LobbyView;
import com.gluonhq.charm.down.Platform;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.Swatch;
import com.gluonhq.connect.gluoncloud.GluonClient;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GluonApplication1 extends MobileApplication {

//    public static final String COMMENTS_VIEW = HOME_VIEW;
    public static final String EDITION_VIEW = "Edition View";
    public static final String MENU_LAYER = "Side Menu";
    public static final String LOBBY_VIEW = HOME_VIEW;
    private static final Logger LOG = Logger.getLogger(GluonApplication1.class.getName());
    @Override
    public void init() {

        addViewFactory(LOBBY_VIEW, () -> (View) new LobbyView().getView());

     /*  addViewFactory(COMMENTS_VIEW, () -> {
           return (View) new CommentsView().getView();
       });*/

       // addViewFactory(EDITION_VIEW, () -> (View) new EditionView().getView());
       // addLayerFactory(MENU_LAYER, () -> new SidePopupView(new DrawerManager().getDrawer()));

    }

    int initialX;
    int initialY;

    @Override
    public void postInit(Scene scene) {
        Swatch.AMBER.assignTo(scene);
       // LOG.log(Level.INFO, "Platform isDesktop: " + Platform.isDesktop());

        if (Platform.isIOS()) {
             scene.getWindow().setWidth(1000);
            scene.getWindow().setHeight(800);
           // stage.setFullScreen(true);
            AppBar appBar = MobileApplication.getInstance().getAppBar();
            appBar.setVisible(false);
            //setStageDrag(scene);
        }

        //  scene.getStylesheets().add(GluonApplication1.class.getResource("/com/gluonapplication1/style.css").toExternalForm());
        //  ((Stage) scene.getWindow()).getIcons().add(new Image(GluonApplication1.class.getResourceAsStream("/icon.png")));
        //   ((Stage) scene.getWindow()).getIcons().add(new Image(GluonApplication1.class.getResourceAsStream("/icon.png")));
    }

    private void setStageDrag(Scene scene) {
        Stage stage = (Stage) scene.getWindow();

        int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
        int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

        // Responsive Design
        int sceneWidth = 0;
        int sceneHeight = 0;

        if (screenWidth <= 800 && screenHeight <= 600) {
            sceneWidth = 600;
            sceneHeight = 350;
        } else if (screenWidth <= 1280 && screenHeight <= 768) {
            sceneWidth = 800;
            sceneHeight = 450;
        } else if (screenWidth <= 1920 && screenHeight <= 1080) {
            sceneWidth = 1000;
            sceneHeight = 650;
        }

        // Scene
        stage.initStyle(StageStyle.TRANSPARENT);
        //  scene = new Scene(root, sceneWidth, sceneHeight, Color.TRANSPARENT);


        // Moving
        scene.setOnMousePressed(m1 -> {
            if (m1.getButton() == MouseButton.PRIMARY) {
                scene.setCursor(Cursor.MOVE);
                initialX = (int) (stage.getX() - m1.getScreenX());
                initialY = (int) (stage.getY() - m1.getScreenY());
            }
        });

        scene.setOnMouseDragged(m2 -> {
            if (m2.getButton() == MouseButton.PRIMARY) {
                stage.setX(m2.getScreenX() + initialX);
                stage.setY(m2.getScreenY() + initialY);
            }
        });

        scene.setOnMouseReleased(m3 -> {
            scene.setCursor(Cursor.DEFAULT);
        });
    }

}
