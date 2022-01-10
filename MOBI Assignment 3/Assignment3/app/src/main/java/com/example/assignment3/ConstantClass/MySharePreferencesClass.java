package com.example.assignment3.ConstantClass;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.assignment3.ConstantClass.MyConstantClass;

public class MySharePreferencesClass {
    Context context;
    SharedPreferences sharedPreferencesClass;
    SharedPreferences.Editor editor;


    public MySharePreferencesClass(Context context) {
        this.context = context;
        sharedPreferencesClass = context.getSharedPreferences(MyConstantClass.SharedPreferenceValue, Context.MODE_PRIVATE);
    }

    public void setUserName(String userName) {
        editor  = sharedPreferencesClass.edit();
        editor.putString(MyConstantClass.UserNameValue, userName);
        editor.apply();
    }

    public String getUserName() {
        return sharedPreferencesClass.getString(MyConstantClass.UserNameValue, "0");
    }

    public void setNumberValue(int userName) {
        editor = sharedPreferencesClass.edit();
        editor.putInt(MyConstantClass.NumberValue, userName);
        editor.apply();
    }

    public int getNumberValue(){
        return sharedPreferencesClass.getInt(MyConstantClass.NumberValue, 0);
    }

    public void setSwitchValue(Boolean switchValue) {
        editor = sharedPreferencesClass.edit();
        editor.putBoolean(MyConstantClass.SwitchValue, switchValue);
        editor.commit();
        editor.apply();
    }

    public boolean getSwitchValue() {
        return sharedPreferencesClass.getBoolean(MyConstantClass.SwitchValue, false);
    }



}
