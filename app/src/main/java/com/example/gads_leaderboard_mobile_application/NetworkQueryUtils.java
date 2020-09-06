package com.example.gads_leaderboard_mobile_application;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class NetworkQueryUtils {

    private final static String LOG_TAG = NetworkQueryUtils.class.getSimpleName();

    public static List<Leader> fetchLeaderData(String requestUrl){
        URL url = createUrl(requestUrl);

        String jsonResponse = null;

        try{
            jsonResponse = makeHTTPRequest(url);
        }catch(IOException e){
            Log.e(LOG_TAG, "Problem making http request", e);
        }

        List<Leader> leadersList = extractFeatureFromJson(jsonResponse);

        return leadersList;
    }

    private static String makeHTTPRequest(URL url) throws IOException{
        String jsonResponse = null;

        if(url == null){
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        }catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException{
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    public static URL createUrl(String stringUrl){
        URL url = null;
        try {
            url = new URL(stringUrl);
        }catch (MalformedURLException e){
            Log.e(LOG_TAG, "error from creating URL", e);
        }

        return url;
    }

    private static List<Leader> extractFeatureFromJson(String leaderJSON){
        if (TextUtils.isEmpty(leaderJSON)) {
            return null;
        }

        List<Leader> leaderList = new ArrayList<>();

        try{
            JSONArray baseJsonResponse = new JSONArray(leaderJSON);
            System.out.println(baseJsonResponse);

            for(int i=0; i<baseJsonResponse.length();i++){
                JSONObject currentJsonObject = baseJsonResponse.getJSONObject(i);
                String leaderName = currentJsonObject.getString("name");
                int leaderScore = currentJsonObject.getInt("score");
                String leaderCountry= currentJsonObject.getString("country");
                String leaderBadgeUrl = currentJsonObject.getString("badgeUrl");

                Leader leader = new Leader(leaderName, leaderScore, leaderCountry);
                leaderList.add(leader);
                System.out.println(leaderList.get(i).getName());
            }
        }catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the earthquake JSON results", e);
        }

        return leaderList;
    }


}
