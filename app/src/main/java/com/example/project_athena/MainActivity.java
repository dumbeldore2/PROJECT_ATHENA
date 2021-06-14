package com.example.project_athena;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //textviews initen
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //texviews connecten
        textView1 = findViewById(R.id.text1);

        //gradiant op text toevoegen
        setColorToGradiant(textView1);
    }

    //deze code zorgt ervoor dat een textview gekleurd kan worden
    private void setColorToGradiant(TextView textView){
        TextPaint textPaint = textView.getPaint();
        float width = textPaint.measureText(textView.getText().toString());

        Shader shader = new LinearGradient(width/2,0,width/2,textView.getTextSize(),
                new int[]{
                        Color.parseColor("#48BF92"),
                        Color.parseColor("#108072")
                },null,Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);
    }

}