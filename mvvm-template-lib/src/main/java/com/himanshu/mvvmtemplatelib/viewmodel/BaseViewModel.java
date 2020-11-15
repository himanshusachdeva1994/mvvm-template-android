package com.himanshu.mvvmtemplatelib.viewmodel;

import android.app.Application;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.himanshu.mvvmtemplatelib.constant.ServiceCallStatusConstants;
import com.himanshu.mvvmtemplatelib.interfaces.DataBindingViewClickCallbacks;

import java.util.ArrayList;

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

    protected final MediatorLiveData<ServiceCallStatusConstants> combinedServiceCallStatus = new MediatorLiveData<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
        appContext = application.getApplicationContext();

        combinedToastMessages.addSource(toastMessage, combinedToastMessages::setValue);
        initRepositoryData();
    }

    protected abstract void initRepositoryData();

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

    protected void attachRepositoryToastMessageLiveData(LiveData<String> toastMessage) {
        if (toastMessage != null) {
            combinedToastMessages.addSource(toastMessage, combinedToastMessages::setValue);
        }
    }

    protected void attachRepositoryToastMessageLiveData(ArrayList<LiveData<String>> toastMessages) {
        if (toastMessages != null && toastMessages.size() > 0) {
            for (LiveData<String> toastMessage : toastMessages) {
                combinedToastMessages.addSource(toastMessage, combinedToastMessages::setValue);
            }
        }
    }

    protected void attachRepositoryServiceCallStatusLiveData(LiveData<ServiceCallStatusConstants> serviceCallStatus) {
        combinedServiceCallStatus.addSource(serviceCallStatus, combinedServiceCallStatus::setValue);
    }

    protected void attachRepositoryServiceCallStatusLiveData(ArrayList<LiveData<ServiceCallStatusConstants>> serviceCallStatusList) {
        if (serviceCallStatusList != null && serviceCallStatusList.size() > 0) {
            for (LiveData<ServiceCallStatusConstants> serviceCallStatus : serviceCallStatusList) {
                combinedServiceCallStatus.addSource(serviceCallStatus, combinedServiceCallStatus::setValue);
            }
        }
    }

    public LiveData<String> getToastMessages() {
        return combinedToastMessages;
    }

    public LiveData<ServiceCallStatusConstants> getServiceCallStatus() {
        return combinedServiceCallStatus;
    }
}
