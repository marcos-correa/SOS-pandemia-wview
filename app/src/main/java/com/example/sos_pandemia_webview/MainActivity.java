package com.example.sos_pandemia_webview;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView wv = findViewById(R.id.webview);
        wv.loadUrl("https://sospandemia.org/"); //Acesso URL AQUI
        wv.setWebViewClient(new WebViewClient()); //Novo WebViewClient
        wv.getSettings().setJavaScriptEnabled(true); //Habilitando Javascript
        wv.getSettings().setDomStorageEnabled(true); //Resolvendo o problema da primeira página em branco.

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView wv = findViewById(R.id.webview);

        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()) {
            wv.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
