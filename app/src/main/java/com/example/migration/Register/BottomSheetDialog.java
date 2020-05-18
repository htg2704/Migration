package com.example.migration.Register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.migration.MainActivity;
import com.example.migration.R;
import com.example.migration.common.User;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_layout,container,false);


        CardView button =v.findViewById(R.id.btn_vol);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.type=1;
                startActivity(new Intent(getActivity(),com.example.migration.Questions.questions.class));
                dismiss();
            }
        });

        CardView button1 =v.findViewById(R.id.btn_cmob);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.type=2;
                startActivity(new Intent(getActivity(), com.example.migration.Register.LoginOrRegister.class));
                dismiss();
            }
        });

        CardView button2 =v.findViewById(R.id.btn_ngo);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.type=3;
                startActivity(new Intent(getActivity(),com.example.migration.Register.LoginOrRegister.class));
                dismiss();
            }
        });

        return v;
    }
}
