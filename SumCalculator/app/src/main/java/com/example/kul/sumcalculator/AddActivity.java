package com.example.kul.sumcalculator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class AddActivity extends AppCompatActivity {

    Button addButton,subButton;
    EditText edittext1,edittext2;
    TextView result;
    ToggleButton toggleButton1, toggleButton2;
    Button buttonSubmit, urOrder;
    CheckBox coffee,pizza, burgerr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title not the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag,int mask(remove notification bar)
        this.setContentView(R.layout.activity_add);//set content view after above sequene( to avoid crash)

       /* //creating the layoutinflater instance
        LayoutInflater li =getLayoutInflater();
        //getting the view object as defined in the customtoast.xml file
        View layout =li.inflate(R.layout.customtoast,(ViewGroup)findViewById(R.id.hi));

        //creating  the toast object
        Toast toast =new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setView(layout);//setting the view of custom toast layout
        toast.show();*/

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addButton = (Button)findViewById(R.id.button);
        edittext1=(EditText)findViewById(R.id.editText) ;
        edittext2=(EditText)findViewById(R.id.editText2);
        result=(TextView)findViewById(R.id.textView);
        subButton=(Button)findViewById(R.id.button2);
        //display toast with hello Toast
        Toast.makeText(getApplicationContext(),"hello Toast, done*!!!",Toast.LENGTH_LONG).show();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1=edittext1.getText().toString();
                String value2=edittext2.getText().toString();
                double a= Double.parseDouble(value1);
                double b= Double.parseDouble(value2);
                double sum= a+b;
                result.setText(Double.toString(sum));

            }
        });
        subButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                String value1=edittext1.getText().toString();
                String value2=edittext2.getText().toString();
                double a= Double.parseDouble(value1);
                double b= Double.parseDouble(value2);
                double sub=a-b;
                result.setText(Double.toString(sub));
            }
        });
        //getting the toggleButton and button instance from the layout xml file
        toggleButton1=(ToggleButton)findViewById(R.id.toggleButton);
        toggleButton2=(ToggleButton)findViewById(R.id.toggleButton2);
        buttonSubmit=(Button)findViewById(R.id.button3);

        //performing action on button click
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result =new StringBuilder();
                result.append("ToggleB1  @:").append(toggleButton1.getText());
                result.append("\nToggleB2  @:").append(toggleButton2.getText());

                //display the message in toast

                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_LONG).show();

            }
        });
        //getting the instance of checkboxes and button from ther activity main.xml file
        pizza=(CheckBox)findViewById(R.id.checkBox2);
        coffee=(CheckBox)findViewById(R.id.checkBox);
        burgerr=(CheckBox)findViewById(R.id.checkBox3);
        urOrder=(Button)findViewById(R.id.button4);

        //applying the listener on the button click

       urOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalAmount=0;
                StringBuilder result =new StringBuilder();
                result.append("Selected items");

                if(coffee.isChecked()){
                    result.append("\n COFFEE 50rs");
                    totalAmount+=50;

                }
                if(burgerr.isChecked()){
                    result.append("\n Burrger 100rs");
                    totalAmount+=100;
                }
                if(pizza.isChecked()){
                    result.append("\n PiZZa 150rs");
                    totalAmount+=150;
                }
                result.append("\n total :"+totalAmount+"rs");

                //display the message on the toast

                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public static class myBroadCastReceiver extends BroadcastReceiver{
        Context mContext;
        @Override
        public void onReceive(Context context, Intent intent){
            mContext=context;
            Toast.makeText(mContext,"phonnne UNLOOOOOcked",Toast.LENGTH_LONG).show();

        }
    }
}
