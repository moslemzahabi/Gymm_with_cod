package com.example.gym_frag_db2.introo;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gym_frag_db2.R;


public class introo_fragment extends Fragment implements View.OnClickListener {

    SendMessage SM;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.introo_fragment, container, false);


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





        initButton(view);

    }

    private void initButton(View view) {
        view.findViewById(R.id.introo_program_button).setOnClickListener(this);
        view.findViewById(R.id.introo_education_button).setOnClickListener(this);
        view.findViewById(R.id.introo_tutorial_button).setOnClickListener(this);
        view.findViewById(R.id.introo_addprogram_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
       if(view.getId()==R.id.introo_education_button) {
           SM.pages(4);
       }
        if(view.getId()==R.id.introo_program_button) {
            SM.pages(1);
        }
        if(view.getId()==R.id.introo_tutorial_button) {
            SM.pages(7);
        }
        if(view.getId()==R.id.introo_addprogram_button) {
            SM.pages(8);
        }


    }

    //....................................................................



   //.........................................................................












  //.................................................................................





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


