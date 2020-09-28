package com.example.gym_frag_db2.program.fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gym_frag_db2.R;
import com.example.gym_frag_db2.program.adapter.Adapter_programlist;
import com.example.gym_frag_db2.program.databas.myDatabaseHelper2;
import com.example.gym_frag_db2.program.model.Programs;

import java.util.ArrayList;
import java.util.List;


public class ProgramList_fragment extends Fragment implements View.OnClickListener, Adapter_programlist.ProgramlistCallback  {

 SendMessage SM;
    myDatabaseHelper2 db;
EditText programname;

    List<Programs> list;
    Adapter_programlist listadapter;
    RecyclerView recycleView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.program_programlist_fragment, container, false);



        init(rootView);
        initButton(rootView);
        setDataInList();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





    }
    //....................................................................
    private void initButton(View view) {
//        FloatingActionButton set,backintroo;

        view.findViewById(R.id.addnewprogram).setOnClickListener(this);
        view.findViewById(R.id.home_floatingbutton).setOnClickListener(this);




    }

    private void init(View view) {

        list=new ArrayList<>();
        recycleView=view.findViewById(R.id.recyclerView);
        db= new myDatabaseHelper2(getContext());
        //pref=new PrefManager(this);





    }

    @Override
    public void onClick(View view) {


        if(view.getId()==R.id.addnewprogram){
            runAlert();
        }
        if(view.getId()==R.id.home_floatingbutton){
            SM.pages(6);
        }

    }

    //.........................................................................
    public void setDataInList() {

       list.clear();

//فراخوانی تابع Select
        Cursor res=db.ShowallData();

//بررسی خالی بودن جدول
        if(res.getCount()==0){
            Toast.makeText(getContext(),"جدول خالی بود",Toast.LENGTH_LONG).show();

        }

//گرفتن تمام داداه های داخل جدول
        while (res.moveToNext()){

            list.add(new Programs(res.getInt(0),res.getString(1)));

        }
        setRecycleViewData();
    }

    private void  setRecycleViewData(){

        listadapter=new Adapter_programlist(list,getContext(),this);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleView.setAdapter(listadapter);

    }

    private void runAlert() {

        LayoutInflater aInflater = getLayoutInflater();
        View alertLayout = aInflater.inflate(R.layout.get_programname_dialog, null);

        programname    =alertLayout.findViewById(R.id.editText);

        new AlertDialog.Builder(getContext(), R.style.DialogTheme)
                .setTitle("Login")
                .setCancelable(false)
                .setView(alertLayout)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (programname.getText().toString().length() >= 1) {
                            db.insertData(programname.getText().toString());
                            setDataInList();
                        }
                    }

                })

                .create()
                .show();

    }




    @Override
    public void programlistCallback(int cod,String programname) {
        if(cod==1){
            Toast.makeText(getContext(), "yessssssssssssssssss", Toast.LENGTH_SHORT).show();
            setDataInList();
        }
        if(cod==2){
          SM.pages(2);
          SM.sendData_list_toprogram(programname);
        }
    }


    //.................................................................................





    //............................................................interface..............
    public interface SendMessage {
        void pages(int Pag_number);
        void sendData_list_toprogram(String day);
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


