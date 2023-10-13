package com.example.twouprework;

import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class CoinAnimation {

    public void animateCoin(ImageView coin, int result, Runnable onFinish) {
        RotateTransition rt = new RotateTransition(Duration.seconds(1), coin);
        rt.setByAngle(360);
        rt.setOnFinished(e -> onFinish.run());
        rt.play();
    }
}
