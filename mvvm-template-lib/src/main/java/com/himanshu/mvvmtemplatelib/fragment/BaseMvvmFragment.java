package com.himanshu.mvvmtemplatelib.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.himanshu.mvvmtemplatelib.interfaces.DataBindingViewClickCallbacks;
import com.himanshu.mvvmtemplatelib.viewmodel.BaseViewModel;

/**
 * @author : Himanshu Sachdeva
 * @created : 04-Jun-2020
 * @email : himanshu.sachdeva1994@gmail.com
 */
public abstract class BaseMvvmFragment<VM extends BaseViewModel, VB extends ViewDataBinding> extends BaseFragment implements DataBindingViewClickCallbacks {

    protected VM viewModel;
    protected VB binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewBinding();
        viewModel = getViewModel();
        viewModel.attachCallback(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        observeOnToastMessages();
    }

    private void observeOnToastMessages() {
        viewModel.getToastMessages().observe(getViewLifecycleOwner(), toastMessage -> Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show());
    }

    protected abstract VB getViewBinding();

    protected abstract VM getViewModel();

    @Override
    public void onClickEvent(View view) {
    }
}
