package com.schoolbook.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.schoolbook.Model.School;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hassa on 09-Jan-18.
 */

public class SchoolsDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="schools.db";
    public static final String TABLE_SCHOOLS="schools";
    public static final String SCHOOLID="id";
    public static final String SCHOOLNAME="schoolname";
    public static final String ADDRESS="address";
    public static final String FEE="fee";
    public static final String XCOORD="xcoord";
    public static final String YCOORD="ycoord";
    public static final String STDTCHRATIO="stdtchratio";
    public static final String ABOUT="about";
    public static final String RATING="rating";
    public static final String RANKING="ranking";


    public SchoolsDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TABLE_SCHOOLS+"("+SCHOOLID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+SCHOOLNAME+" TEXT, "+ADDRESS+" TEXT, "+
                FEE+" INTEGER, "+XCOORD+"  REAL, "+YCOORD+"  REAL, "+STDTCHRATIO+" TEXT, "+ABOUT+" TEXT, "+RATING+" REAL, "+RANKING+" INTEGER "+")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql="DROP TABLE IF EXISTS";
        db.execSQL(sql+TABLE_SCHOOLS);
        onCreate(db);
    }

    public void addSchool(School school){
        ContentValues values=new ContentValues();
        values.put(SCHOOLNAME,school.getSchoolName());
        values.put(ADDRESS,school.getAddress());
        values.put(FEE,school.getFee());
        values.put(XCOORD,school.getX());
        values.put(YCOORD,school.getY());
        values.put(STDTCHRATIO,school.getStdtchratio());
        values.put(ABOUT,school.getAbout());
        values.put(RATING,school.getRating());
        values.put(RANKING,school.getRanking());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_SCHOOLS,null,values);
        db.close();
    }

    public void deleteSchool(String schoolname){
        SQLiteDatabase db=getWritableDatabase();
        String sql="DELETE FROM"+TABLE_SCHOOLS+"WHERE"+SCHOOLNAME+"=\""+schoolname+"\";";
        db.execSQL(sql);
    }

    public List<School> getSchools(){
//        String dbString="";
        List<School> schoolsList=new ArrayList();
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_SCHOOLS +" WHERE 1";
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("schoolname"))!=null){
                School oneschool=new School();
                oneschool.setSchoolID(c.getInt(0));
                oneschool.setSchoolName(c.getString(1));
                oneschool.setAddress(c.getString(2));
                oneschool.setFee(c.getInt(3));
                oneschool.setX(c.getDouble(4));
                oneschool.setY(c.getDouble(5));
                oneschool.setStdtchratio(c.getString(6));
                oneschool.setAbout(c.getString(7));
                oneschool.setRating(c.getDouble(8));
                oneschool.setRanking(c.getInt(9));
                schoolsList.add(oneschool);
            }
            c.moveToNext();
        }
        db.close();
        return schoolsList;
    }

    public List<School> getSchoolsByFee(int Fee){
        List<School> schoolsList=new ArrayList();
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_SCHOOLS +" WHERE FEE <="+Fee;
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("schoolname"))!=null){
                School oneschool=new School();
                oneschool.setSchoolID(c.getInt(0));
                oneschool.setSchoolName(c.getString(1));
                oneschool.setAddress(c.getString(2));
                oneschool.setFee(c.getInt(3));
                oneschool.setX(c.getDouble(4));
                oneschool.setY(c.getDouble(5));
                oneschool.setStdtchratio(c.getString(6));
                oneschool.setAbout(c.getString(7));
                oneschool.setRating(c.getDouble(8));
                oneschool.setRanking(c.getInt(9));
                schoolsList.add(oneschool);
            }
            c.moveToNext();
        }
        db.close();
        return schoolsList;
    }

    public List<School> getTopSchools(){
        List<School> schoolsList=new ArrayList();
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_SCHOOLS +" WHERE RANKING <="+10+" GROUP BY RANKING";
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("schoolname"))!=null){
                School oneschool=new School();
                oneschool.setSchoolID(c.getInt(0));
                oneschool.setSchoolName(c.getString(1));
                oneschool.setAddress(c.getString(2));
                oneschool.setFee(c.getInt(3));
                oneschool.setX(c.getDouble(4));
                oneschool.setY(c.getDouble(5));
                oneschool.setStdtchratio(c.getString(6));
                oneschool.setAbout(c.getString(7));
                oneschool.setRating(c.getDouble(8));
                oneschool.setRanking(c.getInt(9));
                schoolsList.add(oneschool);
            }
            c.moveToNext();
        }
        db.close();
        return schoolsList;
    }

    public School getSchool(String name){
        School oneschool=new School();
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_SCHOOLS +" WHERE "+SCHOOLNAME+"=\""+name+"\";";
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        if(c.getString(c.getColumnIndex("schoolname"))!=null){
            oneschool.setSchoolID(c.getInt(0));
            oneschool.setSchoolName(c.getString(1));
            oneschool.setAddress(c.getString(2));
            oneschool.setFee(c.getInt(3));
            oneschool.setX(c.getDouble(4));
            oneschool.setY(c.getDouble(5));
            oneschool.setStdtchratio(c.getString(6));
            oneschool.setAbout(c.getString(7));
            oneschool.setRating(c.getDouble(8));
            oneschool.setRanking(c.getInt(9));
        }
        db.close();
        return oneschool;
    }

}
