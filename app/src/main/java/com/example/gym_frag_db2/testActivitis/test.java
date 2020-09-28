package com.example.gym_frag_db2.testActivitis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gym_frag_db2.Activity.MainActivity;
import com.example.gym_frag_db2.R;
import com.example.gym_frag_db2.program.databas.myDatabaseHelper;
import com.example.gym_frag_db2.program.databas.myDatabaseHelper2;

import java.util.ArrayList;
import java.util.List;

public class test extends AppCompatActivity implements View.OnClickListener {

List<Movtest>list;
    Button button,button2;
EditText editText;


    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
init();



    }

    private void init() {
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button3);
        editText=findViewById(R.id.editText);
        list=new ArrayList<>();
        button.setOnClickListener(this);
button2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        gotomain();
    }
});


    }
    @Override
    public void onClick(View view) {
        String cod= editText.getText().toString();




        if ((editText.getText().toString().length())%6==0){
list.clear();
    char[] s = cutString(cod," ",true).toCharArray();

    for (int i=0;i<s.length;i=i+6){

        list.add(new Movtest(textnum(s[i+0]), textnum(s[i+1]), textnum(s[i+2]), textnum(s[i+3]), textnum(s[i+4]),textnum(s[i+5])) );

    }

//    setDataRecyclerView();
addProgram( cutString(cod," ",false));

    gotomain();


}




    }

    private void gotomain() {

        startActivity(new Intent(test.this, MainActivity.class));

    }

    private int textnum(char o) {
        int number;
        switch (o){

            case '.':{number=0 ;break;}
            case 'a':{number=1 ;break;}
            case 'b':{number=2 ;break;}
            case 'c':{number=3 ;break;}
            case 'd':{number=4 ;break;}
            case 'e':{number=5 ;break;}
            case 'f':{number=6 ;break;}
            case 'g':{number=7 ;break;}
            case 'h':{number=8 ;break;}
            case 'i':{number=9 ;break;}
            case 'j':{number=10;break;}
            case 'k':{number=11;break;}
            case 'l':{number=12;break;}
            case 'm':{number=13;break;}
            case 'n':{number=14;break;}
            case 'o':{number=15;break;}
            case 'p':{number=16;break;}
            case 'q':{number=17;break;}
            case 'r':{number=18;break;}
            case 's':{number=19;break;}
            case 't':{number=20;break;}
            case 'u':{number=21;break;}
            case 'v':{number=22;break;}
            case 'w':{number=23;break;}
            case 'x':{number=24;break;}
            case 'y':{number=25;break;}
            case 'z':{number=26;break;}
            default :{number=0 ;break;}


        }
        return number;


    }

    private void addProgram(String databasname ){
      myDatabaseHelper  db = new myDatabaseHelper (this,databasname);
      myDatabaseHelper2 db2= new myDatabaseHelper2(this);

   db2.insertData(databasname);
   for(int i=0;i<list.size();i++){
       int A=list.get(i).getDay();
       int B=list.get(i).getMov();
       int C=list.get(i).getSubmov();
       int D=list.get(i).getSet();
       int E=list.get(i).getMinmov();
       int F=list.get(i).getMaxmov();
       db.insertData(A,B,C,D,E,F);

       Log.i("kirrr","mov"+String.valueOf(i)+"___"+String.valueOf(A));


   }


}

    private  String cutString(String text,String sign,boolean after){

        String programname="";
        String programcod="";

        for (String retval: text.split(sign, 2)){
            programcod=retval;
        }
        int r =text.length()-programcod.length();



        char[] chartext = text.toCharArray();

        for (int i=0;i<r;i++){

            programname=programname +String.valueOf(chartext[i])  ;

        }
        if (after){return programcod;}
        else      {return programname;}




    }
//    private String numttex(int o) {
//        String text="";
//        switch (o){
//            case 0 :{text=".";break;}
//            case 1 :{text="a";break;}
//            case 2 :{text="b";break;}
//            case 3 :{text="c";break;}
//            case 4 :{text="d";break;}
//            case 5 :{text="e";break;}
//            case 6 :{text="f";break;}
//            case 7 :{text="g";break;}
//            case 8 :{text="h";break;}
//            case 9 :{text="i";break;}
//            case 10:{text="j";break;}
//            case 11:{text="k";break;}
//            case 12:{text="l";break;}
//            case 13:{text="m";break;}
//            case 14:{text="n";break;}
//            case 15:{text="o";break;}
//            case 16:{text="p";break;}
//            case 17:{text="q";break;}
//            case 18:{text="r";break;}
//            case 19:{text="s";break;}
//            case 20:{text="t";break;}
//            case 21:{text="u";break;}
//            case 22:{text="v";break;}
//            case 23:{text="w";break;}
//            case 24:{text="x";break;}
//            case 25:{text="y";break;}
//            case 26:{text="z";break;}
//
//
//
//        }
//        return text;
//
//
//    }

//
//    public void setDataRecyclerView() {
//        recyclerView    =findViewById(R.id.recyclerView   )  ;
//        adapter=new TestAdapter(list,this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
//    }
//    @Override
//    public boolean onLongClick(View view) {
//
//textView.setText(convertDatatoString(list));
//addProgram("new.db");
//        return false;
//    }
//
//    private String convertDatatoString(List<Movtest> list) {
//
//        String ss="";
//        convertDatatoString(list);
//        for(int i=0;i<list.size();i++) {
//            Log.i("kirrr",String.valueOf(list.size()));
//            String A=  numttex( list.get(i).getA() )   ;
//            String B=  numttex( list.get(i).getB() )   ;
//            String C=  numttex( list.get(i).getC() )   ;
//            String D=  numttex( list.get(i).getD() )   ;
//            String E=  numttex( list.get(i).getE() )   ;
//            ss=ss+A+B+C+D+E ;
//
//        }
//
//return ss;
//    }





}
