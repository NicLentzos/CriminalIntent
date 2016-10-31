package com.lentzos.nic.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Nic on 30/10/2016.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
