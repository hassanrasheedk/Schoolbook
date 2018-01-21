package com.schoolbook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        Button nearbybutton = (Button) view.findViewById(R.id.nearbyhomebutton);
        nearbybutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(getContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        Button allschoolsbutton = (Button) view.findViewById(R.id.allschoolsbutton);
        allschoolsbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AllSchoolsFragment fragment=new AllSchoolsFragment();
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,fragment);
                fragmentTransaction.commit();
            }
        });

        Button feeButton = (Button) view.findViewById(R.id.byfeehomebutton);
        feeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SchoolsByFeeFragment fragment=new SchoolsByFeeFragment();
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,fragment);
                fragmentTransaction.commit();
            }
        });

        Button topButton = (Button) view.findViewById(R.id.topschoolshomebutton);
        topButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TopSchoolsFragment fragment=new TopSchoolsFragment();
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,fragment);
                fragmentTransaction.commit();
            }
        });



        return view;
    }

    public void onNearby(View view){
        Intent intent=new Intent(getContext(),MapsActivity.class);
        startActivity(intent);
    }
    public void byFee(View view){
        SchoolsByFeeFragment fragment=new SchoolsByFeeFragment();
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container,fragment);
        fragmentTransaction.commit();
    }
    public void topSchools(View view){
        TopSchoolsFragment fragment=new TopSchoolsFragment();
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container,fragment);
        fragmentTransaction.commit();
    }

}
