package hva.pages;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PassData extends ActionBarActivity {

    //Declaration
    Button Gobtn;
    Intent i;
    EditText Name,Surname
            ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_data);

        //Listener on the Button
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        //Initialize Components
        Name=(EditText)findViewById(R.id.Name);
        Surname=(EditText)findViewById(R.id.Surname);
        Gobtn = (Button) findViewById(R.id.Go_btn_id);

        //Listener on the Button
        Gobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Puts extra data to the intent so data can be passed to the next Axtivity(LogIn)
                i = new Intent(getApplicationContext(), LogIn.class);
                i.putExtra("Name", Name.getText().toString());
                i.putExtra("Surname", Surname.getText().toString());
                startActivity(i);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pass_data, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
