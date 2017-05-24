package com.example.nshumakov.a20170517_stackparser;

import android.os.AsyncTask;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by nshumakov on 22.05.2017.
 */

public class ProgressTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... path) {
        return null;
    }

    @Override
    protected void onPostExecute(String content) {
    }

    /*Get content from URL*/
    public InputStream getContent(String path) throws IOException {
        BufferedReader reader = null;
        try {
            URL url = new URL(path);
            HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.setReadTimeout(10000);
            c.connect();
            InputStream stream = c.getInputStream();
            return stream;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
