package com.example.gym_frag_db2.program.databas;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDatabaseHelper extends SQLiteOpenHelper {
    private String Db_Name ;
    public static final String TBL_NAME="test";

    public myDatabaseHelper( Context context,String Db_Name) {
        super(context, Db_Name, null, 1);

    }

    @Override

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(" CREATE TABLE " + TBL_NAME + "(Id INTEGER PRIMARY KEY AutoIncrement,day INTEGER,mov INTEGER,submov INTEGER,movset INTEGER,minmov INTEGER,maxmov INTEGER)");

        }


    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(db);
    }

    //_________________________________________________________________________________________________
    //تابع اضافه کردن
    public boolean insertData(int day,int mov,int submov,int set,int minmov,int maxmov)
   {

//دیتابیس قابل نوشتن می شود
        SQLiteDatabase db=this.getWritableDatabase();

//برای ایجاد جفت مقدار و شناسه ستون
       ContentValues cv=new ContentValues();


       cv.put("day" ,day);
       cv.put("mov",mov);
       cv.put("submov",submov);
       cv.put("movset",set);
       cv.put("minmov",minmov);
       cv.put("maxmov",maxmov);

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
    public boolean deleteData(String id){

//اتصال به دیتابیس قابل نوشتن
        SQLiteDatabase db=this.getWritableDatabase();

//حذف اطلاعات از دیتابیس
        long result=db.delete(TBL_NAME,"Id=?",new String[] {id});

//بررسی حذف اطلاعات
        if(result==0)
            return false;
        else
            return true;
    }

//_________________________________________________________________________________________


    //تابع آپدیت
    public boolean updateData( int id,int day1,int day11,int set11,int num111,int num211){

//اتصال به دیتابیس قابل نوشتن
        SQLiteDatabase db=this.getWritableDatabase();

//برای ایجاد جفت مقدار و شناسه ستون
        ContentValues cv=new ContentValues();
        cv.put("day1" ,day1 );
        cv.put("day11",day11);  cv.put("set11",set11);  cv.put("num111",num111);  cv.put("num211",num211);


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

