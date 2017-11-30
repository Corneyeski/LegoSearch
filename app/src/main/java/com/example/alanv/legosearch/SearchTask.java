package com.example.alanv.legosearch;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SearchTask extends AsyncTask<String,Integer,BoxList> {

    interface WeakReference {
        Context getContext();
        ProgressBar getProgressBar();
        void finished(BoxList list);
    }
    private WeakReference ref;
    public SearchTask(WeakReference ref) {
        super();
        this.ref = ref;
    }

    @Override
    protected BoxList doInBackground(String... strings) {
        InputStream in = null;
        try {
            // BUILD URL
            String search = strings[0];
            search = URLEncoder.encode(search, "utf-8");
            String apiKey = ref.getContext().getString(R.string.apiKey);
            String urlStr = ref.getContext().getString(R.string.searchUrl, apiKey, search);
            Log.d("flx", "URL " + urlStr);

            // OPEN CONNECTION
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            int length = conn.getContentLength();
            Log.d("flx", "ContentLength = " + length);

            // DOWNLOAD JSON
            in = url.openStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int total = 0, nRead;
            while ((nRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, nRead);
                total += nRead;
            }
            String json = new String(out.toByteArray());
            Log.d("flx", "JSON = " + json);

            // DECODE JSON
            Gson gson = new Gson();
            BoxList list = gson.fromJson(json, BoxList.class);
            Log.d("flx",  list.getCount() + " SETS");
            Box[] sets = list.getResults();
            for(Box set: sets) {
                Log.d("flx", set.id + set.name);
            }
            return list;
        }
        catch (Exception e) {
            Log.e("flx", e.getMessage());
            return null;
        }
        finally {
            try { if (in != null) in.close(); } catch (Exception ignored) { }
        }
    }
}
