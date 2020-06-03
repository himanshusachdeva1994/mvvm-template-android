package com.himanshu.mvvmtemplate.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.himanshu.mvvmtemplate.databinding.ActivityMainBinding;
import com.himanshu.mvvmtemplate.model.screenstate.MainScreenState;
import com.himanshu.mvvmtemplate.viewmodel.MainViewModel;
import com.himanshu.mvvmtemplatelib.activity.BaseMvvmActivity;

/**
 * @author : Himanshu Sachdeva
 * @created : 04-Jun-2020
 * @email : himanshu.sachdeva1994@gmail.com
 */
public class MainActivity extends BaseMvvmActivity<MainViewModel, ActivityMainBinding> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.setViewModel(viewModel);
        binding.setHandler(viewModel);
    }

    @Override
    protected ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected MainViewModel getViewModel() {
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.setScreenState(new MainScreenState());
        return viewModel;
    }
}
