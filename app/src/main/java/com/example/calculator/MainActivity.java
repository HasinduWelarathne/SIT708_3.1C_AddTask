package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.R;

public class MainActivity extends AppCompatActivity {

    EditText value1EditText, value2EditText;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        value1EditText = findViewById(R.id.textView);
        value2EditText = findViewById(R.id.textView2);
        resultTextView = findViewById(R.id.resultView);

        // Button click listeners
        findViewById(R.id.btn_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1EditText.setText("");
                value2EditText.setText("");
                resultTextView.setText("");
            }
        });

        findViewById(R.id.btn_divide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("/");
            }
        });

        findViewById(R.id.btn_multiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("*");
            }
        });

        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle backspace (remove last character)
                String value = value1EditText.getText().toString();
                if (!value.isEmpty()) {
                    value1EditText.setText(value.substring(0, value.length() - 1));
                }
            }
        });

        findViewById(R.id.btn_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendValue("7");
            }
        });

        findViewById(R.id.btn_8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendValue("8");
            }
        });

        findViewById(R.id.btn_9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendValue("9");
            }
        });

        findViewById(R.id.btn_subtract).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("-");
            }
        });

        findViewById(R.id.btn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendValue("4");
            }
        });

        findViewById(R.id.btn_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendValue("5");
            }
        });

        findViewById(R.id.btn_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendValue("6");
            }
        });

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("+");
            }
        });

        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendValue("1");
            }
        });

        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendValue("2");
            }
        });

        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendValue("3");
            }
        });

        findViewById(R.id.btn_decimal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle decimal point
                String value = value1EditText.getText().toString();
                if (!value.contains(".")) {
                    appendValue(".");
                }
            }
        });

        findViewById(R.id.btn_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("=");
            }
        });

        findViewById(R.id.btn_0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendValue("0");
            }
        });
    }

    private void appendValue(String value) {
        String currentValue = value1EditText.getText().toString();
        value1EditText.setText(currentValue + value);
    }

    private void calculate(String operator) {
        try {
            double value1 = Double.parseDouble(value1EditText.getText().toString());
            double value2 = Double.parseDouble(value2EditText.getText().toString());
            double result = 0;

            switch (operator) {
                case "/":
                    result = value1 / value2;
                    break;
                case "*":
                    result = value1 * value2;
                    break;
                case "-":
                    result = value1 - value2;
                    break;
                case "+":
                    result = value1 + value2;
                    break;
            }

            resultTextView.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            resultTextView.setText("Error");
        }
    }
}
