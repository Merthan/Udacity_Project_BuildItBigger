package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class MyAsyncTask extends AsyncTask<Void,Void,Void> {
    private FinishedInterface finishedInterface;
    private static MyApi apiService = null;
    private String result;
    MyAsyncTask(FinishedInterface finishedInterface){
        this.finishedInterface=finishedInterface;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        if(apiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")//localhost:8080
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            apiService = builder.build();
        }


        try {
            result=(apiService.tellJoke().execute().getData());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        finishedInterface.onFinished(result);

    }
}



interface FinishedInterface{
    void onFinished(String result);
}

