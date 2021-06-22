package com.example.intentimplicitsion;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText mWebsiteEditText;
	  EditText mLocationEditText;
	  EditText mShareTextEditText;
	  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText = (EditText) findViewById(R.id.edittext1);
        mLocationEditText = (EditText) findViewById(R.id.edittext2);
        mShareTextEditText = (EditText) findViewById(R.id.edittext3);
    }
    public void openWebsite(View view) {
    	String url = mWebsiteEditText.getText().toString();
    	 Uri webpage = Uri.parse(url);
         Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
         if (intent.resolveActivity(getPackageManager()) != null) {
             startActivity(intent);
         } else {
             Log.d("ImplicitIntents", "Can't handle this intent!");
         }
    }
    public void openLocation(View view) {
    	String loc = mLocationEditText.getText().toString();
    	Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
        public void shareText(View view) {
            String txt = mShareTextEditText.getText().toString();
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Share this text with: ")
                    .setText(txt)
                    .startChooser();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
} 
 



   
