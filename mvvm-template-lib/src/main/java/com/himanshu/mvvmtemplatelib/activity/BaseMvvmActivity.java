package com.himanshu.mvvmtemplatelib.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.himanshu.mvvmtemplatelib.interfaces.DataBindingViewClickCallbacks;
import com.himanshu.mvvmtemplatelib.viewmodel.BaseViewModel;

/**
 * @author : Himanshu Sachdeva
 * @created : 03-Jun-2020
 * @email : himanshu.sachdeva1994@gmail.com
 */
public abstract class BaseMvvmActivity<VM extends BaseViewModel, VB extends ViewDataBinding> extends BaseActivity implements DataBindingViewClickCallbacks {

    protected VM viewModel;
    protected VB binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewBinding();
        viewModel = getViewModel();
        viewModel.attachCallback(this);

        observeOnToastMessages();
    }

    private void observeOnToastMessages() {
        viewModel.getToastMessages().observe(this, toastMessage -> Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show());
    }

    protected abstract VB getViewBinding();

    protected abstract VM getViewModel();

    @Override
    public void onClickEvent(View view) {
    }
}
