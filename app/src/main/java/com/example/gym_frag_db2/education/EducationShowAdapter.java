package com.example.gym_frag_db2.education;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.gym_frag_db2.R;

import java.util.ArrayList;
import java.util.List;


public class EducationShowAdapter extends RecyclerView.Adapter<EducationShowAdapter.MyViewHolder> {
    private List<EducationData> educationList;
private Context context;

    public EducationShowAdapter(List<EducationData> educations, Context context) {
        this.educationList = (educations == null) ?
                new ArrayList<EducationData>() : educations;
this.context=context;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_educationshow, parent, false);


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

       TextView educationText;
       ImageView imageView;

        MyViewHolder(View itemView) {

            super(itemView);


            educationText =itemView.findViewById(R.id.textView_educationShowAdapter );
            imageView     =itemView.findViewById(R.id.imageView_educationShowAdapter);

        }

          public void bind(final EducationData answerLists) {
              educationText.setText (answerLists.getText());
              imageView .setImageResource(answerLists.getImagid());




        }

    }









}