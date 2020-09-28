package com.example.gym_frag_db2.program.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.gym_frag_db2.Activity.MainActivity;
import com.example.gym_frag_db2.R;
import com.example.gym_frag_db2.program.databas.myDatabaseHelper;
import com.example.gym_frag_db2.program.databas.myDatabaseHelper2;
import com.example.gym_frag_db2.testActivitis.Movtest;

import java.util.ArrayList;
import java.util.List;


public class AddProgram_fragment extends Fragment implements View.OnClickListener {

    SendMessage SM;

    List<Movtest> list;
    Button Add;
    EditText editText;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.program_addprogram_fragment, container, false);





        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initButton(view);
        init(view);
    }

    private void initButton(View view) {
        ImageButton clous =view.findViewById(R.id.clouse);
        clous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         ((MainActivity)getContext()).pages(6);
            }
        });






    }

    //....................................................................




  //.................................................................................

    private void init(View view) {

        Add  =view.findViewById(R.id.addcod);

        editText=view.findViewById(R.id.getcod_et);
        list=new ArrayList<>();
        Add.setOnClickListener(this);

        view.findViewById(R.id.program1_button).setOnClickListener(this);
        view.findViewById(R.id.program2_button).setOnClickListener(this);
        view.findViewById(R.id.program3_button).setOnClickListener(this);
        view.findViewById(R.id.program4_button).setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        String cod;
        if(view.getId()==R.id.addcod){
           cod = editText.getText().toString();
            Addtoprogramwhittext(cod);
        }

        if(view.getId()==R.id.program1_button){
          cod= "program1 aaa...aab...ac....aca...bb....bba...bf....bfa...ce....cea...cd....cda...daa...dac...dcb...dcc...ebb...ebc...efb...efd...fec...fed...fdc...fdd...";
            Addtoprogramwhittext(cod);
        }
        if(view.getId()==R.id.program2_button){
            cod= "program2 aaa...aab...ac....aca...bb....bba...bf....bfa...ce....cea...cd....cda...daa...dac...dcb...dcc...ebb...ebc...efb...efd...fec...fed...fdc...fdd...";
            Addtoprogramwhittext(cod);
        }
        if(view.getId()==R.id.program3_button){
            cod= "program2 aaa...aab...ac....aca...bb....bba...bf....bfa...ce....cea...cd....cda...daa...dac...dcb...dcc...ebb...ebc...efb...efd...fec...fed...fdc...fdd...";
            Addtoprogramwhittext(cod);
        }
        if(view.getId()==R.id.program4_button){
            cod= "program1 aaa...abb...ac....aca...bb....bba...bf....bca...ce....cda...cd....eda...daa...dac...dcb...dfc...ebb...ebc...efb...efd...fec...fed...fdc...fdd...";
            Addtoprogramwhittext(cod);
        }






    }

    private void Addtoprogramwhittext(String cod) {
        if ((editText.getText().toString().length())%6==0){
            list.clear();
            char[] s = cutString(cod," ",true).toCharArray();

            for (int i=0;i<s.length;i=i+6){

                list.add(new Movtest(textnum(s[i+0]), textnum(s[i+1]), textnum(s[i+2]), textnum(s[i+3]), textnum(s[i+4]),textnum(s[i+5])) );

            }

            addProgramToDatabase( cutString(cod," ",false));

            gotomain();


        }


    }

    private void gotomain() {

        ((MainActivity)getContext()).pages(6);

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

    private void addProgramToDatabase(String databasname ){
        myDatabaseHelper  db = new myDatabaseHelper (getContext(),databasname+".db");
        myDatabaseHelper2 db2= new myDatabaseHelper2(getContext());

        db2.insertData(databasname);
        for(int i=0;i<list.size();i++){
            int A=list.get(i).getDay();
            int B=list.get(i).getMov();
            int C=list.get(i).getSubmov();
            int D=list.get(i).getSet();
            int E=list.get(i).getMinmov();
            int F=list.get(i).getMaxmov();
            db.insertData(A,B,C,D,E,F);
//            Log.i("kirrr","day"+String.valueOf(i)+"___"+String.valueOf(A));
//            Log.i("kirrr","mov"+String.valueOf(i)+"___"+String.valueOf(B));
//            Log.i("kirrr","submov"+String.valueOf(i)+"___"+String.valueOf(C));
//            Log.i("kirrr","set"+String.valueOf(i)+"___"+String.valueOf(D));
//            Log.i("kirrr","min"+String.valueOf(i)+"___"+String.valueOf(E));
//            Log.i("kirrr","max"+String.valueOf(i)+"___"+String.valueOf(F));

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


    //............................................................interface..............
    public interface SendMessage {
        void pages(int Pag_number);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SM = (SendMessage) getActivity();
        } catch (ClassCastException e) {

        }
    }
//............................................................interface..............


    }


