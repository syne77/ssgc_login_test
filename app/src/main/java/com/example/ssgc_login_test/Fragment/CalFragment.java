package com.example.ssgc_login_test.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ssgc_login_test.R;

public class CalFragment extends Fragment {

    private EditText subjectName, subjectCredit, subjectGrade;
    private TextView averageGrade;
    private Button addButton;

    private double totalGrade = 0;
    private double totalCredit = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cal, container, false);

        subjectName = rootView.findViewById(R.id.subject_name);
        subjectCredit = rootView.findViewById(R.id.subject_credit);
        subjectGrade = rootView.findViewById(R.id.subject_grade);
        averageGrade = rootView.findViewById(R.id.average_grade);
        addButton = rootView.findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGrade();
            }
        });

        return rootView;
    }

    private void addGrade() {
        double credit = Double.parseDouble(subjectCredit.getText().toString());
        double grade = Double.parseDouble(subjectGrade.getText().toString());

        totalGrade += (credit * grade);
        totalCredit += credit;

        double average = totalGrade / totalCredit;
        averageGrade.setText("평균 성적 평점: " + average);

        // 입력 필드 초기화
        subjectName.setText("");
        subjectCredit.setText("");
        subjectGrade.setText("");
    }
}
