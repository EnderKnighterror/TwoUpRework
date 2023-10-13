package com.example.twouprework;

import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.scene.PointLight;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class CoinAnimation {

    private final PhongMaterial headMaterial = new PhongMaterial();
    private final PhongMaterial tailMaterial = new PhongMaterial();

    public CoinAnimation(Image headImage, Image tailImage) {
        headMaterial.setDiffuseMap(headImage);
        tailMaterial.setDiffuseMap(tailImage);
    }

    public Cylinder createCoin() {
        Cylinder coin = new Cylinder(50, 5);
        coin.setMaterial(headMaterial);
        coin.setRotationAxis(Rotate.X_AXIS);
        return coin;
    }

    public void animateCoin(Cylinder coin, int result, Runnable onFinish) {
        RotateTransition rt = new RotateTransition(Duration.seconds(1), coin);
        rt.setByAngle(180 * (result + 1));
        rt.setOnFinished(e -> onFinish.run());
        rt.play();
    }

    public void setCoinSide(Cylinder coin, int result) {
        coin.setMaterial(result == 0 ? headMaterial : tailMaterial);
    }

    public PointLight createLight() {


        PointLight pointLight = new PointLight(Color.WHITE);
        pointLight.setTranslateX(0);
        pointLight.setTranslateY(0);
        pointLight.setTranslateZ(-500);
        return pointLight;
    }
}
