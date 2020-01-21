package com.geektech.quizapp_gt_4_2.settings;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.main.MainViewModel;

public class SettingsFragment extends Fragment {

    private MainViewModel mViewModel;
    private TextView textView;
    private Button btn1;
    private Button btn2;
    int count1 = 0;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        textView = view.findViewById(R.id.textView);
        btn1 = view.findViewById(R.id.btn);
        btn2 = view.findViewById(R.id.btn2);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this)
                .get(MainViewModel.class);

        mViewModel.message.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("ololo", s);
            }
        });

        mViewModel.text.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView.setText("Count plus " + count1++);
                    }
                });

                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView.setText("Count minus " + count1--);

                    }
                });

            }
        });

    }

}
