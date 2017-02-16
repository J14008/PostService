package com.example.j14008_m.postservice;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by J14008_m on 2017/02/10.
 */
public class AsyncHttp extends AsyncTask<String, Integer, Boolean> {
    HttpURLConnection urlConnection = null;
    Boolean flg = false;

    double name;
    double value;

    public AsyncHttp(double name, double value){
        this.name = name;
        this.value = value;
    }

    //�񓯊�������������
    @Override
    protected  Boolean doInBackground(String... contents){
        String urlinput = "http://10.250.0.75/GPS/post.php"; //10.0.2.2 �̓��[�J���z�X�g�Ŏ��s����ꍇ�Ɏg��
        try{
            URL url = new URL(urlinput);
            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            //POST�p�p�����[�^
            String postDataSample = "name=" + name + "&text=" + value;
            //POST�p�����[�^�ݒ�
            OutputStream out = urlConnection.getOutputStream();
            out.write(postDataSample.getBytes());
            out.flush();
            out.close();
            Log.d("test", postDataSample);
            //���X�|���X���󂯎��
            urlConnection.getInputStream();

            flg = true;
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return flg;
    }
}