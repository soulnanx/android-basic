package com.example.renan.projetopi.application;

import android.app.Application;

import com.codeslap.persistence.DatabaseSpec;
import com.codeslap.persistence.Persistence;
import com.codeslap.persistence.PersistenceConfig;
import com.codeslap.persistence.SqlAdapter;
import com.example.renan.projetopi.entity.Contact;

/**
 * Created by renan on 1/23/15.
 */
public class App extends Application{

    public SqlAdapter adapter;

    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseSpec database = PersistenceConfig.registerSpec(/**db version**/2);
        database.match(Contact.class);
        adapter = Persistence.getAdapter(this);
    }

}
