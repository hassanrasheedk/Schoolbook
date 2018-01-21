package com.schoolbook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.schoolbook.Model.School;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.schoolbook.MainActivity.mySchoolsDB;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopSchoolsFragment extends Fragment {

    List<School> schools;
    public TopSchoolsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_top_schools, container, false);
        schools=mySchoolsDB.getTopSchools();
        List<String> schoolnames=new ArrayList();
        Iterator<School> itr=schools.iterator();
        while(itr.hasNext()){
            School aschool=new School();
            aschool=(School)itr.next();
            schoolnames.add(aschool.getSchoolName());;
        }
        final ListView listview=(ListView) view.findViewById(R.id.TopSchoolsLV);
        ArrayAdapter<String> namesAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,schoolnames);
        listview.setAdapter(namesAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String title=(String)listview.getItemAtPosition(i);
                Intent schoolDetails=new Intent(getContext(), SchoolDetail.class);
                schoolDetails.putExtra("title", title);
                startActivity(schoolDetails);
            }
        });
        return view;
    }

}
