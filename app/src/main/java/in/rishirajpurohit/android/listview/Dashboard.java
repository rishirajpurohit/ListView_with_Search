package in.rishirajpurohit.android.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    ListView my_list;
    ArrayAdapter<String> my_adapter;
    ArrayAdapter<String> my_adapter2;
    String[] cars = {
            "rolls royce",
            "Toyota",
            "Masserati",
            "car11",
            "car10",
            "car9",
            "car8",
            "car7","car6","car5"
    };

    public static ArrayList<String> cars_list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);



        my_adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                cars
        );

        my_list = (ListView) findViewById(R.id.lv_cars);
        my_list.setAdapter(my_adapter);
        my_list.setTextFilterEnabled(true);


        my_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(Dashboard.this, "Car : "+cars[position], Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Dashboard.this,DetailActivity.class);

                Bundle data = new Bundle();
                data.putString("car_name",cars[position]);
                i.putExtras(data);

                startActivity(i);



            }
        });

        SearchView sv = (SearchView) findViewById(R.id.searchView);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(Dashboard.this, "Search : "+query, Toast.LENGTH_SHORT).show();

                my_list.setAdapter(null);

                //suppose query = "b"
                String[] final_cars = {"bmw", "bugati"};

                my_adapter2 = new ArrayAdapter<String>(
                        Dashboard.this,
                        android.R.layout.simple_list_item_1,
                        final_cars
                );

                my_list.setAdapter(my_adapter2);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });





    }
}
