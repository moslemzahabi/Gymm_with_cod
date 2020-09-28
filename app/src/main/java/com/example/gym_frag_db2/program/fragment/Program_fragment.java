package com.example.gym_frag_db2.program.fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.gym_frag_db2.R;
import com.example.gym_frag_db2.program.adapter.Adapter_movlist;
import com.example.gym_frag_db2.program.databas.myDatabaseHelper;
import com.example.gym_frag_db2.program.model.Movment;

import java.util.ArrayList;
import java.util.List;

import static com.example.gym_frag_db2.Activity.MainActivity.Day;
import static com.example.gym_frag_db2.Activity.MainActivity.Prpgramm;


public class Program_fragment extends Fragment implements View.OnClickListener, Adapter_movlist.MyCallback  {

 SendMessage SM;
    myDatabaseHelper db;


    ArrayAdapter<String> adapter ;
    ArrayAdapter<String> adapter0;
    ArrayAdapter<String> adapter1;
    ArrayAdapter<String> adapter2;
    ArrayAdapter<String> adapter3;
    ArrayAdapter<String> adapter4;
    ArrayAdapter<String> adapter5;
    ArrayAdapter<String> adapter6;

    ArrayAdapter<String> numberAdapter;

    Spinner mov;
    Spinner submov;
    Spinner set;
    Spinner minmov;
    Spinner maxmov;


    List<Movment> list;
    Adapter_movlist listadapter;
    RecyclerView recycleView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.program_program_fragment, container, false);




        return rootView;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        init(view);
        initButton(view);
        setDataInList();


    }
    //....................................................................
    private void initButton(View view) {
//        FloatingActionButton set,backintroo;

        FloatingActionButton addmov         =view.findViewById(R.id.addnewmov);
        FloatingActionButton backprogramlist=view.findViewById(R.id.backprogramlist);

backprogramlist      .setOnClickListener(this);
        addmov       .setOnClickListener(this);


    }

    private void init(View view) {

        list=new ArrayList<>();
        recycleView=view.findViewById(R.id.recyclerView);
        db= new myDatabaseHelper(getContext(), Prpgramm +".db");//Prpgramm=static constant from mainactivity
        //pref=new PrefManager(this);





    }
    @Override
    public void onClick(View view) {


        if(view.getId()==R.id.addnewmov){
            runAlert();
        }
        if(view.getId()==R.id.backprogramlist){
            SM.pages(2);
        }

    }
    //.........................................................................
    private void setDataInList() {
        list.clear();

//فراخوانی تابع Select
        Cursor res=db.ShowallData();

//بررسی خالی بودن جدول
        if(res.getCount()==0){
            Toast.makeText(getContext(),"جدول خالی بود",Toast.LENGTH_LONG).show();

        }

//گرفتن تمام داداه های داخل جدول
//        while (res.moveToNext()){
//
//            list.add(new Movment(res.getInt(0),res.getInt(1),res.getInt(2),
//                                 res.getInt(3),res.getInt(4),res.getInt(5),res.getInt(6)));
//
//        }
        while (res.moveToNext()){
        if(res.getInt(1)==Day){

            list.add(new Movment(res.getInt(0),res.getInt(1),res.getInt(2),
                    res.getInt(3),res.getInt(4),res.getInt(5),res.getInt(6)));

        }}


        setRecycleViewData();
    }

    private void  setRecycleViewData(){

        listadapter=new Adapter_movlist(list,getContext(),this);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleView.setAdapter(listadapter);

    }

    private void runAlert() {

        LayoutInflater aInflater = getLayoutInflater();
        View alertLayout = aInflater.inflate(R.layout.get_mov, null);

         mov    =alertLayout.findViewById(R.id.sp_mov);
         submov =alertLayout.findViewById(R.id.sp_submov);
         set    =alertLayout.findViewById(R.id.sp_set);
         minmov =alertLayout.findViewById(R.id.sp_minmov);
         maxmov =alertLayout.findViewById(R.id.sp_maxmov);

        spinnerAdapter();

        new AlertDialog.Builder(getContext(), R.style.DialogTheme)
                .setTitle("Login")
                .setCancelable(false)
                .setView(alertLayout)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                       db.insertData(Day,
                                     mov.getSelectedItemPosition(),
                                  submov.getSelectedItemPosition(),
                                     set.getSelectedItemPosition(),
                                  minmov.getSelectedItemPosition(),
                                  maxmov.getSelectedItemPosition()
                              );
                        setDataInList();
                        //      setRecycleViewData();
                    }
                })

                .create()
                .show();

    }

    private void spinnerAdapter() {


        String[]   move      =getResources().getStringArray(R.array.exersise   )  ;
        String[]   noting    =getResources().getStringArray(R.array. noting    )  ;
        String[]   peres     =getResources().getStringArray(R.array. peres     )  ;
        String[]   sarshaneh =getResources().getStringArray(R.array. sarshaneh )  ;
        String[]   jelobazoo =getResources().getStringArray(R.array. jelobazoo )  ;
        String[]   poshtbazoo=getResources().getStringArray(R.array. poshtbazoo)  ;
        String[]   zirbaghal =getResources().getStringArray(R.array. zirbaghal )  ;
        String[]   kool      =getResources().getStringArray(R.array. kool      )  ;
        String[]   number    =getResources().getStringArray(R.array. number      )  ;



//........................................................................................................

        adapter       =new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,move   );
        numberAdapter =new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,number);
//.............................................sub mov.....................................................
        adapter0=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, noting    );
        adapter1=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, peres     );
        adapter2=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, sarshaneh );
        adapter3=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, jelobazoo );
        adapter4=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, poshtbazoo);
        adapter5=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, zirbaghal );
        adapter6=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, kool      );


        mov.setAdapter(adapter);
        set.setAdapter(numberAdapter);
        minmov.setAdapter(numberAdapter);
        maxmov.setAdapter(numberAdapter);


        mov.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    submov.setAdapter(adapter0);

                }
                if (i == 1) {
                    submov.setAdapter(adapter1);

                }
                if (i == 2) {
                    submov.setAdapter(adapter2);

                }
                if (i == 3) {
                    submov.setAdapter(adapter3);

                }
                if (i == 4) {
                    submov.setAdapter(adapter4);

                }
                if (i == 5) {
                    submov.setAdapter(adapter5);

                }
                if (i == 6) {
                    submov.setAdapter(adapter6);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }
    @Override
    public void onItemClicked() {

        setDataInList();

    }


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


