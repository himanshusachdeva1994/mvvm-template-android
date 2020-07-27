package com.himanshu.mvvmtemplatelib.activity;

import android.content.Context;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.himanshu.mvvmtemplatelib.interfaces.ItemClickListener;

/**
 * @author : Himanshu Sachdeva
 * @created : 03-Jun-2020
 * @email : himanshu.sachdeva1994@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity implements ItemClickListener {

    protected Context context = this;
    protected final String TAG = getClass().getName();

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
