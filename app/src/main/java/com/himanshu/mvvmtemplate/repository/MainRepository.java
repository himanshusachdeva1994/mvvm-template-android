package com.himanshu.mvvmtemplate.repository;

import android.content.Context;
import android.os.Handler;

import com.himanshu.mvvmtemplatelib.repository.BaseRepository;

/**
 * @author : Himanshu Sachdeva
 * @created : 04-Jun-2020
 * @email : himanshu.sachdeva1994@gmail.com
 */
public class MainRepository extends BaseRepository {

    public MainRepository(Context context) {
        super(context);
    }

    public void sendDataToServer(String firstName, String lastName) {
        // Send service call to server
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toastMessage.setValue("Data sent to server:: "+ firstName + " : " + lastName);
            }
        }, 1000);
    }
}
