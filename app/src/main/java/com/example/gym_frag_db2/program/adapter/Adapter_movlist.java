package com.example.gym_frag_db2.program.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gym_frag_db2.Activity.MainActivity;
import com.example.gym_frag_db2.R;
import com.example.gym_frag_db2.program.model.Movment;
import com.example.gym_frag_db2.program.databas.myDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

import static com.example.gym_frag_db2.Activity.MainActivity.Prpgramm;

public class Adapter_movlist extends RecyclerView.Adapter<Adapter_movlist.MyViewHolder> {
    private List<Movment> movmentList;
    private Context context;

private MyCallback myCallback;


    public Adapter_movlist(List<Movment> items, Context context, MyCallback myCallback) {
        this.movmentList = (items == null) ?
                new ArrayList<Movment>() : items;
this.context=context;
this.myCallback=myCallback;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_movment_list, parent, false);


        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.bind(movmentList.get(position));
    }
    @Override
    public int getItemCount() {//...........تعداد عناصر لیست...............
        return movmentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {

       Button submov;
       TextView mov,set;
       ImageButton delet;

        MyViewHolder(View itemView) {

            super(itemView);


            submov=itemView.findViewById(R.id.submov);
            mov   =itemView.findViewById(R.id.mov   );
            set   =itemView.findViewById(R.id.set   );
            delet=itemView.findViewById(R.id.deletbutton);
        }

          public void bind(final Movment movmentLists) {
              submov.setText(IntToTextSub2(movmentLists.getMov(),movmentLists.getSubmov()));
                 mov.setText(IntToText(movmentLists.getMov()));
                 String s=String.valueOf(movmentLists.getMovset())+"  "+
                         String.valueOf(movmentLists.getMinmov())+"  "+
                         String.valueOf(movmentLists.getMaxmov());
                 set.setText(s);



              submov.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //go to mov information
        ((MainActivity) context).getIntegerFromAdapters( 1, movmentLists.getMov(), movmentLists.getSubmov());
    }});

delet.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
Alert(movmentLists);
    }
});

        }

    }

    public  void Alert(final Movment movment){
        AlertDialog.Builder alertdialog=new AlertDialog.Builder(context);
        alertdialog.setTitle("question?")
                .setMessage("are you sure?")
                .setCancelable(false)
                .setIcon(R.drawable.dialog_background)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DeletDatabase(movment); }})

                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "noooooooooooooooooooo", Toast.LENGTH_SHORT).show();}});



        alertdialog.show();
    }
    private void DeletDatabase(Movment answerLists){


        myDatabaseHelper db=new myDatabaseHelper(context, Prpgramm +".db");
        db.deleteData(String.valueOf(answerLists.getId()));
        myCallback.onItemClicked();

    }
//................................................................................
    private String IntToTextSub2(int mov,int submov){


        String s="";

        if (mov==1){
            switch (submov){

                case 0:  s= "پرس 1"; break;
                case 1:  s= "پرس 2"; break;
                case 2:  s= "پرس 3"; break;
                case 3:  s= "پرس 4"; break;
                case 4:  s= "پرس 5"; break;
                case 5:  s= "پرس 6"; break;
            }
        }
        if (mov==2){
            switch (submov){

                case 0:  s= "سرشانه 1";break;
                case 1:  s= "سرشانه 2";break;
                case 2:  s= "سرشانه 3";break;
                case 3:  s= "سرشانه 4";break;
                case 4:  s= "سرشانه 5";break;
            }
        }
        if (mov==3){
            switch (submov){

                case 0:  s= "جلوبازو 1";break;
                case 1:  s= "جلوبازو 2";break;
                case 2:  s= "جلوبازو 3";break;
                case 3:  s= "جلوبازو 4";break;
                case 4:  s= "جلوبازو 5";break;
            }
        }
        if (mov==4){
            switch (submov){

                case 0:  s= "پشتبازو 1";break;
                case 1:  s= "پشتبازو 2";break;
                case 2:  s= "پشتبازو 3";break;
                case 3:  s= "پشتبازو 4";break;
                case 4:  s= "پشتبازو 5";break;
            }
        }
        if (mov==5){
            switch (submov){

                case 0:  s= "زیربغل 1";break;
                case 1:  s= "زیربغل 2";break;
                case 2:  s= "زیربغل 3";break;
                case 3:  s= "زیربغل 4";break;
                case 4:  s= "زیربغل 5";break;
            }
        }
        if (mov==6){
            switch (submov){

                case 0:  s= "کول 1";break;
                case 1:  s= "کول 2";break;
                case 2:  s= "کول 3";break;
                case 3:  s= "کول 4";break;
                case 4:  s= "کول 5";break;
            }
        }


        return s;

    }
    private String IntToText(int mov){
//        String m="";
//       switch (mov){
//           case 1: m= "پرس سینه";break;
//           case 2: m= "سرشانه"  ;break;
//           case 3: m= "جلو بازو";break;
//           case 4: m= "پشت بازو";break;
//           case 5: m= "زیربغل"  ;break;
//           case 6: m= "کول"     ;break;
//
//       }
//
//        return m;
        String[]   m  =context.getResources().getStringArray(R.array.exersise);
        return m[mov];
    }
    private String returnday(int Daynumber){
        String a;
        switch(Daynumber){
            case 1 : a= "شنبه"     ;break;
            case 2 : a= "یکشنبه"   ;break;
            case 3 : a= "دوشنبه"   ;break;
            case 4 : a= "سه شنبه"  ;break;
            case 5 : a= "چهارشنبه" ;break;
            case 6 : a= "پنجشنبه"  ;break;
            case 7 : a= "جمعه"     ;break;
            default: a= "00000"    ;break;
        }
        return a;
    }




    //............................................interfaces...............
    public interface MyCallback{
        void onItemClicked();
    }


}