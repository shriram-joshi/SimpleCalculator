package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean firstDigitFlag=true,decimalFlag=false,firstDecimalFlag=false,negateFlag=false,firstOperationFlag=true;
    double res=0, tempRes=0;
    TextView result,tempResult,symbol;
    Button add, subtract, multiply, divide, equal, ac, delete, decimalPoint , btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attachID();

        //operator buttons
        {
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (negateFlag && firstDigitFlag) {
                        negateFlag = false;
                        result.setText("");
                    } else {
                        if (firstOperationFlag) {
                            tempRes = res;
                            tempResult.setText(String.valueOf(tempRes));
                            symbol.setText(add.getText().toString());
                            firstOperationFlag = false;
                            resultAcFunc();
                        } else {
                            tempRes = operate(tempRes, res, symbol.getText().toString());
                            tempResult.setText(String.valueOf(tempRes));
                            symbol.setText(add.getText().toString());
                            firstOperationFlag = false;
                            resultAcFunc();
                        }
                    }
                }
            });
            subtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (firstDigitFlag) {
                        result.setText("-");
                        negateFlag = true;
                    } else {
                        if (firstOperationFlag) {
                            tempRes = res;
                            tempResult.setText(String.valueOf(tempRes));
                            symbol.setText(subtract.getText().toString());
                            firstOperationFlag = false;
                            resultAcFunc();
                        } else {
                            tempRes = operate(tempRes, res, symbol.getText().toString());
                            tempResult.setText(String.valueOf(tempRes));
                            symbol.setText(subtract.getText().toString());
                            firstOperationFlag = false;
                            resultAcFunc();
                        }
                    }
                }
            });
            multiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (firstOperationFlag) {
                        tempRes = res;
                        tempResult.setText(String.valueOf(tempRes));
                        symbol.setText(multiply.getText().toString());
                        firstOperationFlag = false;
                        resultAcFunc();
                    } else {
                        tempRes = operate(tempRes, res, symbol.getText().toString());
                        tempResult.setText(String.valueOf(tempRes));
                        symbol.setText(multiply.getText().toString());
                        firstOperationFlag = false;
                        resultAcFunc();
                    }
                }
            });
            divide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (firstOperationFlag) {
                        tempRes = res;
                        tempResult.setText(String.valueOf(tempRes));
                        symbol.setText(divide.getText().toString());
                        firstOperationFlag = false;
                        resultAcFunc();
                    } else {
                        tempRes = operate(tempRes, res, symbol.getText().toString());
                        tempResult.setText(String.valueOf(tempRes));
                        symbol.setText(divide.getText().toString());
                        firstOperationFlag = false;
                        resultAcFunc();
                    }
                }
            });
        }

        //functionality buttons
        {
            equal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (firstOperationFlag) {
                        symbol.setText("=");
                    } else {
                        if(res==0&& symbol.getText().toString().equals("÷")) {
                            Toast.makeText(MainActivity.this, "Cannot divide by zero!", Toast.LENGTH_LONG).show();
                            res=tempRes;
                            symbol.setText("");
                        }else{
                            res = operate(tempRes, res, symbol.getText().toString());
                            symbol.setText("=");
                        }
                        result.setText(String.valueOf(res));
                        tempResult.setText("");
                        tempRes = 0;
                        negateFlag = (res < 0);
                        firstDigitFlag = (result.getText().toString().length() == 1);
                        decimalFlag = true;
                        firstDecimalFlag = (result.getText().toString().charAt(result.getText().toString().length() - 2) == '.');
                        firstOperationFlag = true;
                    }
                }
            });
            ac.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    res = 0;
                    tempRes = 0;
                    decimalFlag = false;
                    firstDecimalFlag = false;
                    firstDigitFlag = true;
                    negateFlag = false;
                    firstOperationFlag = true;
                    tempResult.setText("");
                    symbol.setText("");
                    result.setText("0");
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (decimalFlag) {
                        if (result.getText().toString().charAt(result.getText().toString().length() - 1) == '.') {
                            decimalFlag = false;
                        }
                        if (result.getText().toString().charAt(result.getText().toString().length() - 2) == '.') {
                            firstDecimalFlag = true;
                        }
                        result.setText(result.getText().toString().substring(0, result.getText().toString().length() - 1));
                        res = Double.parseDouble(result.getText().toString());
                    } else {
                        if (result.getText().toString().length() == 1) {
                            resultAcFunc();
                        } else {
                            result.setText(result.getText().toString().substring(0, result.getText().toString().length() - 1));
                            res = Double.parseDouble(result.getText().toString());
                        }
                    }
                }
            });
        }

        //number input buttons
        {
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input(1);
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input(2);
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input(3);
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input(4);
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input(5);
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input(6);
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input(7);
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input(8);
                }
            });
            btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input(9);
                }
            });
            btn0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input(0);
                }
            });
            decimalPoint.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {
                    if (decimalFlag) {
                        Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    } else {
                        result.setText(String.valueOf((int) res) + '.');
                        decimalFlag = true;
                        firstDecimalFlag = true;
                        firstDigitFlag = false;
                    }
                }
            });
        }
    }

    private double operate(double tempRes, double res, String symbol) {
        double solution;

        switch (symbol){
            case "+":
                solution = tempRes + res;
                break;
            case "-":
                solution = tempRes - res;
                break;
            case "X":
                solution = tempRes * res;
                break;
            case "÷":
                if(res==0){
                    Toast.makeText(MainActivity.this, "Cannot divide by zero!", Toast.LENGTH_LONG).show();
                    return tempRes;
                }
                solution = tempRes / res;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + symbol);
        }

        return solution;
    }

    private void resultAcFunc() {
        res=0;
        decimalFlag=false;
        firstDecimalFlag=false;
        firstDigitFlag=true;
        negateFlag=false;
        result.setText("0");
    }

    @SuppressLint("SetTextI18n")
    private void input(int in) {
        if (negateFlag){
            if(decimalFlag) {
                if(firstDecimalFlag){
                    res=(res*10-in)/10;
                    result.setText(String.valueOf(res));
                    firstDecimalFlag=false;
                }else{
                    result.setText(String.valueOf(res)+ in);
                    res = Double.parseDouble(result.getText().toString());
                }
            }else{
                if(firstDigitFlag){
                    res=-1*in;
                    result.setText(String.valueOf((int) res));
                    firstDigitFlag=false;
                }else{
                    res=res*10-in;;
                    result.setText(String.valueOf((int) res));
                }
            }
        }else
        {
            if(decimalFlag){
                if(firstDecimalFlag){
                    res= (res*10+in)/10;
                    result.setText(String.valueOf(res));
                    firstDecimalFlag = false;
                }else{
                    result.setText(String.valueOf(res)+ in);
                    res = Double.parseDouble(result.getText().toString());
                    negateFlag=false;
                }
            }else{
                res=(res*10 +in);
                result.setText(String.valueOf((int) res));
                negateFlag=false;
                firstDigitFlag=false;
            }
        }
    }

    private void attachID() {
        result = findViewById(R.id.result_textView);
        tempResult = findViewById(R.id.temp_result_textView);
        symbol = findViewById(R.id.symbol_textView);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        equal = findViewById(R.id.equalto);
        ac = findViewById(R.id.ac);
        delete = findViewById(R.id.delete);
        decimalPoint = findViewById(R.id.decimal_btn);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
    }
}
