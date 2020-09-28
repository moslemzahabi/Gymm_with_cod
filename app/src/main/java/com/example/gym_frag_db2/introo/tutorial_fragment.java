package com.example.gym_frag_db2.introo;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.gym_frag_db2.Activity.MainActivity;
import com.example.gym_frag_db2.R;


public class tutorial_fragment extends Fragment  {

  //  SendMessage SM;

    ViewPager viewPager;
    LinearLayout layoutDots;
    Button btNext,btnSkip;
    SliderPagerAdapter pagerAdapter;

    int[]layoutIds={R.layout.tutorial_slide1,R.layout.tutorial_slide2,
            R.layout.tutorial_slide3,R.layout.tutorial_slide4};



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.tutorial_fragment, container, false);


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

         init(view);




        // if (!prefMan.startSlider()){  lunchMainScreen(); return; }



        viewPager.setAdapter(pagerAdapter);
        ShowDots(viewPager.getCurrentItem());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }
            @Override
            public void onPageSelected(int position) {

                ShowDots(position);

                if(position==viewPager.getAdapter().getCount()-1){
                    btnSkip.setVisibility(View.GONE);
                    btNext.setText("GotIt");
                }
                else{
                    btnSkip.setVisibility(View.VISIBLE);
                    btNext.setText("next");
                }

            }


            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              lunchMainScreen();
            }});



        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPage=viewPager.getCurrentItem();
                int pages=viewPager.getAdapter().getCount()-1;
                if(currentPage==pages){
                    donot();
                   lunchMainScreen();
                }
                else{
                    viewPager.setCurrentItem(currentPage+1);
                }
            }});

    }

    private void init(View view) {

        viewPager=view.findViewById(R.id.viewPager);
        layoutDots=view.findViewById(R.id.layoutDots);
        btNext    =view.findViewById(R.id.bt_next   );
        btnSkip   =view.findViewById(R.id.bt_skip   );
        pagerAdapter=new SliderPagerAdapter();


    }

    private void ShowDots(int pageNumber){

        TextView[]dots=new TextView[layoutIds.length];
        layoutDots.removeAllViews();//....باعث میشود نقطه ها زیاد نشود................
        for(int i=0;i<dots.length;i++){
            dots[i]=new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
            dots[i].setTextColor(ContextCompat.getColor(getContext(),
                    i==pageNumber ? R.color.dot_active:R.color.dot_inactive));//...impooooooooooooooooooooooooooooooooooooooooooooooortant
            layoutDots.addView(dots[i]);
        }


    }
    //....................................................................
        private void lunchMainScreen() {
        //    SM.pages(6);
            ((MainActivity)getContext()).pages(6);

    }

   //.........................................................................
   private void donot() {
      //  PrefManager prefMan=new PrefManager(this); prefMan.setNewTableName("tutorialslider",false);
    }

  //.................................................................................







    public class SliderPagerAdapter extends PagerAdapter {



        @Override
        public Object instantiateItem( ViewGroup container, int position) {

            View view= LayoutInflater.from(getContext())
                    .inflate(layoutIds[position],container,false);
            container.addView(view);

            return  view;
        }

        @Override
        public int getCount() {
            return layoutIds.length;
        }

        @Override
        public boolean isViewFromObject( View view,  Object object) {
            return view==object;
        }

        @Override
        public void destroyItem( ViewGroup container, int position,  Object object) {
            View view=(View)object;
            container.removeView(view);
        }


    }




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


