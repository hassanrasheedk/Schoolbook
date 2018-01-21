package com.schoolbook;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.schoolbook.DAO.SchoolsDB;
import com.schoolbook.Model.School;

import static com.schoolbook.MainActivity.mySchoolsDB;


import de.hdodenhof.circleimageview.CircleImageView;

public class SchoolDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_detail);

        TextView schoolname=(TextView)findViewById(R.id.schoolname);
        TextView address=(TextView)findViewById(R.id.location);
        TextView fee=(TextView)findViewById(R.id.Fee);
        TextView stchrt=(TextView)findViewById(R.id.stdtchratio);
        TextView about=(TextView)findViewById(R.id.about);
        TextView ranking=(TextView) findViewById(R.id.ranking);
        RatingBar ratingbar=(RatingBar)findViewById(R.id.ratingBar);
        //receiving data from the map
        //title of clicked marker comes here
        String schooltitle="";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            schooltitle = extras.getString("title");
        }
        School thisSchool;
        thisSchool=mySchoolsDB.getSchool(schooltitle);
        schoolname.setText(thisSchool.getSchoolName());
        address.setText(thisSchool.getAddress());
        fee.setText(thisSchool.getFee()+"");
        stchrt.setText(thisSchool.getStdtchratio());
        about.setText(thisSchool.getAbout());
        ranking.setText(thisSchool.getRanking()+"");
        ratingbar.setRating((float)thisSchool.getRating());
        CircleImageView profilepicture=(CircleImageView) findViewById(R.id.profile);
        String uri = "@drawable/r"+thisSchool.getSchoolID();  // where myresource (without the extension) is the file
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res =(Drawable) getDrawable(imageResource);
        profilepicture.setImageDrawable(res);}
//        if(thisSchool.getSchoolID()==1){
//        Drawable res =(Drawable) getDrawable(R.drawable.r1);
//        profilepicture.setImageDrawable(res);}
//        else if(thisSchool.getSchoolID()==2){
//         Drawable res =(Drawable) getDrawable(R.drawable.r2);
//         profilepicture.setImageDrawable(res);}
//        else if(thisSchool.getSchoolID()==3){
//         Drawable res =(Drawable) getDrawable(R.drawable.r3);
//         profilepicture.setImageDrawable(res);}
//        else if(thisSchool.getSchoolID()==4){
//         Drawable res =(Drawable) getDrawable(R.drawable.r4);
//         profilepicture.setImageDrawable(res);}
//        else if(thisSchool.getSchoolID()==5){
//         Drawable res =(Drawable) getDrawable(R.drawable.r5);
//         profilepicture.setImageDrawable(res);}
//        else if(thisSchool.getSchoolID()==6){
//         Drawable res =(Drawable) getDrawable(R.drawable.r6);
//         profilepicture.setImageDrawable(res);}
//        else if(thisSchool.getSchoolID()==7){
//         Drawable res = (Drawable)getDrawable(R.drawable.r7);
//         profilepicture.setImageDrawable(res);}
//        else if(thisSchool.getSchoolID()==8){
//         Drawable res = (Drawable)getDrawable(R.drawable.r8);
//         profilepicture.setImageDrawable(res);}
//        else if(thisSchool.getSchoolID()==9){
//         Drawable res = (Drawable)getDrawable(R.drawable.r9);
//         profilepicture.setImageDrawable(res);}
//        else if(thisSchool.getSchoolID()==10){
//         Drawable res = (Drawable)getDrawable(R.drawable.r10);
//         profilepicture.setImageDrawable(res);}
//        else if(thisSchool.getSchoolID()==11){
//         Drawable res = (Drawable)getDrawable(R.drawable.r11);
//         profilepicture.setImageDrawable(res);}
//        else if(thisSchool.getSchoolID()==12){
//         Drawable res = (Drawable)getDrawable(R.drawable.r12);
//         profilepicture.setImageDrawable(res);}
//        else if(thisSchool.getSchoolID()==13){
//         Drawable res = (Drawable)getDrawable(R.drawable.r13);
//         profilepicture.setImageDrawable(res);
//        }
//    }

}
