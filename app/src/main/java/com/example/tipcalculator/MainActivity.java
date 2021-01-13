package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText BillAmountId;
    private SeekBar seekBar;
    private TextView seekbarTv;
    private Button calculateTip;
    private TextView TipAmountTv;
    private TextView TotalBillTv;
    private int seekbarPercentage;
    private float billAmountFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BillAmountId = (EditText) findViewById(R.id.BillAmountId);
        seekBar = (SeekBar) findViewById(R.id.TipSeekBar);
        calculateTip = (Button) findViewById(R.id.CalculateTip) ;
        TipAmountTv = (TextView) findViewById(R.id.ShowTipTv);
        seekbarTv = (TextView) findViewById(R.id.TipTextView);
        TotalBillTv = (TextView) findViewById(R.id.TotalBillTv);

        calculateTip.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarTv.setText(String.valueOf(seekBar.getProgress())+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                    seekbarPercentage = seekBar.getProgress();
            }
        });
    }

    @Override
    public void onClick(View v) {
        calculate();
    }

    public void calculate(){
        float result = 0.0f;
        if(!BillAmountId.getText().toString().equals("")){
            billAmountFloat = Float.parseFloat(BillAmountId.getText().toString());
            result = billAmountFloat*seekbarPercentage/100;
            TipAmountTv.setText("Your Tip will be" + String.valueOf(result));
            TotalBillTv.setText("Your Total Bill Is " + String.valueOf(result + billAmountFloat));
        }
        else{
            Toast.makeText(MainActivity.this,"Enter The BIll Amount.",Toast.LENGTH_LONG).show();
        }

    }
}
