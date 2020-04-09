package com.moeiny.reza.infosys_test;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTaskInfo extends AsyncTask {
    public  String link;

    public AsyncTaskInfo(String link){
        this.link=link;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        try {
// Give Information from URL by URLConnection
            URL url = new URL(link);
            URLConnection Connection;
            Connection= url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line=null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            MainActivity.Info=builder.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }
}
