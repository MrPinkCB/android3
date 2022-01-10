package com.example.assignment3.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.assignment3.R;
import com.example.assignment3.databinding.FragmentNotificationsBinding;
import com.example.assignment3.ConstantClass.MyConstantClass;
import com.example.assignment3.ConstantClass.MySharePreferencesClass;

public class NotificationsFragment extends Fragment {
    TextView userNameTextView, valueEnteredTextView, convertedValueTextView;
    MySharePreferencesClass mySharePreferencesClass;

    Double mathValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_notifications, container, false);

        userNameTextView = view.findViewById(R.id.userNameTextView);
        valueEnteredTextView = view.findViewById(R.id.userNumberTextView);
        convertedValueTextView = view.findViewById(R.id.convertedValueTextView);
        mySharePreferencesClass = new MySharePreferencesClass(getContext());
        int numberValue = mySharePreferencesClass.getNumberValue();

        if (numberValue == 0) {
            convertedValueTextView.setText("");
        }
        if(mySharePreferencesClass.getSwitchValue()) {
            mathValue = (1.8 * mySharePreferencesClass.getNumberValue()) + 32;
        } else {
            mathValue = (mySharePreferencesClass.getNumberValue() - 32) / 1.8;
        }
        if (!mySharePreferencesClass.getUserName().isEmpty()) {
            userNameTextView.setText(mySharePreferencesClass.getUserName());
        }
        valueEnteredTextView.setText(String.valueOf(mySharePreferencesClass.getNumberValue()));
        if (mySharePreferencesClass.getSwitchValue()) {
            convertedValueTextView.setText("Fahrenheit : "+String.format("%.2f", mathValue));
        } else {
            convertedValueTextView.setText("Celsius: "+String.format("%.2f", mathValue));
        }
        return view;
    }
}