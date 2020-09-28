package com.example.gym_frag_db2.education;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.gym_frag_db2.R;
import com.example.gym_frag_db2.education.Education;
import com.example.gym_frag_db2.education.EducationListAdapter;

import java.util.ArrayList;
import java.util.List;


public class Fragment_EducationTable extends Fragment  {

SendMessage SM;

RecyclerView recyclerView;


EducationListAdapter adapter;

List<Education>list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.education_table_fragment, container, false);





        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list_of_education();
        setRecyclerview(view);
        initButton(view);


    }

    private void initButton(View view) {
view.findViewById(R.id.backtointroo).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
SM.pages(6);
    }
});


    }

    private void setRecyclerview(View view) {
        recyclerView    =view.findViewById(R.id.recyclerview   )  ;
        adapter=new EducationListAdapter(list,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void list_of_education() {
        list=new ArrayList<>();
        list.add(new Education("sasan"));
        list.add(new Education("meysam"));
        list.add(new Education("sana"));
        list.add(new Education("baba"));
        list.add(new Education("maman"));

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


