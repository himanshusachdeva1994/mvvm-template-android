package com.himanshu.mvvmtemplatelib.interfaces;

import android.view.View;

/**
 * @author : Himanshu Sachdeva
 * @created : 03-Jun-2020
 * @email : himanshu.sachdeva1994@gmail.com
 */
public interface ItemClickListener {

    void onItemClick(View view, int position);

    void onItemLongClick(View view, int position);
}
