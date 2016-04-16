package com.example.bridgelabz.tutorial3;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.PrivateKey;

public class MainActivity extends ActionBarActivity {

    private static final String TOTAL_BILL = "TOTAL_BILL";
    private static final String CURRENT_TIP = "CURRENT_TIP";
    private static final String BILL_WITHOUT_TIP = "BILL_WITHOUT_TIP";

    private double billBeforeTip,tipAmount,finalBill;

    EditText billBeforeTipET,tipAmountET,finalBillET;
    SeekBar tipSeekBar;

    private int[] checklistValues = new int[12];

    CheckBox friendlyCheckbox,specialsCheckbox,opinionCheckbox;
    RadioGroup availableRadioGroup;
    RadioButton availableBadRadio;
    RadioButton availableGoodRadio;
    RadioButton availableOkRadio;

    Spinner problemsSpinner;

    Button startChronometerBtn,pauseChronometerBtn,restartChronometerBtn;

    Chronometer timeWaitingChoronometer;

    long secondsYouWaited = 0;
    TextView timeWaitingTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null)
        {
            billBeforeTip = 0.0;
            tipAmount = 0.15;
            finalBill = 0.0;
        }
        else
        {
            billBeforeTip = savedInstanceState.getDouble(BILL_WITHOUT_TIP);
            tipAmount = savedInstanceState.getDouble(CURRENT_TIP);
            finalBill = savedInstanceState.getDouble(TOTAL_BILL);
        }

        billBeforeTipET = (EditText) findViewById(R.id.billEditText);
        tipAmountET = (EditText) findViewById(R.id.tipEditText);
        finalBillET = (EditText) findViewById(R.id.finalBillEditText);
        tipSeekBar = (SeekBar) findViewById(R.id.changeTipSeekBar);
        tipSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tipAmount = (tipSeekBar.getProgress())*.01;
                tipAmountET.setText(String.format("%.2f",tipAmount));
                updateTipAndFinalBill();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        billBeforeTipET.addTextChangedListener(billBeforeTipListener);

        friendlyCheckbox = (CheckBox) findViewById(R.id.friendlyCheckBox);
        specialsCheckbox = (CheckBox) findViewById(R.id.specialCheckBox);
        opinionCheckbox = (CheckBox) findViewById(R.id.openionCheckBox);
        setUpIntroCheckBoxes();

        availableRadioGroup = (RadioGroup) findViewById(R.id.availablerRadioGroup);
        availableBadRadio = (RadioButton) findViewById(R.id.availableBadRadio);
        availableOkRadio = (RadioButton) findViewById(R.id.availableOkRadio);
        availableGoodRadio = (RadioButton) findViewById(R.id.availableGoodRadio);
        addChangeListenerToRadios();

        problemsSpinner = (Spinner) findViewById(R.id.problemSpinner);
        addItemSelectedListenerToSpinner();

        startChronometerBtn = (Button) findViewById(R.id.startChoronometerButton);
        pauseChronometerBtn = (Button) findViewById(R.id.pauseChoronometerButton);
        restartChronometerBtn = (Button) findViewById(R.id.restartChoronometerButton);

       // setButtonOnClickListener();

        timeWaitingChoronometer = (Chronometer) findViewById(R.id.timeWaitingChronometer);
        timeWaitingTextView = (TextView) findViewById(R.id.timeWaitingTextView);
    }

    private void addItemSelectedListenerToSpinner() {
        problemsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checklistValues[6] = (problemsSpinner.getSelectedItem()).equals("Bad")?-1:0;
                checklistValues[7] = (problemsSpinner.getSelectedItem()).equals("Ok")?3:0;
                checklistValues[8] = (problemsSpinner.getSelectedItem()).equals("Good")?6:0;
                setTipFromWaitressCheckList();
                updateTipAndFinalBill();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void addChangeListenerToRadios() {
        availableRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checklistValues[3] = availableBadRadio.isChecked()?-1:0;
                checklistValues[4] = availableOkRadio.isChecked()?2:0;
                checklistValues[5] = availableGoodRadio.isChecked()?4:0;
                setTipFromWaitressCheckList();
                updateTipAndFinalBill();
            }
        });
    }

    private void setUpIntroCheckBoxes() {
        friendlyCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checklistValues[0] = friendlyCheckbox.isChecked()?4:0;
                setTipFromWaitressCheckList();
                updateTipAndFinalBill();
            }
        });

        specialsCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checklistValues[1] = specialsCheckbox.isChecked()?1:0;
                setTipFromWaitressCheckList();
                updateTipAndFinalBill();
            }
        });

        opinionCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checklistValues[2] = opinionCheckbox.isChecked()?2:0;
                setTipFromWaitressCheckList();
                updateTipAndFinalBill();
            }
        });
    }

    private void setTipFromWaitressCheckList() {
        int checklistTotal = 0;
        for(int item : checklistValues)
        {
            checklistTotal += item;
        }
        tipAmountET.setText(String.format("%.02f",checklistTotal *0.1));
    }

    private TextWatcher billBeforeTipListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                billBeforeTip = Double.parseDouble(s.toString());
            }
            catch (NumberFormatException e)
            {
                billBeforeTip = 0.0;
            }

        }

        @Override
        public void afterTextChanged(Editable s) {
            updateTipAndFinalBill();
        }
    };

    private void updateTipAndFinalBill() {
        double tipAmount = Double.parseDouble(tipAmountET.getText().toString());
        double finalBill = billBeforeTip + (billBeforeTip*tipAmount);
        finalBillET.setText(String.format("%.2f",finalBill));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(TOTAL_BILL,finalBill);
        outState.putDouble(CURRENT_TIP,tipAmount);
        outState.putDouble(BILL_WITHOUT_TIP,billBeforeTip);
    }
}
