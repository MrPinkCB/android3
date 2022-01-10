package com.example.assignment3.ui.dashboard;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;


import com.example.assignment3.ConstantClass.MySharePreferencesClass;
import com.example.assignment3.R;


public class DashboardFragment extends Fragment {
    EditText numericValueEditText;
    SwitchCompat switchBtn;
    Button storeUserNameBtn;
    boolean switchValue = false;
    MySharePreferencesClass mySharePreferencesClass;
    TextView getUserNameTextView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_dashboard, container, false);

        mySharePreferencesClass = new MySharePreferencesClass(getContext());
        numericValueEditText = view.findViewById(R.id.numericValueEditText);
        getUserNameTextView = view.findViewById(R.id.getUserNameTextView);

        switchBtn = view.findViewById(R.id.switchBtn);
        storeUserNameBtn = view.findViewById(R.id.storeUserNameButton);

        getUserNameTextView.setText(mySharePreferencesClass.getUserName());

        switchBtn.setOnCheckedChangeListener((compoundButton, isChecked) -> switchValue = isChecked);
        storeUserNameBtn.setOnClickListener(view1 -> {
                    mySharePreferencesClass.setSwitchValue(switchValue);

                    if (!numericValueEditText.getText().toString().isEmpty()) {
                        mySharePreferencesClass.setNumberValue(Integer.parseInt(numericValueEditText.getText().toString()));
                        popMessage();
                    } else {
                        numericValueEditText.setError("Number cannot be empty!");
                    }

                });
                return view;
        }



    private void popMessage() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.pop_message_layout);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        Button okaBtn = dialog.findViewById(R.id.okBtn);
        okaBtn.setOnClickListener(view -> {
            dialog.dismiss();
        });
        dialog.show();
    }
}


















