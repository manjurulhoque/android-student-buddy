package com.example.rumi.studentbuddy;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.rumi.studentbuddy.Fragments.AlertDialogFragment;

public class CgpaActivity extends AppCompatActivity {

    private Button newSemesterButton;
    private Button calculateCgpaButton;
    private LinearLayout linearLayoutOne, linearLayoutSingleTwo, linearLayoutSingleThree, linearLayoutSingleFour,
            linearLayoutSingleFive, linearLayoutSingleSix, linearLayoutSingleSeven, linearLayoutSingleEight,
            linearLayoutSingleNine, linearLayoutSingleTen, linearLayoutSingleEleven, linearLayoutSingleTwelve, linearLayoutSingleThirteen;
    private RelativeLayout relativeLayoutParent, relativeLayoutLast;
    RelativeLayout.LayoutParams layoutParams;
    private EditText creditOne, creditTwo, creditThree, creditFour, creditFive, creditSix, creditSeven, creditEight,
            creditNine, creditTen, creditEleven, creditTwelve;
    private EditText sgpaOne, sgpaTwo, sgpaThree, sgpaFour, sgpaFive, sgpaSix, sgpaSeven, sgpaEight,
            sgpaNine, sgpaTen, sgpaEleven, sgpaTwelve;
    int i = 2;
    int j = 1;
    int[] credits = new int[11];
    double[] sgpas = new double[11];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);

        init();

        layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        newSemesterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newButtonClicked();
            }
        });

        calculateCgpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCgpa();
            }
        });
    }

    private void calculateCgpa() {
        if (j == 1) {
            credits[0] = Integer.parseInt(creditOne.getText().toString());
            sgpas[0] = Double.parseDouble(sgpaOne.getText().toString());
        } else if (j == 2) {
            credits[0] = Integer.parseInt(creditOne.getText().toString());
            sgpas[0] = Double.parseDouble(sgpaOne.getText().toString());
            credits[1] = Integer.parseInt(creditTwo.getText().toString());
            sgpas[1] = Double.parseDouble(sgpaTwo.getText().toString());
        } else if (j == 3) {
            credits[0] = Integer.parseInt(creditOne.getText().toString());
            sgpas[0] = Double.parseDouble(sgpaOne.getText().toString());
            credits[1] = Integer.parseInt(creditTwo.getText().toString());
            sgpas[1] = Double.parseDouble(sgpaTwo.getText().toString());
            credits[2] = Integer.parseInt(creditThree.getText().toString());
            sgpas[2] = Double.parseDouble(sgpaThree.getText().toString());
        } else if (j == 4) {
            credits[0] = Integer.parseInt(creditOne.getText().toString());
            sgpas[0] = Double.parseDouble(sgpaOne.getText().toString());
            credits[1] = Integer.parseInt(creditTwo.getText().toString());
            sgpas[1] = Double.parseDouble(sgpaTwo.getText().toString());
            credits[2] = Integer.parseInt(creditThree.getText().toString());
            sgpas[2] = Double.parseDouble(sgpaThree.getText().toString());
            credits[3] = Integer.parseInt(creditFour.getText().toString());
            sgpas[3] = Double.parseDouble(sgpaFour.getText().toString());
        } else if (j == 5) {
            credits[0] = Integer.parseInt(creditOne.getText().toString());
            sgpas[0] = Double.parseDouble(sgpaOne.getText().toString());
            credits[1] = Integer.parseInt(creditTwo.getText().toString());
            sgpas[1] = Double.parseDouble(sgpaTwo.getText().toString());
            credits[2] = Integer.parseInt(creditThree.getText().toString());
            sgpas[2] = Double.parseDouble(sgpaThree.getText().toString());
            credits[3] = Integer.parseInt(creditFour.getText().toString());
            sgpas[3] = Double.parseDouble(sgpaFour.getText().toString());
            credits[4] = Integer.parseInt(creditFive.getText().toString());
            sgpas[4] = Double.parseDouble(sgpaFive.getText().toString());
        } else if (j == 6) {
            credits[0] = Integer.parseInt(creditOne.getText().toString());
            sgpas[0] = Double.parseDouble(sgpaOne.getText().toString());
            credits[1] = Integer.parseInt(creditTwo.getText().toString());
            sgpas[1] = Double.parseDouble(sgpaTwo.getText().toString());
            credits[2] = Integer.parseInt(creditThree.getText().toString());
            sgpas[2] = Double.parseDouble(sgpaThree.getText().toString());
            credits[3] = Integer.parseInt(creditFour.getText().toString());
            sgpas[3] = Double.parseDouble(sgpaFour.getText().toString());
            credits[4] = Integer.parseInt(creditFive.getText().toString());
            sgpas[4] = Double.parseDouble(sgpaFive.getText().toString());
            credits[5] = Integer.parseInt(creditSix.getText().toString());
            sgpas[5] = Double.parseDouble(sgpaSix.getText().toString());
        } else if (j == 7) {
            credits[0] = Integer.parseInt(creditOne.getText().toString());
            sgpas[0] = Double.parseDouble(sgpaOne.getText().toString());
            credits[1] = Integer.parseInt(creditTwo.getText().toString());
            sgpas[1] = Double.parseDouble(sgpaTwo.getText().toString());
            credits[2] = Integer.parseInt(creditThree.getText().toString());
            sgpas[2] = Double.parseDouble(sgpaThree.getText().toString());
            credits[3] = Integer.parseInt(creditFour.getText().toString());
            sgpas[3] = Double.parseDouble(sgpaFour.getText().toString());
            credits[4] = Integer.parseInt(creditFive.getText().toString());
            sgpas[4] = Double.parseDouble(sgpaFive.getText().toString());
            credits[5] = Integer.parseInt(creditSix.getText().toString());
            sgpas[5] = Double.parseDouble(sgpaSix.getText().toString());
            credits[6] = Integer.parseInt(creditSeven.getText().toString());
            sgpas[6] = Double.parseDouble(sgpaSeven.getText().toString());
        } else if (j == 8) {
            credits[0] = Integer.parseInt(creditOne.getText().toString());
            sgpas[0] = Double.parseDouble(sgpaOne.getText().toString());
            credits[1] = Integer.parseInt(creditTwo.getText().toString());
            sgpas[1] = Double.parseDouble(sgpaTwo.getText().toString());
            credits[2] = Integer.parseInt(creditThree.getText().toString());
            sgpas[2] = Double.parseDouble(sgpaThree.getText().toString());
            credits[3] = Integer.parseInt(creditFour.getText().toString());
            sgpas[3] = Double.parseDouble(sgpaFour.getText().toString());
            credits[4] = Integer.parseInt(creditFive.getText().toString());
            sgpas[4] = Double.parseDouble(sgpaFive.getText().toString());
            credits[5] = Integer.parseInt(creditSix.getText().toString());
            sgpas[5] = Double.parseDouble(sgpaSix.getText().toString());
            credits[6] = Integer.parseInt(creditSeven.getText().toString());
            sgpas[6] = Double.parseDouble(sgpaSeven.getText().toString());
            credits[7] = Integer.parseInt(creditEight.getText().toString());
            sgpas[7] = Double.parseDouble(sgpaEight.getText().toString());
        } else if (j == 9) {
            credits[0] = Integer.parseInt(creditOne.getText().toString());
            sgpas[0] = Double.parseDouble(sgpaOne.getText().toString());
            credits[1] = Integer.parseInt(creditTwo.getText().toString());
            sgpas[1] = Double.parseDouble(sgpaTwo.getText().toString());
            credits[2] = Integer.parseInt(creditThree.getText().toString());
            sgpas[2] = Double.parseDouble(sgpaThree.getText().toString());
            credits[3] = Integer.parseInt(creditFour.getText().toString());
            sgpas[3] = Double.parseDouble(sgpaFour.getText().toString());
            credits[4] = Integer.parseInt(creditFive.getText().toString());
            sgpas[4] = Double.parseDouble(sgpaFive.getText().toString());
            credits[5] = Integer.parseInt(creditSix.getText().toString());
            sgpas[5] = Double.parseDouble(sgpaSix.getText().toString());
            credits[6] = Integer.parseInt(creditSeven.getText().toString());
            sgpas[6] = Double.parseDouble(sgpaSeven.getText().toString());
            credits[7] = Integer.parseInt(creditEight.getText().toString());
            sgpas[7] = Double.parseDouble(sgpaEight.getText().toString());
            credits[8] = Integer.parseInt(creditNine.getText().toString());
            sgpas[8] = Double.parseDouble(sgpaNine.getText().toString());
        } else if (j == 10) {
            credits[0] = Integer.parseInt(creditOne.getText().toString());
            sgpas[0] = Double.parseDouble(sgpaOne.getText().toString());
            credits[1] = Integer.parseInt(creditTwo.getText().toString());
            sgpas[1] = Double.parseDouble(sgpaTwo.getText().toString());
            credits[2] = Integer.parseInt(creditThree.getText().toString());
            sgpas[2] = Double.parseDouble(sgpaThree.getText().toString());
            credits[3] = Integer.parseInt(creditFour.getText().toString());
            sgpas[3] = Double.parseDouble(sgpaFour.getText().toString());
            credits[4] = Integer.parseInt(creditFive.getText().toString());
            sgpas[4] = Double.parseDouble(sgpaFive.getText().toString());
            credits[5] = Integer.parseInt(creditSix.getText().toString());
            sgpas[5] = Double.parseDouble(sgpaSix.getText().toString());
            credits[6] = Integer.parseInt(creditSeven.getText().toString());
            sgpas[6] = Double.parseDouble(sgpaSeven.getText().toString());
            credits[7] = Integer.parseInt(creditEight.getText().toString());
            sgpas[7] = Double.parseDouble(sgpaEight.getText().toString());
            credits[8] = Integer.parseInt(creditNine.getText().toString());
            sgpas[8] = Double.parseDouble(sgpaNine.getText().toString());
            credits[9] = Integer.parseInt(creditTen.getText().toString());
            sgpas[9] = Double.parseDouble(sgpaTen.getText().toString());
        } else if (j == 11) {
            credits[0] = Integer.parseInt(creditOne.getText().toString());
            sgpas[0] = Double.parseDouble(sgpaOne.getText().toString());
            credits[1] = Integer.parseInt(creditTwo.getText().toString());
            sgpas[1] = Double.parseDouble(sgpaTwo.getText().toString());
            credits[2] = Integer.parseInt(creditThree.getText().toString());
            sgpas[2] = Double.parseDouble(sgpaThree.getText().toString());
            credits[3] = Integer.parseInt(creditFour.getText().toString());
            sgpas[3] = Double.parseDouble(sgpaFour.getText().toString());
            credits[4] = Integer.parseInt(creditFive.getText().toString());
            sgpas[4] = Double.parseDouble(sgpaFive.getText().toString());
            credits[5] = Integer.parseInt(creditSix.getText().toString());
            sgpas[5] = Double.parseDouble(sgpaSix.getText().toString());
            credits[6] = Integer.parseInt(creditSeven.getText().toString());
            sgpas[6] = Double.parseDouble(sgpaSeven.getText().toString());
            credits[7] = Integer.parseInt(creditEight.getText().toString());
            sgpas[7] = Double.parseDouble(sgpaEight.getText().toString());
            credits[8] = Integer.parseInt(creditNine.getText().toString());
            sgpas[8] = Double.parseDouble(sgpaNine.getText().toString());
            credits[9] = Integer.parseInt(creditTen.getText().toString());
            sgpas[9] = Double.parseDouble(sgpaTen.getText().toString());
            credits[10] = Integer.parseInt(creditEleven.getText().toString());
            sgpas[10] = Double.parseDouble(sgpaEleven.getText().toString());
        } else if (j == 12) {
            credits[0] = Integer.parseInt(creditOne.getText().toString());
            sgpas[0] = Double.parseDouble(sgpaOne.getText().toString());
            credits[1] = Integer.parseInt(creditTwo.getText().toString());
            sgpas[1] = Double.parseDouble(sgpaTwo.getText().toString());
            credits[2] = Integer.parseInt(creditThree.getText().toString());
            sgpas[2] = Double.parseDouble(sgpaThree.getText().toString());
            credits[3] = Integer.parseInt(creditFour.getText().toString());
            sgpas[3] = Double.parseDouble(sgpaFour.getText().toString());
            credits[4] = Integer.parseInt(creditFive.getText().toString());
            sgpas[4] = Double.parseDouble(sgpaFive.getText().toString());
            credits[5] = Integer.parseInt(creditSix.getText().toString());
            sgpas[5] = Double.parseDouble(sgpaSix.getText().toString());
            credits[6] = Integer.parseInt(creditSeven.getText().toString());
            sgpas[6] = Double.parseDouble(sgpaSeven.getText().toString());
            credits[7] = Integer.parseInt(creditEight.getText().toString());
            sgpas[7] = Double.parseDouble(sgpaEight.getText().toString());
            credits[8] = Integer.parseInt(creditNine.getText().toString());
            sgpas[8] = Double.parseDouble(sgpaNine.getText().toString());
            credits[9] = Integer.parseInt(creditTen.getText().toString());
            sgpas[9] = Double.parseDouble(sgpaTen.getText().toString());
            credits[10] = Integer.parseInt(creditEleven.getText().toString());
            sgpas[10] = Double.parseDouble(sgpaEleven.getText().toString());
            credits[11] = Integer.parseInt(creditTwelve.getText().toString());
            sgpas[11] = Double.parseDouble(sgpaTwelve.getText().toString());
        }

        int totalCredit = 0;
        double finalCgpa = 0.0;
        double temp = 0.0;
        double totalSgpa = 0.0;
        int totalSemester = 0;

        for (int k = 0; k < credits.length; k++) {
            if(credits[k] != 0.0 && sgpas[k] != 0.0){
                temp += (double) (credits[k] * sgpas[k]);
                totalCredit += credits[k];
                totalSgpa += sgpas[k];
                totalSemester += 1;
            }
        }
        finalCgpa = (temp / totalCredit);

        AlertDialogFragment dialogFragment = new AlertDialogFragment();
        Bundle args = new Bundle();
        args.putDouble("totalSgpa", totalSgpa);
        args.putDouble("totalCgpa", finalCgpa);
        args.putDouble("totalCredit", totalCredit);
        args.putInt("totalSemester", totalSemester);
        dialogFragment.setArguments(args);
        dialogFragment.show(getSupportFragmentManager(), "dialog");

        Toast.makeText(this, String.valueOf(finalCgpa), Toast.LENGTH_SHORT).show();
    }

    private void init() {
        relativeLayoutLast = findViewById(R.id.relativeLayoutLast);
        linearLayoutOne = findViewById(R.id.linearLayoutOne);
        linearLayoutSingleTwo = findViewById(R.id.linearLayoutSingleTwo);
        linearLayoutSingleThree = findViewById(R.id.linearLayoutSingleThree);
        linearLayoutSingleFour = findViewById(R.id.linearLayoutSingleFour);
        linearLayoutSingleFive = findViewById(R.id.linearLayoutSingleFive);
        linearLayoutSingleSix = findViewById(R.id.linearLayoutSingleSix);
        linearLayoutSingleSeven = findViewById(R.id.linearLayoutSingleSeven);
        linearLayoutSingleEight = findViewById(R.id.linearLayoutSingleEight);
        linearLayoutSingleNine = findViewById(R.id.linearLayoutSingleNine);
        linearLayoutSingleTen = findViewById(R.id.linearLayoutSingleTen);
        linearLayoutSingleEleven = findViewById(R.id.linearLayoutSingleEleven);
        linearLayoutSingleTwelve = findViewById(R.id.linearLayoutSingleTwelve);
        linearLayoutSingleThirteen = findViewById(R.id.linearLayoutSingleThirteen);
        newSemesterButton = findViewById(R.id.newSemesterButton);
        calculateCgpaButton = findViewById(R.id.calculateCgpaButton);
        relativeLayoutParent = findViewById(R.id.relativeLayoutParent);

        creditOne = findViewById(R.id.creditOne);
        creditTwo = findViewById(R.id.creditTwo);
        creditThree = findViewById(R.id.creditThree);
        creditFour = findViewById(R.id.creditFour);
        creditFive = findViewById(R.id.creditFive);
        creditSix = findViewById(R.id.creditSix);
        creditSeven = findViewById(R.id.creditSeven);
        creditEight = findViewById(R.id.creditEight);
        creditNine = findViewById(R.id.creditNine);
        creditTen = findViewById(R.id.creditTen);
        creditEleven = findViewById(R.id.creditEleven);
        creditTwelve = findViewById(R.id.creditTwelve);

        sgpaOne = findViewById(R.id.sgpaOne);
        sgpaTwo = findViewById(R.id.sgpaTwo);
        sgpaThree = findViewById(R.id.sgpaThree);
        sgpaFour = findViewById(R.id.sgpaFour);
        sgpaFive = findViewById(R.id.sgpaFive);
        sgpaSix = findViewById(R.id.sgpaSix);
        sgpaSeven = findViewById(R.id.sgpaSeven);
        sgpaEight = findViewById(R.id.sgpaEight);
        sgpaNine = findViewById(R.id.sgpaNine);
        sgpaTen = findViewById(R.id.sgpaTen);
        sgpaEleven = findViewById(R.id.sgpaEleven);
        sgpaTwelve = findViewById(R.id.sgpaTwelve);
    }

    private void newButtonClicked() {
        if (i > 12) {
            Toast.makeText(getApplicationContext(), "Semester can't be more than 12", Toast.LENGTH_SHORT).show();
        } else if (i == 2) {
            layoutParams.addRule(RelativeLayout.BELOW, R.id.linearLayoutSingleThree);
            relativeLayoutLast.setLayoutParams(layoutParams);
            linearLayoutSingleThree.setVisibility(View.VISIBLE);
            i++;
        } else if (i == 3) {
            layoutParams.addRule(RelativeLayout.BELOW, R.id.linearLayoutSingleFour);
            relativeLayoutLast.setLayoutParams(layoutParams);
            linearLayoutSingleFour.setVisibility(View.VISIBLE);
            i++;
        } else if (i == 4) {
            layoutParams.addRule(RelativeLayout.BELOW, R.id.linearLayoutSingleFive);
            relativeLayoutLast.setLayoutParams(layoutParams);
            linearLayoutSingleFive.setVisibility(View.VISIBLE);
            i++;
        } else if (i == 5) {
            layoutParams.addRule(RelativeLayout.BELOW, R.id.linearLayoutSingleSix);
            relativeLayoutLast.setLayoutParams(layoutParams);
            linearLayoutSingleSix.setVisibility(View.VISIBLE);
            i++;
        } else if (i == 6) {
            layoutParams.addRule(RelativeLayout.BELOW, R.id.linearLayoutSingleSeven);
            relativeLayoutLast.setLayoutParams(layoutParams);
            linearLayoutSingleSeven.setVisibility(View.VISIBLE);
            i++;
        } else if (i == 7) {
            layoutParams.addRule(RelativeLayout.BELOW, R.id.linearLayoutSingleEight);
            relativeLayoutLast.setLayoutParams(layoutParams);
            linearLayoutSingleEight.setVisibility(View.VISIBLE);
            i++;
        } else if (i == 8) {
            layoutParams.addRule(RelativeLayout.BELOW, R.id.linearLayoutSingleNine);
            relativeLayoutLast.setLayoutParams(layoutParams);
            linearLayoutSingleNine.setVisibility(View.VISIBLE);
            i++;
        } else if (i == 9) {
            layoutParams.addRule(RelativeLayout.BELOW, R.id.linearLayoutSingleTen);
            relativeLayoutLast.setLayoutParams(layoutParams);
            linearLayoutSingleTen.setVisibility(View.VISIBLE);
            i++;
        } else if (i == 10) {
            layoutParams.addRule(RelativeLayout.BELOW, R.id.linearLayoutSingleEleven);
            relativeLayoutLast.setLayoutParams(layoutParams);
            linearLayoutSingleEleven.setVisibility(View.VISIBLE);
            i++;
        } else if (i == 11) {
            layoutParams.addRule(RelativeLayout.BELOW, R.id.linearLayoutSingleTwelve);
            relativeLayoutLast.setLayoutParams(layoutParams);
            linearLayoutSingleTwelve.setVisibility(View.VISIBLE);
            i++;
        } else if (i == 12) {
            layoutParams.addRule(RelativeLayout.BELOW, R.id.linearLayoutSingleThirteen);
            relativeLayoutLast.setLayoutParams(layoutParams);
            linearLayoutSingleThirteen.setVisibility(View.VISIBLE);
            i++;
        }
        j++;
    }
}
