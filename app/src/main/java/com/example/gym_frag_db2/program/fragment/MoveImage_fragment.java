package com.example.gym_frag_db2.program.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.gym_frag_db2.Activity.MainActivity;
import com.example.gym_frag_db2.R;


public class MoveImage_fragment extends Fragment {

 //SendMessage SM;

TextView targetmuscle,movname,englishmovname;

    int MOV;
    int SUBMOV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.program_movimag_fragment, container, false);





        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        setMOV_SUBMOV();
        setTextView(view);
        setImageView(view);
        initButton(view);

    }

    private void initButton(View view) {
        FloatingActionButton clous =view.findViewById(R.id.clouse);
        clous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getContext()).pages(3);
            }
        });
    }

    private void setMOV_SUBMOV() {
        Bundle bundle = this.getArguments();
        if (bundle!=null){
            MOV    = bundle.getInt("movcod"   );
            SUBMOV = bundle.getInt("submovcod");
        }
    }
    //....................................................................

    private void setTextView(View view) {


        movname       =view.findViewById(R.id.movname);
        englishmovname=view.findViewById(R.id.englishmovname);
        targetmuscle  =view.findViewById(R.id.targetmuscle);

        movname.setText(ReturnMovName());
englishmovname.setText(ReturnEnglishMovName());
targetmuscle.setText(ReturnMuscletarget());
    }

    public void setImageView(View view) {

        ImageView image=view.findViewById(R.id.imageView);
        Glide.with(getContext())
                .load(ReturnImageId())
                .into(image);

    }

   //.........................................................................

    private Integer ReturnImageId(){

        int[][]movImageId={
                {
                        R.mipmap.ic_launcher,
                        R.mipmap.jelo_bazoo_chakoshi,
                        R.mipmap.jelo_bazoo_halter_istade_bamile,
                        R.mipmap.jelo_bazoo_halter_istade_dasbaz,
                        R.mipmap.jelo_bazoo_halter_istadeh_dasbaraks},
                {
                        R.mipmap.ic_launcher,
                        R.mipmap.jelo_bazoo_chakoshi,
                        R.mipmap.jelo_bazoo_halter_istade_bamile,
                        R.mipmap.jelo_bazoo_halter_istade_dasbaz,
                        R.mipmap.jelo_bazoo_halter_istadeh_dasbaraks},
                {
                        R.mipmap.ic_launcher,
                        R.mipmap.jelo_bazoo_chakoshi,
                        R.mipmap.jelo_bazoo_halter_istade_bamile,
                        R.mipmap.jelo_bazoo_halter_istade_dasbaz,
                        R.mipmap.jelo_bazoo_halter_istadeh_dasbaraks},
                {
                        R.mipmap.ic_launcher,
                        R.mipmap.jelo_bazoo_chakoshi,
                        R.mipmap.jelo_bazoo_halter_istade_bamile,
                        R.mipmap.jelo_bazoo_halter_istade_dasbaz,
                        R.mipmap.jelo_bazoo_halter_istadeh_dasbaraks},
                {
                        R.mipmap.ic_launcher,
                        R.mipmap.jelo_bazoo_chakoshi,
                        R.mipmap.jelo_bazoo_halter_istade_bamile,
                        R.mipmap.jelo_bazoo_halter_istade_dasbaz,
                        R.mipmap.jelo_bazoo_halter_istadeh_dasbaraks},
                {
                        R.mipmap.ic_launcher,
                        R.mipmap.jelo_bazoo_chakoshi,
                        R.mipmap.jelo_bazoo_halter_istade_bamile,
                        R.mipmap.jelo_bazoo_halter_istade_dasbaz,
                        R.mipmap.jelo_bazoo_halter_istadeh_dasbaraks}
        };

        return movImageId[MOV][SUBMOV];

    }


    private String ReturnMuscletarget() {


        String[][]SubmovName={
                getResources().getStringArray(R.array. noting),
                getResources().getStringArray(R.array. muscletarget_peres),
                getResources().getStringArray(R.array. muscletarget_sarshaneh ),
                getResources().getStringArray(R.array. muscletarget_jelobazoo ),
                getResources().getStringArray(R.array. muscletarget_poshtbazoo),
                getResources().getStringArray(R.array. muscletarget_zirbaghal ),
                getResources().getStringArray(R.array. muscletarget_kool)};

        return SubmovName[MOV][SUBMOV];


    }


    private String ReturnMovName() {

        String[][]SubmovName={
                getResources().getStringArray(R.array. noting),
                getResources().getStringArray(R.array. peres),
                getResources().getStringArray(R.array. sarshaneh ),
                getResources().getStringArray(R.array. jelobazoo ),
                getResources().getStringArray(R.array. poshtbazoo),
                getResources().getStringArray(R.array. zirbaghal ),
                getResources().getStringArray(R.array. kool)};

        return SubmovName[MOV][SUBMOV];
    }


    private String ReturnEnglishMovName(){
        String[][]EnglishSubmov={
                getResources().getStringArray(R.array. noting),
                getResources().getStringArray(R.array. English_peres),
                getResources().getStringArray(R.array. English_sarshaneh ),
                getResources().getStringArray(R.array. English_jelobazoo ),
                getResources().getStringArray(R.array. English_poshtbazoo),
                getResources().getStringArray(R.array. English_zirbaghal ),
                getResources().getStringArray(R.array. English_kool)};



        return  EnglishSubmov[MOV][SUBMOV];
    }


  //.................................................................................





    //............................................................interface..............
//    public interface SendMessage {
//        void pages(int Pag_number);
//
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//
//        try {
//            SM = (SendMessage) getActivity();
//        } catch (ClassCastException e) {
//
//        }
//    }
//............................................................interface..............


    }


