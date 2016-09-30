package edu.calvin.cl43.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 *  Chris Li, cl43, cs262, homework 01, Prof. Vanderlinden
 *  <p>
 *  This app is a simple calculator. There are 2 numerical value inputs and a drop list for the operator. When the calculate button is hit, it computes based on the inputs and operator.
 */

public class MainActivity extends AppCompatActivity {

    /**
     * Calls the variables.
     */
    public int value;
    public int value2;
    public String operate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Calls in the spinner. Adds items to the it and gives user the ability to select them.
         */
        String[] operator={"+", "-", "*", "/"};
        ArrayAdapter<String> stringArrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, operator);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(stringArrayAdapter);

        /**
         * Calls in the calculate button and provides its functions.
         */
        Button Calculate = (Button)findViewById(R.id.button);
        Calculate.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        /*
                         * My variables that handle input and output for the text functions.
                         */
                        TextView input = (TextView) findViewById(R.id.editText);
                        TextView input2 = (TextView) findViewById(R.id.editText2);
                        TextView output = (TextView) findViewById(R.id.textView);
                        Spinner spinner = (Spinner) findViewById(R.id.spinner);

                        /*
                         * Converts values into strings for variables
                         */
                        value = Integer.parseInt(input.getText().toString());
                        value2 = Integer.parseInt(input2.getText().toString());
                        operate = spinner.getSelectedItem().toString();

                        /**
                         * Conditions based on selected operator item. Performs math based on what the user selected.
                         */
                        if(operate.equals("+")){
                            output.setText(Integer.toString(value + value2));
                        }else if(operate.equals("-")){
                            output.setText(Integer.toString(value - value2));
                        }else if(operate.equals("*")){
                            output.setText(Integer.toString(value * value2));
                        }else if(operate.equals("/")){
                            /**
                             * In an era long past, there existed a land known as Aerith Maticia.
                             * An evil beast has descended upon the land, creating chaos and disorder.
                             * Prophecy has it that a hero shall one day come to bring peace and harmony to Aerith Maticia.
                             * When that day comes and the hero goes out to create legends and challenge the terrible beast known as "Dividius Zero".
                             * May he know that it is dangerous to go alone and he should take this.
                             */
                            if(value2 == (0)){
                                output.setText("Cannot divide by 0!"); //Seriously if you try to divide by 0. You should probably take this.
                            }else {
                                output.setText(Integer.toString(value / value2));
                            }
                        }
                     }
                }
        );
    }
}
