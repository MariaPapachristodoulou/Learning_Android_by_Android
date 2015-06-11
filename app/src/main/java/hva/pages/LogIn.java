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
import android.widget.TextView;

//
public class LogIn extends ActionBarActivity {

//Declaration
    Button CodeBtn;
    TextView TitleTextView;

    //String with the code to be shown
    String code="At the Sending Activity\n" +
            "i = new Intent(getApplicationContext(), LogIn.class);\n" +
            "                i.putExtra(\"Name\",Name.getText().toString());\n" +
            "                i.putExtra(\"Surname\",Surname.getText().toString());\n" +
            "                startActivity(i);\n\n" +
            "At the Receiving Activity \n" +
            "Intent i = getIntent();\n" +
            "        String Name = getIntent().getExtras().getString(\"Name\");\n" +
            "        String Surname = getIntent().getExtras().getString(\"Surname\");\n" +
            "        String Text = \"Thanks for Log in \"+Name +\" \"+ Surname ;";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //Initialization- Get Data from PassData Class
        Intent i = getIntent();
        String Name = getIntent().getExtras().getString("Name");
        String Surname = getIntent().getExtras().getString("Surname");
        String Text = "Welcome "+Name +" "+ Surname ;

        //Initialize components and set properties
        TitleTextView= (TextView) findViewById(R.id.SecondActivity_textview_id);
        TitleTextView.setText(Text);

        //Listener on Button to show Code
        addListenerOnButton();

    }

    public void addListenerOnButton() {
        //Initialization
        CodeBtn = (Button) findViewById(R.id.Btn_Code_id);

        //Listener-Event - Show the Code
        CodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Dialog for the Code
                AlertDialog.Builder builder = new AlertDialog.Builder(LogIn.this);
                builder.setTitle("Code");
                builder.setMessage(code);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setCancelable(true);
                AlertDialog a = builder.create();
                a.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
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