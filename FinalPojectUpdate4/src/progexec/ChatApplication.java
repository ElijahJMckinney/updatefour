package progexec;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ChatApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Login Screen
        VBox loginScreen = new VBox(10);
        loginScreen.setPadding(new Insets(10));

        Label lblUsername = new Label("Username:");
        TextField tfUsername = new TextField();
        Label lblStatus = new Label("Status:");
        TextField tfStatus = new TextField();
        Button btnLogin = new Button("Login");

        loginScreen.getChildren().addAll(lblUsername, tfUsername, lblStatus, tfStatus, btnLogin);

        // Chat Room Screen
        VBox chatScreen = new VBox(10);
        chatScreen.setPadding(new Insets(10));
        Label lblParticipants = new Label("Participants:");
        ListView<String> participantsList = new ListView<>();
        Label lblMessages = new Label("Chat Messages:");
        TextArea messagesArea = new TextArea();
        messagesArea.setEditable(false);
        messagesArea.setWrapText(true);
        TextField tfMessageInput = new TextField();
        Button btnSend = new Button("Send");

        chatScreen.getChildren().addAll(lblParticipants, participantsList, lblMessages, messagesArea, tfMessageInput, btnSend);

        // Navigation between screens
        Scene loginScene = new Scene(loginScreen, 400, 300);
        Scene chatScene = new Scene(chatScreen, 600, 400);

        btnLogin.setOnAction(e -> primaryStage.setScene(chatScene));

        // Sample event for sending messages
        btnSend.setOnAction(e -> {
            String message = tfMessageInput.getText();
            if (!message.isEmpty()) {
                messagesArea.appendText("You: " + message + "\n");
                tfMessageInput.clear();
            }
        });

        // Stage setup
        primaryStage.setTitle("Chat Application");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
