package in.rishirajpurohit.android.listview;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
//
//        Intent i = getIntent();
//        Bundle data = i.getExtras();
//        String car_name = data.getString("car_name","No car selected");

        String car_name=getIntent().getExtras().getString("car_name", "no car");

        TextView tv = new TextView(this);
        tv.setText(car_name);

        ConstraintLayout cly = (ConstraintLayout) findViewById(R.id.layout_main);
        cly.addView(tv);


    }
}
