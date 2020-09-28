package com.example.gym_frag_db2.education;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.gym_frag_db2.Activity.MainActivity;
import com.example.gym_frag_db2.R;

import java.util.ArrayList;
import java.util.List;

public class EducationListAdapter extends RecyclerView.Adapter<EducationListAdapter.MyViewHolder> {
    private List<Education> educationList;
private Context context;

    public EducationListAdapter(List<Education> educations, Context context) {
        this.educationList = (educations == null) ?
                new ArrayList<Education>() : educations;
this.context=context;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_education, parent, false);


        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(educationList.get(position));
    }
    @Override
    public int getItemCount() {//...........تعداد عناصر لیست...............
        return educationList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

       Button educationname;

        MyViewHolder(View itemView) {

            super(itemView);


            educationname         =itemView.findViewById(R.id.educationname);


        }

          public void bind(final Education answerLists) {
              educationname.setText(answerLists.getEducationName());


              educationname.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Toast.makeText(context, "EDUCATION", Toast.LENGTH_SHORT).show();

        ((MainActivity) context).getStringFromAdapters("toEducationSho",answerLists.getEducationName());

    }});


        }

    }



}