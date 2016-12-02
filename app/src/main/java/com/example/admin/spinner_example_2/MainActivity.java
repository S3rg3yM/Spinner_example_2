package com.example.admin.spinner_example_2;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final String TAG = "Spinner";

    Spinner spinner;
    MyAdapter adapter;
    private ArrayList<Model> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = (Spinner)findViewById(R.id.spinner);

        for (int i = 0; i < 30; i++) {
//            Model nModel = new Model();
//            nModel.result = "Item " + i;
//            models.add(nModel);

            models.add(new Model(R.drawable.ic_spinner,"Model " + i));
        }

        adapter = new MyAdapter(this, models);
        adapter.notifyDataSetChanged();

        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(this);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Object item = parent.getItemAtPosition(position);
        Log.d(TAG, "Spinner position: " + item);
        boolean status = models.get(position).state;
        models.get(position).state = !status;
        adapter.notifyDataSetChanged();
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private class MyAdapter extends BaseAdapter {

        private Context context;
        private ArrayList<Model> aModel;
        LayoutInflater lInflater;

        public MyAdapter(Context context, ArrayList<Model> aModel) {

            this.context = context;
            this.aModel = new ArrayList<>(aModel);
//            this.aModel = new ArrayList<>(aModel);  для создания спиннера на основе нвоо листа
            lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public int getCount(){
            return models.size();
        }

        public Model getItem(int position){
            return models.get(position);
        }

        public long getItemId(int position){
            return position;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;

            if(view==null){
                view = lInflater.inflate(R.layout.spinner_row, parent, false);
            }

            Model m = getItem(position);

            ((TextView) view.findViewById(R.id.tv_spinner)).setText(m.result);
            ((ImageView) view.findViewById(R.id.icon_spinner)).setImageResource(m.image);
            view.setBackgroundColor(m.state ? Color.YELLOW : Color.TRANSPARENT);
            return  view;
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
    public class Model {
        String result;
        int image;
        boolean state;

        Model(int _image, String _result) {
            this.image = _image;
            this.result = _result;
        }
    }
}
