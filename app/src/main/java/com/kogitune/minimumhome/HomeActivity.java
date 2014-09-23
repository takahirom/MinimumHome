package com.kogitune.minimumhome;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.kogitune.minimumhome.event.GoToLauncherButtonClickEvent;
import com.squareup.otto.Subscribe;

public class HomeActivity extends Activity {

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.layout_main);
        setDefaultFragment();
    }

    public void setDefaultFragment(){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.FragmentContainer, HomeFragment.newInstance());
        transaction.commit();
    }

    private void changeLauncher() {
        getPackageManager().clearPackagePreferredActivities(getPackageName());
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    @Subscribe
    public void goToLauncher(GoToLauncherButtonClickEvent clickEvent){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.FragmentContainer, LauncherFragment.newInstance());
        transaction.commit();
    }
}
