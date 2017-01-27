/**
 * Copyright (c) 2016, Gluon
 * All rights reserved.
 * <p>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * * Neither the name of Gluon, any associated website, nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * <p>
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL GLUON BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.gluonapplication1.views;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class LobbyPresenter implements Initializable{


    //  @Inject
    /// private ServiceFake service1;

    @FXML
    View lobby;
   // @FXML
    // StackPane pane;



    public void initialize() {


        //service1.retrieveComments();

        //  String workingDir = System.getProperty("user.dir");
        //  final File f = new File(workingDir, "/raw/loop_1.mp4");

        //  final Media m = new Media(f.toURI().toString());

        Media m = null;
        try {
            m = new Media(getClass().getResource("/raw/loop_1.mp4").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        final MediaPlayer mp = new MediaPlayer(m);
        final MediaView mv = new MediaView(mp);

        final DoubleProperty width = mv.fitWidthProperty();
        final DoubleProperty height = mv.fitHeightProperty();


      //  width.set(m.getWidth());
      //  height.set(m.getHeight());

       // width.set(600);
        // height.set(600);
         width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));

        //mv.setPreserveRatio(true);
        lobby.getChildren().add(lobby.getChildren().size()-1, mv);
        mv.getMediaPlayer().setAutoPlay(true);
        mv.getMediaPlayer().play();

    }

    @FXML
    public void onCancel(ActionEvent actionEvent) {

    }

    @FXML
    public void onSubmit(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

   /* @Override
    protected void updateAppBar(AppBar appBar) {

    }
*/


}
