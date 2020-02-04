package limit.dne.jsoupdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button get;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get = (Button) findViewById(R.id.buttonGet);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetData().execute();
            }
        });

    }

    private class GetData extends AsyncTask<Void, Integer, String>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params){
            try{
                title = Jsoup.connect("http://www.javatpoint.com").get().title();
            } catch (IOException e){
                title = e.getMessage();
                e.printStackTrace();
            }
            return title;
        }

        @Override
        protected void onPostExecute(String result){
            TextView data = (TextView) findViewById(R.id.textViewData);
            data.setText(result);
        }
    }
}
