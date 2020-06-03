package com.himanshu.mvvmtemplatelib.viewmodel;

import android.app.Application;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.himanshu.mvvmtemplatelib.interfaces.DataBindingViewClickCallbacks;

/**
 * @author : Himanshu Sachdeva
 * @created : 03-Jun-2020
 * @email : himanshu.sachdeva1994@gmail.com
 */
public abstract class BaseViewModel extends AndroidViewModel {

    protected final String TAG = getClass().getName();

    protected Context appContext;
    protected DataBindingViewClickCallbacks callback;

    protected final MutableLiveData<String> toastMessage = new MutableLiveData<>();
    private final MediatorLiveData<String> combinedToastMessages = new MediatorLiveData<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
        appContext = application.getApplicationContext();

        combinedToastMessages.addSource(toastMessage, combinedToastMessages::setValue);
        attachRepositoryToastMessageLiveData(setRepositoryToastMessage());
    }

    public void attachCallback(DataBindingViewClickCallbacks callback) {
        this.callback = callback;
    }

    public void onClicked(View view) {
        if (callback != null) {
            callback.onClickEvent(view);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    private void attachRepositoryToastMessageLiveData(LiveData<String> toastMessage) {
        if (toastMessage != null) {
            combinedToastMessages.addSource(toastMessage, combinedToastMessages::setValue);
        }
    }

    /**
     * Override this method to return the repository live data for toastMessage to be attached to View model toastMessage
     *
     * @return MutableLiveData<String>
     */
    protected abstract LiveData<String> setRepositoryToastMessage();

    public LiveData<String> getToastMessages() {
        return combinedToastMessages;
    }
}
