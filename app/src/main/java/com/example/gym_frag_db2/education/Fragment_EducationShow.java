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


import java.util.ArrayList;
import java.util.List;


public class Fragment_EducationShow extends Fragment  {

SendMessage SM;

RecyclerView recyclerView;

EducationShowAdapter adapter;

List<EducationData>list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.education_show_fragment, container, false);




        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String myValue="empty";

        Bundle bundle = this.getArguments();
        if (bundle!=null){
           myValue = bundle.getString("educationname");
        }


        list_of_education(myValue);

        setRecyclerview(view);

        initButton(view);

    }

    private void setRecyclerview(View view) {
        recyclerView    =view.findViewById(R.id.recyclerview   )  ;
        adapter=new EducationShowAdapter(list,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void list_of_education(String EdiocationName) {
        list = new ArrayList<>();


        if (EdiocationName == "empty") {

            list.add(new EducationData(R.mipmap.ic_launcher, "emmmmmmmmmmpty"));

        }

        if (EdiocationName == "sasan") {

            list.add(new EducationData(R.mipmap.ic_launcher, "sasan"));
            list.add(new EducationData(R.mipmap.ic_launcher, "sasan1"));
            list.add(new EducationData(R.mipmap.ic_launcher, "sasan2"));
            list.add(new EducationData(R.mipmap.ic_launcher, "sasan3"));
            list.add(new EducationData(R.mipmap.ic_launcher, "sasan4"));
            list.add(new EducationData(R.mipmap.ic_launcher, "sasan5"));
            list.add(new EducationData(R.mipmap.ic_launcher, "sasan6"));
            list.add(new EducationData(R.mipmap.ic_launcher, "sasan7"));
        }

        if (EdiocationName == "meysam") {

            list.add(new EducationData(R.mipmap.ic_launcher, "meysam"));
            list.add(new EducationData(R.mipmap.ic_launcher, "meysam1"));
            list.add(new EducationData(R.mipmap.ic_launcher, "meysam2"));
            list.add(new EducationData(R.mipmap.ic_launcher, "meysam3"));
            list.add(new EducationData(R.mipmap.ic_launcher, "meysam4"));
            list.add(new EducationData(R.mipmap.ic_launcher, "meysam5"));
            list.add(new EducationData(R.mipmap.ic_launcher, "meysam6"));
            list.add(new EducationData(R.mipmap.ic_launcher, "meysam7"));

        }

        if (EdiocationName == "sana") {

            list.add(new EducationData(R.mipmap.ic_launcher, "sana"));
            list.add(new EducationData(R.mipmap.ic_launcher, "sana1"));
            list.add(new EducationData(R.mipmap.ic_launcher, "sana2"));
            list.add(new EducationData(R.mipmap.ic_launcher, "sana3"));
            list.add(new EducationData(R.mipmap.ic_launcher, "sana4"));
            list.add(new EducationData(R.mipmap.ic_launcher, "sana5"));
            list.add(new EducationData(R.mipmap.ic_launcher, "sana6"));
            list.add(new EducationData(R.mipmap.ic_launcher, "sana7"));
        }

        if (EdiocationName == "baba") {

            list.add(new EducationData(R.mipmap.ic_launcher, "baba"));
            list.add(new EducationData(R.mipmap.ic_launcher, "baba1"));
            list.add(new EducationData(R.mipmap.ic_launcher, "baba2"));
            list.add(new EducationData(R.mipmap.ic_launcher, "baba3"));
            list.add(new EducationData(R.mipmap.ic_launcher, "baba4"));
            list.add(new EducationData(R.mipmap.ic_launcher, "baba5"));
            list.add(new EducationData(R.mipmap.ic_launcher, "baba6"));
            list.add(new EducationData(R.mipmap.ic_launcher, "baba7"));

        }
        if (EdiocationName == "maman") {

            list.add(new EducationData(R.mipmap.ic_launcher, "maman"));
            list.add(new EducationData(R.mipmap.ic_launcher, "maman1"));
            list.add(new EducationData(R.mipmap.ic_launcher, "maman2"));
            list.add(new EducationData(R.mipmap.ic_launcher, "maman3"));
            list.add(new EducationData(R.mipmap.ic_launcher, "maman4"));
            list.add(new EducationData(R.mipmap.ic_launcher, "maman5"));
            list.add(new EducationData(R.mipmap.ic_launcher, "maman6"));
            list.add(new EducationData(R.mipmap.ic_launcher, "maman7"));

        }
    }

    private void initButton(View view) {

    view.findViewById(R.id.imageButtonshow).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
SM.pages(4);
        }
    });

    }











    //............................................................interface..............
    public interface SendMessage {
        void pages(int pag);


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


