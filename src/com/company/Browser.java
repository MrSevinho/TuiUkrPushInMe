package com.company;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;



public class Browser extends JFXPanel {
    private WebView webView;
    private WebEngine webEngine;
    private String path;
    public Browser(String path) {
        this.path = path;
        Platform.runLater(() -> {
            initialiseJavaFXScene();
        });
    }


    private void initialiseJavaFXScene() {
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.setJavaScriptEnabled(true);
        System.out.println(path);
        webEngine.load("file:///D:/TUI2/WeLoveJava-Rofl/htdocs/index.html");
        //www.lit-tui.rf.gd
        Scene scene = new Scene(webView);
        //scene.getStylesheets().add("style.css");
        setScene(scene);
    }
}