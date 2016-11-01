
package com.lentzos.nic.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Nic on 28/10/2016.
 */

public class CrimeFragment extends android.support.v4.app.Fragment {

    private static final String ARG_CRIME_ID = "crime_id";
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    public static CrimeFragment newInstance(UUID crimeId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mCrime = new Crime();
        //UUID crimeId = (UUID) getActivity().getIntent().getSerializableExtra(CrimeActivity.EXTRA_CRIME_ID);
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    //implement onCreateView() to inflate fragment_crime.xml.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //call layoutinflater.inflate and pass resource id, the view's parent and whether to add the inflated
        //view to the view's parent (false). You will add the view in the activity code instead.
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        //the oncreateview() method is also the place to configure EditText and add a listener.
        mTitleField = (EditText)v.findViewById(R.id.crime_title);
        mTitleField.setText(mCrime.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //fill in later
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    mCrime.setTitle(s.toString());
                    }

                @Override
                public void afterTextChanged(Editable s) {
                        //fill in later
                    }

        });

        mDateButton = (Button)v.findViewById(R.id.crime_date);
        //mDateButton.setText(mCrime.getDate().toString());
        //mDateButton.setEnabled(false);

        java.text.DateFormat mDateFormatter;
        //Get a DateFormat object that is formatted for the current locale
        mDateFormatter = android.text.format.DateFormat.getLongDateFormat(getActivity());
        //Format the date and set the button text to the newly formatted date
        mDateButton.setText(mDateFormatter.format(mCrime.getDate()));
        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //set the crime's solved property
                mCrime.setSolved(isChecked);
            }
        });

        return v;
    }
}
