package com.himanshu.mvvmtemplatelib.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * @author : Himanshu Sachdeva
 * @created : 03-Jun-2020
 * @email : himanshu.sachdeva1994@gmail.com
 */
public abstract class BaseRepository {

    protected final String TAG = getClass().getName();
    protected final Context context;

    protected MutableLiveData<String> toastMessage = new MutableLiveData<>();

    public BaseRepository(Context context) {
        this.context = context;
    }

    public LiveData<String> getToastMessage() {
        return toastMessage;
    }
}
