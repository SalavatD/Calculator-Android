package ru.salavatdautov.calculator;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

    EditText firstOperand;
    EditText secondOperand;
    EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstOperand = (EditText) findViewById(R.id.editTextFirstOperand);
        secondOperand = (EditText) findViewById(R.id.editTextSecondOperand);
        result = (EditText) findViewById(R.id.editTextResult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setView(this.getLayoutInflater().inflate(R.layout.dialog_about, null));
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addition(View view) {
        operate(new IOperation() {
            @Override
            public double operate(double first, double second) {
                return first + second;
            }
        });
    }

    public void subtraction(View view) {
        operate(new IOperation() {
            @Override
            public double operate(double first, double second) {
                return first - second;
            }
        });
    }

    public void multiply(View view) {
        operate(new IOperation() {
            @Override
            public double operate(double first, double second) {
                return first * second;
            }
        });
    }

    public void divide(View view) {
        operate(new IOperation() {
            @Override
            public double operate(double first, double second) {
                return first / second;
            }
        });
    }

    private void operate(IOperation operation) {
        double first = Double.parseDouble(firstOperand.getText().toString());
        double second = Double.parseDouble(secondOperand.getText().toString());
        result.setText(Double.toString(operation.operate(first, second)));
    }
}
