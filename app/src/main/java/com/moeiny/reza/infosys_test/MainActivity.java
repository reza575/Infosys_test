package com.moeiny.reza.infosys_test;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static String Info="";
    ArrayList<ItemInfo> infoArrayList;
    ListView listView;
    TextView actionBar;
    ItemInfoAdapter infoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infoArrayList=new ArrayList<>();
        listView=(ListView)findViewById(R.id.listview);
        actionBar=(TextView) findViewById(R.id.txt_acctionBar);

//     Give the JsonObject bt URL Connection and Split the Json to devided Element
        try {
            JSONObject jsonObject=new JSONObject(Info);
            String Title =jsonObject.getString("title");
            JSONArray jsonArrayRows=jsonObject.getJSONArray("rows");

           actionBar.setText(Title);
            for(int i=0;i<jsonArrayRows.length();i++){

                //  Give Item from JsonAyyay and create ItemInfo Model and send to ListView
                JSONObject object=jsonArrayRows.getJSONObject(i);
                ItemInfo itemInfo=new ItemInfo();
                itemInfo.id=i;
                itemInfo.title=object.getString("title");
                itemInfo.description=object.getString("description");
                itemInfo.imageUrl=object.getString("imageHref");

                infoArrayList.add(itemInfo);

            }

            infoAdapter = new ItemInfoAdapter(infoArrayList);
            listView.setAdapter(infoAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
