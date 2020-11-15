package com.himanshu.mvvmtemplate.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;

import com.himanshu.mvvmtemplate.R;
import com.himanshu.mvvmtemplate.model.screenstate.MainScreenState;
import com.himanshu.mvvmtemplate.repository.MainRepository;
import com.himanshu.mvvmtemplatelib.viewmodel.BaseViewModel;

/**
 * @author : Himanshu Sachdeva
 * @created : 04-Jun-2020
 * @email : himanshu.sachdeva1994@gmail.com
 */
public class MainViewModel extends BaseViewModel {

    private MainRepository mainRepository;
    private MainScreenState screenState;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void initRepositoryData() {
        mainRepository = new MainRepository(appContext);
        attachRepositoryToastMessageLiveData(mainRepository.getToastMessage());
        attachRepositoryServiceCallStatusLiveData(mainRepository.getServiceCallStatus());
    }

    public MainScreenState getScreenState() {
        return screenState;
    }

    public void setScreenState(MainScreenState screenState) {
        this.screenState = screenState;
    }

    @Override
    public void onClicked(View view) {
        super.onClicked(view);

        if (view.getId() == R.id.btn_submit) {
            if (screenState.getFirstName() == null || screenState.getFirstName().isEmpty()) {
                toastMessage.setValue(appContext.getString(R.string.validation_first_name));
            } else if (screenState.getLastName() == null || screenState.getLastName().isEmpty()) {
                toastMessage.setValue(appContext.getString(R.string.validation_last_name));
            } else {
                mainRepository.sendDataToServer(screenState.getFirstName(), screenState.getLastName());
            }
        }
    }
}
