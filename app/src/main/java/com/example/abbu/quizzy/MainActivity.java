package com.example.abbu.quizzy;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SignalStrength;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button o1,o2,o3,o4;
    TextView question,timetext;
    int total=0,correct=0,wrong=0;
    DatabaseReference firebaseDatabase;
    bean ques;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        o1=findViewById(R.id.option1);
        o2=findViewById(R.id.option2);
        o3=findViewById(R.id.option3);
        o4=findViewById(R.id.option4);
        question=findViewById(R.id.question);
        timetext=findViewById(R.id.timetext);
        updatequestion();
        /*for (total=1;total<6;total++) {

        }*/
        reversetimer(120,timetext);
    }

    private void updatequestion() {
        total++;
        if(total>5)
        {

            Intent intent=new Intent(getApplicationContext(),abc.class);
            intent.putExtra("Total", String.valueOf(total));
            intent.putExtra("Correct",String.valueOf(correct));
            intent.putExtra("Wrong",String.valueOf(wrong));
            startActivity(intent);
        }

        firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("questions").child(String.valueOf(total));
        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final bean ques = dataSnapshot.getValue(bean.class);
                question.setText(ques.getQuestion());
                o1.setHint(ques.getOption1());
                o2.setHint(ques.getOption2());
                o3.setHint(ques.getOption3());
                o4.setHint(ques.getOption4());
                o1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(o1.getHint().toString().equals(ques.getAnswer()))
                        {
                            o1.setBackgroundColor(Color.GREEN);
                            correct++;
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    correct++;
                                    o1.setBackgroundColor(Color.GREEN);

                                }
                            },300);
                        }
                        else
                        {
                            wrong++;
                            o1.setBackgroundColor(Color.RED);
                            if(o2.getText().toString().equals(ques.getAnswer()))
                                o2.setBackgroundColor(Color.GREEN);
                            if(o3.getText().toString().equals(ques.getAnswer()))
                                o3.setBackgroundColor(Color.GREEN);
                            if(o4.getText().toString().equals(ques.getAnswer()))
                                o4.setBackgroundColor(Color.GREEN);
                        }
                        Handler handler1=new Handler();
                        handler1.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                o1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                o2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                o3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                o4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                updatequestion();

                            }
                        },1000);
                    }
                });
                o2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(o2.getHint().toString().equals(ques.getAnswer()))
                        {
                            o2.setBackgroundColor(Color.GREEN);
                            correct++;
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    correct++;
                                    o2.setBackgroundColor(Color.GREEN);

                                }
                            },300);
                        }
                        else
                        {
                            wrong++;
                            o2.setBackgroundColor(Color.RED);
                            if(o1.getText().toString().equals(ques.getAnswer()))
                                o1.setBackgroundColor(Color.GREEN);
                            if(o3.getText().toString().equals(ques.getAnswer()))
                                o3.setBackgroundColor(Color.GREEN);
                            if(o4.getText().toString().equals(ques.getAnswer()))
                                o4.setBackgroundColor(Color.GREEN);
                        }
                        Handler handler1=new Handler();
                        handler1.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                o1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                o2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                o3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                o4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                updatequestion();
                            }
                        },1000);
                    }
                });
                o3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(o3.getHint().toString().equals(ques.getAnswer()))
                        {
                            o3.setBackgroundColor(Color.GREEN);
                            correct++;
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    correct++;
                                    o3.setBackgroundColor(Color.GREEN);

                                }
                            },300);
                        }
                        else
                        {
                            wrong++;
                            o3.setBackgroundColor(Color.RED);
                            if(o2.getText().toString().equals(ques.getAnswer()))
                                o2.setBackgroundColor(Color.GREEN);
                            if(o1.getText().toString().equals(ques.getAnswer()))
                                o1.setBackgroundColor(Color.GREEN);
                            if(o4.getText().toString().equals(ques.getAnswer()))
                                o4.setBackgroundColor(Color.GREEN);
                        }
                        Handler handler1=new Handler();
                        handler1.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                o1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                o2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                o3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                o4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                updatequestion();
                            }
                        },1000);
                    }
                });
                o4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(o4.getHint().toString().equals(ques.getAnswer()))
                        {
                            o4.setBackgroundColor(Color.GREEN);
                            correct++;
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    correct++;
                                    o4.setBackgroundColor(Color.GREEN);

                                }
                            },300);
                        }
                        else
                        {
                            wrong++;
                            o4.setBackgroundColor(Color.RED);
                            if(o2.getText().toString().equals(ques.getAnswer()))
                                o2.setBackgroundColor(Color.GREEN);
                            if(o3.getText().toString().equals(ques.getAnswer()))
                                o3.setBackgroundColor(Color.GREEN);
                            if(o1.getText().toString().equals(ques.getAnswer()))
                                o1.setBackgroundColor(Color.GREEN);
                        }
                        Handler handler1=new Handler();
                        handler1.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                o1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                o2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                o3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                o4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                updatequestion();
                            }
                        },1000);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


    public void reversetimer(int seconds, final TextView tv)
    {
        new CountDownTimer(seconds*1000+1000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds=(int)(millisUntilFinished)/1000;
                int minutes=(seconds)/60;
                tv.setText(minutes+":"+seconds);
            }

            @Override
            public void onFinish() {
                tv.setText("Time up");

                Intent intent=new Intent(getApplicationContext(),abc.class);
                intent.putExtra("Total", String.valueOf(total));
                intent.putExtra("Correct",String.valueOf(correct));
                intent.putExtra("Wrong",String.valueOf(wrong));
                startActivity(intent);

            }
        }.start();

    }
}
