package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    RadioButton A, B, C, D, E;
    Button btn;
    int position = -1, res = 0;
    Fragment1 txt;
    TextView tx;
    ImageView img1, img2, img3;

    String[] questions = new String[]
            {
                    "Мне хочется, чтобы мои друзья подбадривали меня.",
                    "Я боюсь выглядеть глупцом.",
                    "Я беспокоюсь за свое будущее.",
                    "Внешний вид других куда лучше, чем мой.",
                    "Как жаль, что многие не понимают меня.",
                    "Чувствую, что я не умею как следует разговаривать с людьми.",
                    "Люди ждут от меня очень многого.",
                    "Чувствую себя скованным.",
                    "Мне кажется, что со мной должна случиться какая-то неприятность.",
                    "Меня волнует мысль о том, как люди относятся ко мне.",
                    "Я чувствую, что люди говорят про меня за моей спиной.",
                    "Я чувствую себя в безопасности.",
                    "Мне не с кем поделиться своими мыслями.",
                    "Люди не особенно интересуются моими достижениями.",
                    ""
            };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_2, container, false);
        A = (RadioButton) v.findViewById(R.id.A);
        B = (RadioButton) v.findViewById(R.id.B);
        C = (RadioButton) v.findViewById(R.id.C);
        D = (RadioButton) v.findViewById(R.id.D);
        E = (RadioButton) v.findViewById(R.id.E);
        btn = (Button) v.findViewById(R.id.btn);
        img1 = (ImageView) v.findViewById(R.id.img1);
        img2 = (ImageView) v.findViewById(R.id.img2);
        img3 = (ImageView) v.findViewById(R.id.img3);
        tx = (TextView) v.findViewById(R.id.tx2);
        final Fragment1 txt = (Fragment1) getFragmentManager().findFragmentById(R.id.fragment1);

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                res += 4;
                txt.change(questions[position]);
                A.setChecked(false);
                if (position >= 14) {
                    A.setVisibility(View.INVISIBLE);
                    B.setVisibility(View.INVISIBLE);
                    C.setVisibility(View.INVISIBLE);
                    D.setVisibility(View.INVISIBLE);
                    E.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    txt.change("");
                }
            }
        });

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                res += 3;
                txt.change(questions[position]);
                B.setChecked(false);
                if (position >= 14) {
                    A.setVisibility(View.INVISIBLE);
                    B.setVisibility(View.INVISIBLE);
                    C.setVisibility(View.INVISIBLE);
                    D.setVisibility(View.INVISIBLE);
                    E.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    txt.change("");
                }
            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                res += 2;
                txt.change(questions[position]);
                C.setChecked(false);
                if (position >= 14) {
                    A.setVisibility(View.INVISIBLE);
                    B.setVisibility(View.INVISIBLE);
                    C.setVisibility(View.INVISIBLE);
                    D.setVisibility(View.INVISIBLE);
                    E.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    txt.change("");
                }
            }
        });

        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                res++;
                txt.change(questions[position]);
                D.setChecked(false);
                if (position >= 14) {
                    A.setVisibility(View.INVISIBLE);
                    B.setVisibility(View.INVISIBLE);
                    C.setVisibility(View.INVISIBLE);
                    D.setVisibility(View.INVISIBLE);
                    E.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    txt.change("");
                }
            }
        });

        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                txt.change(questions[position]);
                E.setChecked(false);
                if (position >= 14) {
                    A.setVisibility(View.INVISIBLE);
                    B.setVisibility(View.INVISIBLE);
                    C.setVisibility(View.INVISIBLE);
                    D.setVisibility(View.INVISIBLE);
                    E.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    txt.change("");
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                btn.setVisibility(View.INVISIBLE);
                if(res < 10)
                {
                    img1.setVisibility(View.VISIBLE);
                    tx.setVisibility(View.VISIBLE);
                    tx.setText("Вам надо избавляться от чувства превосходства над\n" +
                            "окружающими, зазнайства, хвастовства. Возьмите за правило принципы: \n" +
                            "всякая конфликтная ситуация возникла из искры, которую вы высекли сами\n" +
                            "или помогли разжечь.");
                }
                else if(res > 30)
                {
                    img2.setVisibility(View.VISIBLE);
                    tx.setVisibility(View.VISIBLE);
                    tx.setText("Вы себя недооцениваете. Скромность, конечно, украшает,\n"+
                            "но излишне робкое поведение служит доказательством заниженной самооценки.");
                }
                else if(res >= 10 && res <= 30)
                {
                    img3.setVisibility(View.VISIBLE);
                    tx.setVisibility(View.VISIBLE);
                    tx.setText("Ваш результат свидетельствует о\n" +
                            "психологической зрелости, которая проявляется прежде всего в адекватности\n" +
                            "самоотражения, то есть реалистической оценке своих сил, возможностей,\n" +
                            "внешности. Вам по плечу серьезные дела. Дерзайте.\n");
                }

            }
        });

        return v;
    }

}