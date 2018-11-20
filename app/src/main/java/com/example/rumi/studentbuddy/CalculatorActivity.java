package com.example.rumi.studentbuddy;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    private EditText e1, e2;
    private int count = 0;
    private String expression = "";
    private String text = "";
    private Double result = 0.0;
    private Button square, xpowy, log, sin, cos, tan, sqrt, fact, inverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        init();

        e2.setText("0");
    }

    private void init() {
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        square = findViewById(R.id.square);
        xpowy = findViewById(R.id.xpowy);
        log = findViewById(R.id.log);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        tan = findViewById(R.id.tan);
        sqrt = findViewById(R.id.sqrt);
        fact = findViewById(R.id.factorial);
        inverse = findViewById(R.id.inverse);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.num0:
                e2.setText(e2.getText() + "0");
                break;

            case R.id.num1:
                e2.setText(e2.getText() + "1");
                break;

            case R.id.num2:
                e2.setText(e2.getText() + "2");
                break;

            case R.id.num3:
                e2.setText(e2.getText() + "3");
                break;

            case R.id.num4:
                e2.setText(e2.getText() + "4");
                break;

            case R.id.num5:
                e2.setText(e2.getText() + "5");
                break;

            case R.id.num6:
                e2.setText(e2.getText() + "6");
                break;

            case R.id.num7:
                e2.setText(e2.getText() + "7");
                break;

            case R.id.num8:
                e2.setText(e2.getText() + "8");
                break;

            case R.id.num9:
                e2.setText(e2.getText() + "9");
                break;

            case R.id.pi:
                e2.setText(e2.getText() + "pi");
                break;

            case R.id.dot:
                if (count == 0 && e2.length() != 0) {
                    e2.setText(e2.getText() + ".");
                    count++;
                }
                break;

            case R.id.inverse:
                e2.setText("1/" + e2.getText());
                break;

            case R.id.posneg:
                if (e2.length() != 0) {
                    String s = e2.getText().toString();
                    char arr[] = s.toCharArray();
                    if (arr[0] == '-')
                        e2.setText(s.substring(1, s.length()));
                    else
                        e2.setText("-" + s);
                }
                break;

            case R.id.clear:
                e1.setText("");
                e2.setText("");
                count = 0;
                expression = "";
                break;
            case R.id.plus:
                operationClicked("+");
                break;

            case R.id.minus:
                operationClicked("-");
                break;

            case R.id.divide:
                operationClicked("/");
                break;

            case R.id.multiply:
                operationClicked("*");
                break;

            case R.id.equal:
                /*for more knowledge on DoubleEvaluator and its tutorial go to the below link
                http://javaluator.sourceforge.net/en/home/*/
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    expression = e1.getText().toString() + text;
                }
                e1.setText("");
                if (expression.length() == 0)
                    expression = "0.0";
                try {
//                    evaluate the expression
                    result = new Evaluator().evaluate(expression);
                    e2.setText(result + "");
//                    insert expression and result in sqlite database if expression is valid and not 0.0
//                    if (String.valueOf(result).equals("6.123233995736766E-17")) {
//                        result = 0.0;
//                        e2.setText(result + "");
//                    } else if (String.valueOf(result).equals("1.633123935319537E16"))
//                        e2.setText("infinity");
//                    else
//                        e2.setText(result + "");
//                    if (!expression.equals("0.0"))
//                        dbHelper.insert("SCIENTIFIC", expression + " = " + result);
                } catch (Exception e) {
                    e2.setText("Invalid Expression");
                    e1.setText("");
                    expression = "";
                    e.printStackTrace();
                }
                break;
            case R.id.backSpace:
                text = e2.getText().toString();
                if (text.length() > 0) {
                    if (text.endsWith(".")) {
                        count = 0;
                    }
                    String newText = text.substring(0, text.length() - 1);
                    //to delete the data contained in the brackets at once
                    if (text.endsWith(")")) {
                        char[] a = text.toCharArray();
                        int pos = a.length - 2;
                        int counter = 1;
                        //to find the opening bracket position
                        for (int i = a.length - 2; i >= 0; i--) {
                            if (a[i] == ')') {
                                counter++;
                            } else if (a[i] == '(') {
                                counter--;
                            }
                            //if decimal is deleted b/w brackets then count should be zero
                            else if (a[i] == '.') {
                                count = 0;
                            }
                            //if opening bracket pair for the last bracket is found
                            if (counter == 0) {
                                pos = i;
                                break;
                            }
                        }
                        newText = text.substring(0, pos);
                    }
                    //if e2 edit text contains only - sign or sqrt or any other text functions
                    // at last then clear the edit text e2
                    if (newText.equals("-") || newText.endsWith("sqrt") || newText.endsWith("log") || newText.endsWith("ln")
                            || newText.endsWith("sin") || newText.endsWith("asin") || newText.endsWith("asind") || newText.endsWith("sinh")
                            || newText.endsWith("cos") || newText.endsWith("acos") || newText.endsWith("acosd") || newText.endsWith("cosh")
                            || newText.endsWith("tan") || newText.endsWith("atan") || newText.endsWith("atand") || newText.endsWith("tanh")
                            || newText.endsWith("cbrt")) {
                        newText = "";
                    }
                    //if pow sign is left at the last or divide sign
                    else if (newText.endsWith("^") || newText.endsWith("/"))
                        newText = newText.substring(0, newText.length() - 1);
                    else if (newText.endsWith("pi") || newText.endsWith("e^"))
                        newText = newText.substring(0, newText.length() - 2);
                    e2.setText(newText);
                }
                break;

            case R.id.sqrt:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    e2.setText("1/(" + text + ")");
                }
                break;

            case R.id.square:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    e2.setText("(" + text + ")^2");
                }
                break;

            case R.id.xpowy:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    e2.setText("e^(" + text + ")");
                }
                break;

            case R.id.log:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    e2.setText("log(" + text + ")");
                }
                break;

            case R.id.factorial:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    String res = "";
                    try {
                        CalculateFactorial cf = new CalculateFactorial();
                        int[] arr = cf.factorial((int) Double.parseDouble(String.valueOf(new Evaluator().evaluate(text))));
                        int res_size = cf.getRes();
                        if (res_size > 20) {
                            for (int i = res_size - 1; i >= res_size - 20; i--) {
                                if (i == res_size - 2)
                                    res += ".";
                                res += arr[i];
                            }
                            res += "E" + (res_size - 1);
                        } else {
                            for (int i = res_size - 1; i >= 0; i--) {
                                res += arr[i];
                            }
                        }
                        e2.setText(res);
                    } catch (Exception e) {
                        if (e.toString().contains("ArrayIndexOutOfBoundsException")) {
                            e2.setText("Result too big!");
                        } else
                            e2.setText("Invalid!!");
                        e.printStackTrace();
                    }
                }
                break;

            case R.id.sin:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    e2.setText("sin(" + text + ")");
                }
                break;

            case R.id.cos:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    e2.setText("cos(" + text + ")");
                }
                break;

            case R.id.tan:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    e2.setText("tan(" + text + ")");
                }
                break;
        }
    }

    private void operationClicked(String operation) {
        if (e2.length() != 0) {
            String text = e2.getText().toString();
            e1.setText(e1.getText() + text + operation);
            e2.setText("");
            count = 0;
        } else {
            String text = e1.getText().toString();
            if (text.length() > 0) {
                String newText = text.substring(0, text.length() - 1) + operation;
                e1.setText(newText);
            }
        }
    }
}
