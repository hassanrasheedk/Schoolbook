package com.schoolbook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.schoolbook.DAO.SchoolsDB;
import com.schoolbook.Model.School;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.schoolbook.MainActivity.mySchoolsDB;


/**
 * A simple {@link Fragment} subclass.
 */
public class SchoolsByFeeFragment extends Fragment {

    List<School> schools;
    public SchoolsByFeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_schools_by_fee, container, false);
        Spinner feevalspinner=(Spinner) view.findViewById(R.id.feeSpinner);
        String sfeeval=feevalspinner.getSelectedItem().toString();
        int feeval;
        feeval=Integer.parseInt(sfeeval);
        schools=mySchoolsDB.getSchoolsByFee(feeval);
        List<String> schoolnames=new ArrayList();
        Iterator<School> itr=schools.iterator();
        while(itr.hasNext()){
            School aschool=new School();
            aschool=(School)itr.next();
            schoolnames.add(aschool.getSchoolName());
        }
        final ListView listview=(ListView) view.findViewById(R.id.schoolByFeeLV);
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
        Button button = (Button) view.findViewById(R.id.showFee);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Spinner feevalspinner=(Spinner) getView().findViewById(R.id.feeSpinner);
                String sfeeval=feevalspinner.getSelectedItem().toString();
                int feeval;
                feeval=Integer.parseInt(sfeeval);
                schools=mySchoolsDB.getSchoolsByFee(feeval);
                List<String> schoolnames=new ArrayList();
                Iterator<School> itr=schools.iterator();
                while(itr.hasNext()){
                    School aschool=new School();
                    aschool=(School)itr.next();
                    schoolnames.add(aschool.getSchoolName());
                    System.out.println(aschool.getSchoolName());
                }
                ListView listview=(ListView) getView().findViewById(R.id.schoolByFeeLV);
                ArrayAdapter<String> namesAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,schoolnames);
                listview.setAdapter(namesAdapter);
            }
        });

        return view;
    }
}


