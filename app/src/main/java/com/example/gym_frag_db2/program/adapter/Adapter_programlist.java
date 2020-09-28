package com.example.gym_frag_db2.program.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.gym_frag_db2.Activity.MainActivity;
import com.example.gym_frag_db2.R;
import com.example.gym_frag_db2.program.databas.myDatabaseHelper;
import com.example.gym_frag_db2.program.model.Programs;
import com.example.gym_frag_db2.program.databas.myDatabaseHelper2;
import java.util.ArrayList;
import java.util.List;
public class Adapter_programlist extends RecyclerView.Adapter<Adapter_programlist.MyViewHolder> {
    private List<Programs> movmentList;
    private Context context;
private ProgramlistCallback programlistCallback;


    public Adapter_programlist(List<Programs> items, Context context, ProgramlistCallback programlistCallback) {
        this.movmentList = (items == null) ?
                new ArrayList<Programs>() : items;
this.context=context;
this.programlistCallback=programlistCallback;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_programs_list, parent, false);


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

       Button programname;

       ImageButton deletprogram,programcod;

        MyViewHolder(View itemView) {

            super(itemView);

            programcod =itemView.findViewById(R.id.getcod_bt);
            programname =itemView.findViewById(R.id.programname);
            deletprogram =itemView.findViewById(R.id.deletprogram);
        }

          public void bind(final Programs programs) {
              programname.setText(String.valueOf(programs.getProgramsname()));


              programname.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //go to mov information
programlistCallback.programlistCallback(2,programs.getProgramsname());
    }});

deletprogram.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
deletAlert(programs);
    }
});
programcod.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        codAlert(programs.getProgramsname());
    }
});


        }

    }


    public void deletAlert(final Programs program){
        AlertDialog.Builder alertdialog=new AlertDialog.Builder(context);
        alertdialog.setTitle("question?")
                .setMessage("are you sure?")
                .setCancelable(false)
                .setIcon(R.drawable.dialog_background)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DeletDatabase(program); }})

                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "noooooooooooooooooooo", Toast.LENGTH_SHORT).show();}});



        alertdialog.show();
    }

    private void codAlert(final String programname) {

        AlertDialog.Builder alertdialog=new AlertDialog.Builder(context);
        alertdialog.setTitle("programcod is:")
                .setMessage(getDatabasecod(programname))
                .setCancelable(false)
                .setIcon(R.drawable.dialog_background)
                .setPositiveButton("copy cod", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("label",getDatabasecod(programname));
                        clipboard.setPrimaryClip(clip);
                      }})

                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "کد کپی نشد", Toast.LENGTH_SHORT).show();}});



        alertdialog.show();

    }


    private void DeletDatabase(Programs programs){


        myDatabaseHelper2 db=new myDatabaseHelper2(context);
      context.deleteDatabase(programs.getProgramsname()+".db");
        db.deleteData(programs.getId());
        programlistCallback.programlistCallback(1,"");

    }

    private String getDatabasecod(String pronam){
      myDatabaseHelper db  =new myDatabaseHelper(context,pronam+".db");

//فراخوانی تابع Select
        Cursor res=db.ShowallData();

//بررسی خالی بودن جدول
        if(res.getCount()==0){
            Toast.makeText(context,"جدول خالی بود",Toast.LENGTH_LONG).show();

        }

        String ss="";
        while (res.moveToNext()){


                String A=  numttex( res.getInt(1) )   ;
                String B=  numttex( res.getInt(2) )   ;
                String C=  numttex( res.getInt(3) )   ;
                String D=  numttex( res.getInt(4) )   ;
                String E=  numttex( res.getInt(5) )   ;
                String F=  numttex( res.getInt(6) )   ;
                ss=ss+A+B+C+D+E+F ;



            }


return pronam+""+ss;


    }

    private String numttex(int o) {
        String text = "";
        switch (o) {
            case 0: {
                text = ".";
                break;
            }
            case 1: {
                text = "a";
                break;
            }
            case 2: {
                text = "b";
                break;
            }
            case 3: {
                text = "c";
                break;
            }
            case 4: {
                text = "d";
                break;
            }
            case 5: {
                text = "e";
                break;
            }
            case 6: {
                text = "f";
                break;
            }
            case 7: {
                text = "g";
                break;
            }
            case 8: {
                text = "h";
                break;
            }
            case 9: {
                text = "i";
                break;
            }
            case 10: {
                text = "j";
                break;
            }
            case 11: {
                text = "k";
                break;
            }
            case 12: {
                text = "l";
                break;
            }
            case 13: {
                text = "m";
                break;
            }
            case 14: {
                text = "n";
                break;
            }
            case 15: {
                text = "o";
                break;
            }
            case 16: {
                text = "p";
                break;
            }
            case 17: {
                text = "q";
                break;
            }
            case 18: {
                text = "r";
                break;
            }
            case 19: {
                text = "s";
                break;
            }
            case 20: {
                text = "t";
                break;
            }
            case 21: {
                text = "u";
                break;
            }
            case 22: {
                text = "v";
                break;
            }
            case 23: {
                text = "w";
                break;
            }
            case 24: {
                text = "x";
                break;
            }
            case 25: {
                text = "y";
                break;
            }
            case 26: {
                text = "z";
                break;
            }


        }
        return text;
    }







//...................................interfac...............
    public interface ProgramlistCallback{
        void programlistCallback(int cod, String programname);
    }


}