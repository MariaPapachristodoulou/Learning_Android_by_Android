package hva.pages;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener
{
    Intent i;


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
    {

        String item=adapterView.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
}
