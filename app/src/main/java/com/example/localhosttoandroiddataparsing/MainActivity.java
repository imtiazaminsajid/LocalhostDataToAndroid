package com.example.localhosttoandroiddataparsing;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    List<Model> students;
    Adapter empdapter;
    String url;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv= findViewById(R.id.myrecycle);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading....");
        dialog.show();

        students =new ArrayList<>();
        url="ttp://127.0.0.1/sajid_work/profile.php";

        getdata();
    }

    private void getdata() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0; i<response.length(); i++){
                    dialog.dismiss();
                    try {

                        JSONObject object = response.getJSONObject(i);
                        //--add bind data to list--//
                        students.add(new Model(
                                object.getString("name"),
                                object.getString("roll")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    //--adding data to recycler view--//

                    empdapter = new Adapter(students,MainActivity.this);
                    rv.setAdapter(empdapter);
                    empdapter.notifyDataSetChanged();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
            }
        });

com.example.localhosttoandroiddataparsing.AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }
    }
