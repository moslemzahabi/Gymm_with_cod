package com.example.gym_frag_db2.Activity;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gym_frag_db2.education.Fragment_EducationTable;
import com.example.gym_frag_db2.introo.introo_fragment;
import com.example.gym_frag_db2.program.fragment.AddProgram_fragment;
import com.example.gym_frag_db2.program.fragment.MoveImage_fragment;
import com.example.gym_frag_db2.education.Fragment_EducationShow;
import com.example.gym_frag_db2.R;
import com.example.gym_frag_db2.program.fragment.ProgramDay_fragment;
import com.example.gym_frag_db2.program.fragment.ProgramList_fragment;
import com.example.gym_frag_db2.program.fragment.Program_fragment;
import com.example.gym_frag_db2.introo.tutorial_fragment;

public class MainActivity extends AppCompatActivity
        implements Program_fragment.SendMessage,
                   ProgramList_fragment.SendMessage,
                   ProgramDay_fragment.SendMessage ,
                   introo_fragment.SendMessage,
                   Fragment_EducationTable.SendMessage,
                   Fragment_EducationShow.SendMessage{

FragmentManager fragmentManager;

        public static String Prpgramm;
        public static int Day;

//.................................................................................................



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        fragmentManager = getSupportFragmentManager();//Get Fragment Manager
        fragmentManager.beginTransaction().replace(R.id.framelayout, new introo_fragment()).commit();

    }




    @Override
    public void pages(int Pag_number) {
    //========================programs_fragment===============================
        if(Pag_number==1){
           fragmentManager.beginTransaction().replace(R.id.framelayout, new ProgramList_fragment()).commit();
    }
        if(Pag_number==2){
            fragmentManager.beginTransaction().replace(R.id.framelayout, new ProgramDay_fragment()).commit();
        }
        if(Pag_number==3){
            fragmentManager.beginTransaction().replace(R.id.framelayout, new Program_fragment()).commit();
        }
        //======================Education_fragment===============================
        if(Pag_number==4){
            fragmentManager.beginTransaction().replace(R.id.framelayout, new Fragment_EducationTable()).commit();
        }
        if(Pag_number==5){
            fragmentManager.beginTransaction().replace(R.id.framelayout, new Fragment_EducationShow()).commit();
        }

        //=======================introo fragment====================================
        if(Pag_number==6){
            fragmentManager.beginTransaction().replace(R.id.framelayout, new introo_fragment()).commit();
        }

        if(Pag_number==7){
            fragmentManager.beginTransaction().replace(R.id.framelayout, new tutorial_fragment()).commit();
        }
        if(Pag_number==8){
            fragmentManager.beginTransaction().replace(R.id.framelayout, new AddProgram_fragment()).commit();
        }
    }

    @Override
    public void setDaynumber(int daynumber) {
       Day =daynumber;
    }

    @Override
    public void sendData_list_toprogram(String Prpgramm) {
       this.Prpgramm =Prpgramm;
    }


    public void getStringFromAdapters(String cod,String educationName) {
   if(cod=="toEducationSho") {
    Bundle bundle = new Bundle();
    String myMessage = educationName;
    bundle.putString("educationname", myMessage);
    Fragment_EducationShow fragInfo = new Fragment_EducationShow();
    fragInfo.setArguments(bundle);
    fragmentManager.beginTransaction().replace(R.id.framelayout, fragInfo).commit();
}


    }


    public void getIntegerFromAdapters(int cod,int mov,int submov) {
        if(cod==1) {
            Bundle bundle = new Bundle();
            bundle.putInt("movcod", mov);
            bundle.putInt("submovcod", submov);
            MoveImage_fragment fragInfo = new MoveImage_fragment();
            fragInfo.setArguments(bundle);
            fragmentManager.beginTransaction().replace(R.id.framelayout, fragInfo).commit();
        }


    }


}
