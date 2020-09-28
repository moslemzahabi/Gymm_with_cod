package com.example.gym_frag_db2.program.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gym_frag_db2.R;
import com.example.gym_frag_db2.program.databas.myDatabaseHelper;
import com.example.gym_frag_db2.program.model.Movment;

import java.util.List;


public class ProgramDay_fragment extends Fragment implements View.OnClickListener  {

 SendMessage SM;
    myDatabaseHelper db;







    List<Movment> list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.program_programdy_fragment, container, false);



        init(rootView);
        initButton(rootView);

        return rootView;
    }

    private void init(View rootView) {
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





    }
    //....................................................................
    private void initButton(View view) {
//        FloatingActionButton set,backintroo;

//        FloatingActionButton addmov         =view.findViewById(R.id.addnewmov);
        FloatingActionButton backprogramlist=view.findViewById(R.id.backprogramlist);
        Button saturdayButton =view.findViewById   (R.id.saturdayButton_id);
        Button sundayButton   =view.findViewById   (R.id.sundayButton_id);
        Button mondayButton   =view.findViewById   (R.id.mondayButton_id);
        Button tuesdayButton  =view.findViewById   (R.id.tuesdayButton_id);
        Button wednesdayButton=view.findViewById   (R.id.wednesdayButton_id);
        Button thursdayButton =view.findViewById   (R.id.thursdayButton_id);
        Button fridayButton   =view.findViewById   (R.id.fridayButton_id);

//backprogramlist      .setOnClickListener(this);
//        addmov       .setOnClickListener(this);


        backprogramlist.setOnClickListener(this);
        saturdayButton.setOnClickListener(this);
        sundayButton.setOnClickListener(this);
        mondayButton.setOnClickListener(this);
        tuesdayButton.setOnClickListener(this);
        wednesdayButton.setOnClickListener(this);
        thursdayButton.setOnClickListener(this);
        fridayButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

switch (view.getId()){
//    case R.id.addnewmov:{ }
//    case R.id.backprogramlist:{ SM.pages(1);break;}

    case R.id.backprogramlist   :{                   SM.pages(1);break;}
    case R.id.saturdayButton_id :{SM.setDaynumber(1);SM.pages(3);break;}
    case R.id.sundayButton_id   :{SM.setDaynumber(2);SM.pages(3);break;}
    case R.id.mondayButton_id   :{SM.setDaynumber(3);SM.pages(3);break;}
    case R.id.tuesdayButton_id  :{SM.setDaynumber(4);SM.pages(3);break;}
    case R.id.wednesdayButton_id:{SM.setDaynumber(5);SM.pages(3);break;}
    case R.id.thursdayButton_id :{SM.setDaynumber(6);SM.pages(3);break;}
    case R.id.fridayButton_id   :{SM.setDaynumber(7);SM.pages(3);break;}

    }
    }

    //.........................................................................





    //.................................................................................









    //............................................................interface..............
    public interface SendMessage {
        void pages       (int Pag_number);
        void setDaynumber(int daynumber );
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


