package com.himanshu.mvvmtemplatelib.fragment;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.himanshu.mvvmtemplatelib.interfaces.ItemClickListener;

/**
 * @author : Himanshu Sachdeva
 * @created : 04-Jun-2020
 * @email : himanshu.sachdeva1994@gmail.com
 */
public abstract class BaseFragment extends Fragment implements ItemClickListener {

    protected Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
