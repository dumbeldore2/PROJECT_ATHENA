package com.example.project_athena;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //textviews initen
    TextView textView1;

    //aangeklikt bool
    boolean aangeklikt;

    //image initen
    ImageView imageView1;

    //animatie initen
    Animation animation;
    AnimationDrawable animationDrawable;

    //constraint layout initen voor background
    ConstraintLayout constraintLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(Color.TRANSPARENT);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        //texviews connecten
        textView1 = findViewById(R.id.text1);

        //aangeklikt waarde geven
        aangeklikt = false;

        //imagevieuws conecteren
        imageView1 = findViewById(R.id.image1);

        //constraint layout connecteren
        constraintLayout = findViewById(R.id.constraintLayout1);

        //gradiant op text toevoegen
        setColorToGradiant(textView1);

        //functies
        background_ani();
        click1();
        click2();
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

    //fun voor aankliken van text1
    public void click1(){
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aangeklikt = true;
            }
        });
    }

    public void click2(){
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ani_fun_1();
            }
        });
    }

    public void ani_fun_1(){
        if (aangeklikt){
            animation = AnimationUtils.loadAnimation(this,R.anim.rotate);
            imageView1.startAnimation(animation);
        }
    }

    public void background_ani(){

        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
    }
}