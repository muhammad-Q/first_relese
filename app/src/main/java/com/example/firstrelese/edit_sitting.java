package com.example.firstrelese;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class edit_sitting extends Fragment {

    private EditSittingViewModel mViewModel;

    public static edit_sitting newInstance() {
        return new edit_sitting ();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate ( R.layout.edit_sitting_fragment, container, false );
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated ( savedInstanceState );
        mViewModel = ViewModelProviders.of ( this ).get ( EditSittingViewModel.class );
        // TODO: Use the ViewModel
    }

}
