package com.example.twouprework;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TwoUpGame extends Application {
    private ImageView coin1;
    private ImageView coin2;
    private Text resultText;
    private GameMechanics gameMechanics = new GameMechanics();
    private CoinAnimation coinAnimation = new CoinAnimation();

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        coin1 = new ImageView(new Image(getClass().getResourceAsStream("/coin_head.png")));
        coin2 = new ImageView(new Image(getClass().getResourceAsStream("/coin_head.png")));

        Button flipButton = new Button("Flip Coins");
        flipButton.setOnAction(e -> flipCoins());

        resultText = new Text("Bet for Heads-Heads or Tails-Tails and flip the coins");

        root.getChildren().addAll(coin1, coin2, flipButton, resultText);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Two-up Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void flipCoins() {
        int result1 = gameMechanics.flipCoin();
        int result2 = gameMechanics.flipCoin();

        coinAnimation.animateCoin(coin1, result1, () -> {
            coin1.setImage(new Image(result1 == 0 ? "coin_head.png" : "tails_coin.png"));
        });

        coinAnimation.animateCoin(coin2, result2, () -> {
            coin2.setImage(new Image(result2 == 0 ? "coin_head.png" : "tails_coin.png"));
        });

        resultText.setText(gameMechanics.getResultText(result1, result2));

    }
    public  static void main(String[] args) {
        launch(args);
    }
}
