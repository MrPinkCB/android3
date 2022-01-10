package com.example.assignment3.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.assignment3.R;
import com.example.assignment3.databinding.FragmentHomeBinding;
import com.example.assignment3.ConstantClass.MySharePreferencesClass;

public class HomeFragment extends Fragment {

    EditText userNameEditText;
    Button storeUserNameBtn;
    MySharePreferencesClass mySharePreferencesClass;
    Context mContext;
    ConstraintLayout cLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_home, container, false);
        mySharePreferencesClass = new MySharePreferencesClass(getContext());
        userNameEditText = view.findViewById(R.id.userNameEditText);
        storeUserNameBtn = view.findViewById(R.id.storeUserNameBtn);
        storeUserNameBtn.setOnClickListener(view1 -> {
            mySharePreferencesClass.setUserName(userNameEditText.getText().toString());
        });
        return view;
    }
}

