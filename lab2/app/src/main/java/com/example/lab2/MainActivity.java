package com.example.lab2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity
{
    private ImageSwitcher sw;
    private Button pr, nx, ok;
    int position = 2;
    private int[] arr = { R.drawable.cat1, R.drawable.cat2,
            R.drawable.cat3, R.drawable.cat4, R.drawable.cat5 };
    private EditText edtEditText;
    private TextView tvTextView;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        sw = (ImageSwitcher) findViewById((R.id.img));
        edtEditText = (EditText) findViewById((R.id.edtEditText));
        tvTextView = (TextView) findViewById((R.id.tvTextView));
        pr = (Button) findViewById((R.id.pr));
        nx = (Button) findViewById((R.id.nx));
        ok = (Button) findViewById((R.id.ok));
        sw.setFactory(new ViewSwitcher.ViewFactory()
        {
            @Override
            public View makeView()
            {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });
        pr.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setPositionPrev();
                sw.setImageResource(arr[position]);
                edtEditText.setVisibility(View.VISIBLE);
                ok.setVisibility(View.VISIBLE);
                tvTextView.setVisibility(View.INVISIBLE);
                edtEditText.setText("");
            }

        });

        nx.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setPositionNext();
                sw.setImageResource(arr[position]);
                edtEditText.setVisibility(View.VISIBLE);
                ok.setVisibility(View.VISIBLE);
                tvTextView.setVisibility(View.INVISIBLE);
                edtEditText.setText("");
            }

        });

        ok.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                content = edtEditText.getText().toString();
                tvTextView.setVisibility(View.VISIBLE);
                tvTextView.setText(content);
            }

        });

    }

    private void setPositionNext()
    {
        position++;
        if (position > arr.length - 1) {
            position = 0;
        }
    }

    public void setPositionPrev() {
        position--;
        if (position < 0) {
            position = arr.length - 1;
        }
    }
}