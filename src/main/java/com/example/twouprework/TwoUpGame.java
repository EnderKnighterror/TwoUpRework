package com.example.twouprework;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TwoUpGame extends Application {
    private Cylinder coin1;
    private Cylinder coin2;
    private Text resultText;
    private GameMechanics gameMechanics = new GameMechanics();
    private CoinAnimation coinAnimation;
    private PointLight pointLight;

    @Override
    public void start(Stage primaryStage) {
        coinAnimation = new CoinAnimation(
                new Image(getClass().getResourceAsStream("/coin_head.png")),
                new Image(getClass().getResourceAsStream("/coin_tail.png"))
        );

        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);

        coin1 = coinAnimation.createCoin();
        coin1.setTranslateX(-60);
        coin1.setTranslateY(0);
        coin1.setTranslateZ(0);
        coin2 = coinAnimation.createCoin();
        coin2.setTranslateX(60);
        coin2.setTranslateY(0);
        coin2.setTranslateZ(0);

        Sphere testSphere = new Sphere(50);
        root.getChildren().add(testSphere);

//        coin1 = new Cylinder(50, 5);
//        coin1.setMaterial(new PhongMaterial(Color.BLUE));

        pointLight = coinAnimation.createLight();

//        Image headImage = new Image(getClass().getResourceAsStream("/coin_head.png"));
//        ImageView imageView1 = new ImageView(headImage);
        AmbientLight ambient = new AmbientLight(Color.WHITE);
        root.getChildren().add(ambient);



        Button flipButton = new Button("Flip Coins");
        flipButton.setOnAction(e -> flipCoins());

        resultText = new Text("Bet for Heads-Heads or Tails-Tails and flip the coins");

        root.getChildren().addAll(coin1, coin2, flipButton, resultText, pointLight);

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-300);

        Scene scene = new Scene(root, 800, 800, true);
        scene.setCamera(camera);
        scene.setFill(Color.GRAY);

        primaryStage.setTitle("Two-up Game");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void flipCoins() {
        int result1 = gameMechanics.flipCoin();
        int result2 = gameMechanics.flipCoin();

        coinAnimation.animateCoin(coin1, result1, () -> {
            coinAnimation.setCoinSide(coin1, result1);
        });

        coinAnimation.animateCoin(coin2, result2, () -> {
            coinAnimation.setCoinSide(coin2, result2);
        });

        resultText.setText(gameMechanics.getResultText(result1, result2));

    }
    public  static void main(String[] args) {
        launch(args);
    }
}
