package com.example.basicprofileapi24;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }

    public void onClickButton(View l_view){
        if (l_view.getId() == R.id.buttonTelephone)
            onTelephoneClick(((Button)l_view).getText().toString());
        else if (l_view.getId() == R.id.buttonWebsite)
            onWebsiteClick(((Button)l_view).getText().toString());
    }

    private void onTelephoneClick(String l_tel){
//        Log.d("Test", "Call phone: " + l_tel);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + l_tel));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void onWebsiteClick(String l_url){
//        Log.d("Test","Browse web: " + l_url);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(l_url));
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

}