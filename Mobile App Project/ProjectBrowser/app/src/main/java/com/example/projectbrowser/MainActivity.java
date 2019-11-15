package com.example.projectbrowser;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.URLUtil;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    WebView myWebView;
    ArrayList<String> historyList;
    ArrayList<String> addBookMarkList;
    //=new ArrayList<String>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    // for url validation
    public static boolean checkURL(CharSequence input) {
        if (TextUtils.isEmpty(input)) {
            return false;
        }
        Pattern URL_PATTERN = Patterns.WEB_URL;
        boolean isURL = URL_PATTERN.matcher(input).matches();
        if (!isURL) {
            String urlString = input + "";
            if (URLUtil.isNetworkUrl(urlString)) {
                try {
                    new URL(urlString);
                    isURL = true;
                } catch (Exception e) {
                }
            }
        }
        return isURL;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        switch(item.getItemId())
        {
            case(R.id.menugoback):
                {
                    goBackWithToast();

                break;
                }
            case(R.id.menuForward):
            {
                goForwardEithToast();

            }
            case(R.id.menuReload):
            {
                myWebView.reload();
                break;
            }
            case(R.id.action_settings):
            {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            }
            case(R.id.menuExit):
            {
                finish();
                break;
            }
            case(R.id.menuAddbookmark):
                {
                    WebView myWebView = (WebView) findViewById(R.id.webview);
                    String addUrl = myWebView.getUrl();
                    addBookMarkList.add(addUrl);
                    break;
                }
            case(R.id.menuListBookMarks):
            {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                Bundle b = new Bundle();
                saveArrayListBookMark();
                b.putStringArrayList("listKey",addBookMarkList);
                intent.putExtras(b);
                startActivity(intent);
                break;

            }
            case(R.id.menuHistory):
            {
                WebBackForwardList currentList = myWebView.copyBackForwardList();
                int currentSize = currentList.getSize();
                for(int i = 0; i < currentSize; ++i)
                {
                    WebHistoryItem item1 = currentList.getItemAtIndex(i);
                    String url = item1.getUrl();
                    historyList.add(url); // add to arraylist
                    Log.d("SearchHistory", "The URL at index: " + Integer.toString(i) + " is " + url );
                }
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                Bundle b = new Bundle();
                saveArrayListHistory();

                b.putStringArrayList("listKey",historyList);
//                for(int i=0;i<historyList.size();i++)
//                {
//                    String histItem= historyList.get(i);
//                    String keyItem="key"+i;
//                    b.putString(keyItem, histItem);
//                }
                intent.putExtras(b);
                startActivity(intent);
                break;

            }
            case(R.id.goButton):
            {
                WebView myWebView = (WebView) findViewById(R.id.webview);
                SearchView searchItem = (SearchView)findViewById(R.id.app_bar_search);
                String urlAddress=searchItem.getQuery().toString();
                //check with url validation
                if (checkURL(urlAddress)) {
                    if(urlAddress.startsWith("http://www.")) {
                        myWebView.loadUrl(urlAddress);
                        handleErrorPage(myWebView);
                    }
                    else if(urlAddress.startsWith("www."))
                    {
                        urlAddress="http://"+urlAddress;
                        myWebView.loadUrl(urlAddress);
                        handleErrorPage(myWebView);
                    }
                    else
                    {
                        urlAddress="http://www."+urlAddress;
                        myWebView.loadUrl(urlAddress);
                        handleErrorPage(myWebView);

                    }
                }else{
                    String urlText= "https://www.google.com/search?q=" + urlAddress;
                    myWebView.loadUrl(urlText);
                    handleErrorPage(myWebView);

                }

            }
            break;

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //load shared preferences
        getArrayListHistory();
        getArrayListBookMark();

        // refresh
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                myWebView.reload();

            }
        });
        //setTitle("Rainbow Search Browser");

        Button btn = (Button) findViewById(R.id.buttonGo);
        Button btnBack = (Button) findViewById(R.id.btnBack);
      //  Button btnReload = (Button) findViewById(R.id.btnReload);
        Button btnForward = (Button) findViewById(R.id.btnForward);


        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new MyWebViewClient());

        // btn.setOnClickListener(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView myWebView = (WebView) findViewById(R.id.webview);
                EditText edittxt = (EditText) findViewById(R.id.inputText1);
                String urlAddress=edittxt.getText().toString();
                //check with url validation
                if (checkURL(urlAddress)) {
                    if(urlAddress.startsWith("http://www."))
                    {
                        myWebView.loadUrl(urlAddress);
                        handleErrorPage(myWebView);
                    }

                    else if(urlAddress.startsWith("www."))
                    {
                        urlAddress="http://"+urlAddress;
                        myWebView.loadUrl(urlAddress);
                        handleErrorPage(myWebView);
                    }
                    else
                    {
                        urlAddress="http://www."+urlAddress;
                        myWebView.loadUrl(urlAddress);
                        handleErrorPage(myWebView);

                    }
                }else{
                    String urlText= "https://www.google.com/search?q=" + urlAddress;
                    myWebView.loadUrl(urlText);
                    handleErrorPage(myWebView);
                }

                //myWebView.loadUrl(urlAddress);
                //  myWebView.loadUrl("http://www.Google.com");
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                myWebView.goBack();
                goBackWithToast();
            }
        });
        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goForwardEithToast();
//                myWebView.goForward();
            }
        });
//        btnReload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myWebView.reload();
//            }
//        });
       //
    }
    public void goBackWithToast()
    {

        if(myWebView.canGoBack())
        {
            myWebView.goBack();
        }
        else
        {
            Toast.makeText(this,"Can't go back!",Toast.LENGTH_LONG).show();
        }
    }

    public void  goForwardEithToast(){
        if(myWebView.canGoForward())
        {
            myWebView.goForward();
        }
        else
        {
            Toast.makeText(this,"Can't go further!",Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

    // handle error message
    public void handleErrorPage(WebView myWebView)
    {
        myWebView.setWebViewClient(new WebViewClient() {
            @Override public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                WebView myWebView = (WebView) findViewById(R.id.webview);
                myWebView.loadUrl("https://www.google.com");
               // myWebView.loadUrl("file:///android_assets/manageErrorPage.html");
            } });

    }

    public void saveArrayListHistory(){
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(historyList);
        editor.putString("Savekey", json);
        editor.apply();

    }

    public void getArrayListHistory(){
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("Savekey", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        historyList=gson.fromJson(json, type);

        if(historyList==null)
        {
            historyList=new ArrayList<String>();
        }
    }

    public void saveArrayListBookMark(){
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPrefA", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(addBookMarkList);
        editor.putString("Savekey", json);
        editor.apply();

    }

    public void getArrayListBookMark(){
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPrefA", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("Savekey", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        addBookMarkList=gson.fromJson(json, type);
        if(addBookMarkList==null)
        {
            addBookMarkList=new ArrayList<String>();
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("MobileApp", "onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
      // loadSharedValue();
        Log.d("MobileApp", "onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("MobileApp", "onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("MobileApp", "onStop");
     }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("MobileApp", "onDestroy");
    }
     private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.equals(Uri.parse(url).getHost())) {
                // This is my website, so do not override; let my WebView load the page
                return false;
            }
            // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
//             Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//             startActivity(intent);
            return false;
        }

    }


}












// Refreances

//https://developer.android.com/training/basics/firstapp/starting-activity
//https://stackoverflow.com/questions/6392318/detecting-webview-error-and-show-message
//https://developer.android.com/guide/topics/ui/floating-action-button
//https://stackoverflow.com/questions/21585326/implementing-searchview-in-action-bar
//https://coderwall.com/p/zpwrsg/add-search-function-to-list-view-in-android
//https://stackoverflow.com/questions/7057845/save-arraylist-to-sharedpreferences
//https://www.tutorialspoint.com/how-to-save-arraylist-to-sharedpreferences-on-android
//http://www.androiddocs.com/training/basics/firstapp/starting-activity.html
//https://stackoverflow.com/questions/19365668/getting-webview-history-from-webbackforwardlist
