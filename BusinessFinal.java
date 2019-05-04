/************************************************************************
//  Filename: BusinessFinal.java        Author: Snubiss
//  Application Name: Business Final Exam Prep App
//  Version: V2
//  
//  Date: April 18, 2019
//  Modified: April 18, 2019
//
//  The Purpose:
//   The purpose of this application is to help study for the principles of
//   management final exam.
//
//   
//  Required Input Variables: 
//
//   Intellect
//   Mouse
//   Keyboard
//   Knowledge
//
//***********************************************************************/


package businessfinal;

import java.util.Collection;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BusinessFinal extends Application {
    
    int question = 0;
    BorderPane root = new BorderPane();
    VBox mainBox;
    TextField aField;
    Button aButton = new Button();
    int score = 0;
    int questionChoose = 0;
    String temp = "";
    int logicSwitch = 0;
    Timeline logicLoop;
    Label dialogue = new Label("k");
    Label scoreLabel;
    final int MAXSCORE = 200;
    final int PENALTY = 5;
    final int REWARD = 10;
    int questionStart = 1;
    int questionEnd = 3;
    final int MAXQUESTIONS = 85;
    final Questions QUESTIONS = new Questions();
    
    
    private static int rng(int minnum, int maxnum){
        int randomnumber = (int)(Math.random()*(maxnum+1-minnum))+ minnum;
    return randomnumber;   
    }
    
    
    public VBox getSelectionScreen(){
        
        logicSwitch = 0;
        VBox selectionBox = new VBox();
        selectionBox.setStyle("-fx-background-color: #DfDfDf;" +
                              "-fx-border-color: BLACK;" +
                              "-fx-border-width: 1;" +
                              "-fx-border-radius: 5 5 5 5;" +
                              "-fx-background-radius: 5 5 5 5;" +
                              "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        selectionBox.setAlignment(Pos.CENTER);
        selectionBox.setMaxSize(500, 570);
        selectionBox.setMinSize(500, 570);
        selectionBox.setSpacing(30);
        
         
        Label text = new Label();
        text.setFont(new Font(20));
        text.setAlignment(Pos.CENTER);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setText("Input the Questions you would like:\nChapter 14: Input 1-26\nChapter 15: Input 27-48\nChapter 16: Input 49-73\nBonus Q's: Input 74-85");
        text.setWrapText(true);
        
        HBox tfieldBox = new HBox();
        tfieldBox.setAlignment(Pos.CENTER);
        
        TextField t1 = new TextField();
        t1.setMaxSize(80, 40);
        t1.setMinSize(80, 40);
        t1.setAlignment(Pos.CENTER);
        t1.setFont(new Font(18));
        Text spacer = new Text();
        spacer.setText("---");
        TextField t2 = new TextField();
        t2.setMaxSize(80, 40);
        t2.setMinSize(80, 40);
        t2.setAlignment(Pos.CENTER);
        t2.setFont(new Font(18));
        
        tfieldBox.getChildren().addAll(t1, spacer, t2);
        tfieldBox.setSpacing(20);
        
        
        Button startButton = new Button();
        startButton.setOnAction(e -> {
            
            
            try{
            if (Integer.parseInt(t1.getText()) <= 0){
                t1.setText("1");
            }
            if (Integer.parseInt(t1.getText()) > MAXQUESTIONS){
                t1.setText(String.valueOf(MAXQUESTIONS));
            }
            if (Integer.parseInt(t2.getText()) <= 0){
                t2.setText("1");
            }
            if (Integer.parseInt(t2.getText()) > MAXQUESTIONS){
                t2.setText(String.valueOf(MAXQUESTIONS));
            }
            questionStart = Integer.parseInt(t1.getText());
            questionEnd = Integer.parseInt(t2.getText());
            
            logicSwitch = 2;
            //System.out.println(logicSwitch);
            score = 0;
            }
            catch(NumberFormatException ex){
                
            }
        });
        
        startButton.setMaxSize(150, 75);
        startButton.setMinSize(150, 75);
        startButton.setFont(new Font(20));
        startButton.setText("Start");
        
        
        
        Button exit = new Button();
        exit.setMaxSize(150, 75);
        exit.setMinSize(150, 75);
        exit.setFont(new Font(20));
        exit.setText("QUIT");
        
        exit.setOnAction(e-> {
            
            System.exit(0);
        });
        selectionBox.getChildren().addAll(text, tfieldBox, startButton, exit);
    return selectionBox;
    }
    
    
    public VBox getVictory(){
        
        logicSwitch = 0;
        VBox victoryBox = new VBox();
        victoryBox.setStyle("-fx-background-color: limegreen;" +
                            "-fx-border-color: BLACK;" +
                            "-fx-border-width: 1;" +
                            "-fx-border-radius: 5 5 5 5;" +
                            "-fx-background-radius: 5 5 5 5;" +
                            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        victoryBox.setAlignment(Pos.CENTER);
        victoryBox.setMaxSize(500, 470);
        victoryBox.setMinSize(500, 470);
        victoryBox.setSpacing(30);
        
         
        Label text = new Label();
        text.setFont(new Font(30));
        text.setAlignment(Pos.CENTER);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setText("VICTORY!\n Keep Practicing and you'll ace the exam!");
        text.setWrapText(true);
        
        Button playAgain = new Button();
        playAgain.setOnAction(e -> {
            
            logicSwitch = 2;
            //System.out.println(logicSwitch);
            score = 0;
        });
        
        playAgain.setMaxSize(200, 100);
        playAgain.setMinSize(200, 100);
        playAgain.setFont(new Font(20));
        playAgain.setText("PLAY AGAIN");
        
        
        
        Button exit = new Button();
        exit.setMaxSize(200, 100);
        exit.setMinSize(200, 100);
        exit.setFont(new Font(20));
        exit.setText("QUIT");
        
        exit.setOnAction(e-> {
            
            System.exit(0);
        });
        victoryBox.getChildren().addAll(text, playAgain, exit);
    return victoryBox;
    }
    
    public Label getScoreLabel(){
        scoreLabel = new Label("Score: " + this.score);
        scoreLabel.setMaxSize(140, 60);
        scoreLabel.setMinSize(140, 60);
        scoreLabel.setFont(new Font(24));
        scoreLabel.setTextFill(Color.PURPLE);
    return scoreLabel;    
    }
    
    
    
    public Button getAnswerButton(){
        
        aButton = new Button();
        aButton.setMaxSize(100, 50);
        aButton.setMinSize(100, 50);
        aButton.setFont(new Font(20));
        aButton.setText("Answer");
        
        aButton.setOnAction(e->{
            
            
            temp = aField.getText();
            dialogue.setFont(new Font(21));
            dialogue.setWrapText(true);
            dialogue.setTextAlignment(TextAlignment.CENTER);
            dialogue.setTextFill(Color.PURPLE);
            
            temp.trim();
            if (logicSwitch == 1){
                
                logicSwitch = 2;
                return;
            }
            
            // Cut the Answer to size if to long
            String tempy = QUESTIONS.giveMe(questionChoose, 'A');
            String holder = "";
                
            if (tempy.length() > 60){
                holder = tempy.substring(60,tempy.length());
                tempy = tempy.substring(0, 60);
            }
                
                
            if (temp.equalsIgnoreCase(QUESTIONS.giveMe(questionChoose, 'A'))){
                
                
                
                score += REWARD;
                dialogue.setText("Excellent Work! +10 Points!\nYou Answered:\n" + temp + "\nThe Correct Answer Was: \n" + tempy + "\n" + holder);
                aButton.setText("Next");
                mainBox.getChildren().remove(2);
                logicSwitch = 1;
                
            }
            else{
                
                score -= PENALTY;
                dialogue.setText("Sorry, Wrong Answer. -5 Points!\nYou Answered:\n" + temp + "\nThe Correct Answer Was: \n" + tempy + "\n" + holder);
                aButton.setText("Next");
                mainBox.getChildren().remove(2);
                logicSwitch = 1;
            }
            scoreLabel.setText("Score: " + this.score);
            logicSwitch = 1;
        });
    return aButton;
    }
    
    public HBox answerBox() {
        HBox aBox = new HBox();
        aBox.setAlignment(Pos.CENTER);
        
        aField = new TextField();
        aField.setMaxSize(500, 50);
        aField.setMinSize(500, 50);
        Tooltip t = new Tooltip();
        t.setText("Type the answer exactly. Use commas for multiple answers.");
        aField.setTooltip(t);
        aField.setFont(new Font(24));
        aField.setOnAction(e->{
            
            temp = aField.getText();
            dialogue.setFont(new Font(21));
            dialogue.setWrapText(true);
            dialogue.setTextAlignment(TextAlignment.CENTER);
            dialogue.setTextFill(Color.PURPLE);
            
            
            temp.trim();
            if (logicSwitch == 1){
                
                logicSwitch = 2;
                return;
            }
            
            String tempy = QUESTIONS.giveMe(questionChoose, 'A').trim();
            String holder = "";
                
            if (tempy.length() > 60){
                holder = tempy.substring(60,tempy.length());
                tempy = tempy.substring(0, 60);
            }
            
            if (temp.equalsIgnoreCase(QUESTIONS.giveMe(questionChoose, 'A').toUpperCase())){
                
                score += REWARD;
                dialogue.setText("Excellent Work! +10 Points!\nYou Answered:\n" + temp + "\nThe Correct Answer Was: \n" + tempy + "\n" + holder);
                aButton.setText("Next");
                mainBox.getChildren().remove(2);
                logicSwitch = 1;
                
            }
            else{
                
                score -= PENALTY;
                dialogue.setText("Sorry, Wrong Answer. -5 Points!\nYou Answered:\n" + temp + "\nThe Correct Answer Was: \n" + tempy + "\n" + holder);
                aButton.setText("Next");
                mainBox.getChildren().remove(2);
                logicSwitch = 1;
            }
            scoreLabel.setText("Score: " + this.score);
            logicSwitch = 1;
        });
        
        
        aBox.setSpacing(20);
        aBox.getChildren().addAll(aField);
        
    return aBox;
    }
    
    public HBox questionBox(){
        
        HBox qBox = new HBox();
        //qBox.setStyle("-fx-background-color: green;");
        qBox.setMaxSize(500, 270);
        qBox.setMinSize(500, 270);
        
        Label newLabel = new Label();
        newLabel.setAlignment(Pos.CENTER);
        newLabel.setFont(new Font(22));
        newLabel.setTextFill(Color.BLACK);
        newLabel.setStyle("-fx-accent: white;");
        newLabel.setWrapText(true);
        
        
        
        newLabel.setText(QUESTIONS.giveMe(questionChoose,'Q'));
        qBox.getChildren().add(newLabel);
    return qBox;
    }
    
    public VBox getMainBox(Scene pane){
       
        mainBox = new VBox();
        mainBox.setStyle("-fx-background-color: #DfDfDf;" +
                        "-fx-border-color: BLACK;" +
                        "-fx-border-width: 1;" +
                        "-fx-border-radius: 5 5 5 5;" +
                        "-fx-background-radius: 5 5 5 5;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        mainBox.setPrefSize(600, 700);
        mainBox.setMinSize(600,700);
        mainBox.setMaxSize(600,700);
        mainBox.setSpacing(40);
        
        dialogue.setText("");
        questionChoose = rng(questionStart,questionEnd); 
        
        mainBox.getChildren().addAll(getScoreLabel(), questionBox(), answerBox(), dialogue, getAnswerButton());
        mainBox.setAlignment(Pos.CENTER);
    return mainBox;
    
    }
    @Override
    public void start(Stage primaryStage) {
        
        
        Scene scene = new Scene(root, 800, 800);
        
        
        root.setCenter(getSelectionScreen());
        
        primaryStage.setTitle("Business Final Questions");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        logicLoop = new Timeline();
        Collection<KeyFrame> keyList = logicLoop.getKeyFrames();
        Duration frameGap = Duration.millis(300);
        Duration frameTime = Duration.millis(200);
        keyList.add(new KeyFrame(frameGap));
        keyList.add(new KeyFrame(frameTime, e -> {
            
            if (logicSwitch == 2){
                root.getChildren().clear();
                root.setCenter(getMainBox(scene));
                logicSwitch = 0;
            }
            
            if (score >= MAXSCORE){
                root.getChildren().clear();
                root.setCenter(getVictory());
            }
        }));
        
        
        logicLoop.setCycleCount(Animation.INDEFINITE);
        logicLoop.play();
        
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
