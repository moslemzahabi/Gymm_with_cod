package com.example.gym_frag_db2.program.databas;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDatabaseHelper2 extends SQLiteOpenHelper {
    public static final String DB_NAME ="programlist.db" ;
    public static final String TBL_NAME="Program" ;

    public myDatabaseHelper2(Context context) {
        super(context, DB_NAME, null, 1);

    }

    @Override

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(" CREATE TABLE " + TBL_NAME + "(Id INTEGER PRIMARY KEY AutoIncrement,ProgramName TEXT)");

        }


    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(db);
    }

    //_________________________________________________________________________________________________
    //تابع اضافه کردن
    public boolean insertData(String ProgramName)
   {

//دیتابیس قابل نوشتن می شود
        SQLiteDatabase db=this.getWritableDatabase();

//برای ایجاد جفت مقدار و شناسه ستون
       ContentValues cv=new ContentValues();


       cv.put("ProgramName" ,ProgramName);



//وارد کردن اطلاعات به دیتابیس
        long result=db.insert(TBL_NAME,null,cv);

//بررسی وارد شدن اطلاعات به دیتابیس
        if(result==-1)
            return false;
        else
            return true;
    }
//_________________________________________________________________________________

    //تابع حذف کردن
    public boolean deleteData(int id){

//اتصال به دیتابیس قابل نوشتن
        SQLiteDatabase db=this.getWritableDatabase();

//حذف اطلاعات از دیتابیس
        long result=db.delete(TBL_NAME,"Id=?",new String[] {String.valueOf(id)});

//بررسی حذف اطلاعات
        if(result==0)
            return false;
        else
            return true;
    }

//_________________________________________________________________________________________


    //تابع آپدیت
    public boolean updateData( int id,String DataBaseName){

//اتصال به دیتابیس قابل نوشتن
        SQLiteDatabase db=this.getWritableDatabase();

//برای ایجاد جفت مقدار و شناسه ستون
        ContentValues cv=new ContentValues();
        cv.put("DataBaseName" ,DataBaseName );



//آپدیت اطلاعات دیتابیس
        long result=db.update(TBL_NAME,cv,"Id=?",new String [] {String.valueOf(id)});

//بررسی آپدیت اطلاعات
        if(result<1)
            return false;
        else
            return true;
    }
//__________________________________________________________________________________________


    public Cursor ShowallData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("select * from " + TBL_NAME ,null);

        return result;
    }





}

