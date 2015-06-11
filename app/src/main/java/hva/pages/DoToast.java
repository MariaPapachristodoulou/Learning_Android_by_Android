package hva.pages;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class DoToast extends ActionBarActivity {
    //Declaration
    private Button CodeBtn;
    private EditText content;
    private int mGravity;
    private int duration_selection;
    private RadioGroup radioGroup;
    private TextView code;
    private String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_toast);
        //Initialize
        content = (EditText) findViewById(R.id.toast_content);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_id);

        //Listener for RadioGroup
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rdb_long) {
                    duration_selection = Toast.LENGTH_LONG;
                    selection = "Toast.LENGTH_LONG";
                }
                if (checkedId == R.id.rdb_short_id) {
                    duration_selection = Toast.LENGTH_SHORT;
                    selection = "Toast.LENGTH_SHORT";
                }
            }
        });

        //Initialize Button
        Button custom_toast = (Button) findViewById(R.id.showtoast_btn_id);

        //Listener on Button to show the Custom Toast
        custom_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), content.getText(), duration_selection).show();
            }
        });

        //Listener on Button to show the Code
        addListenerOnButton();
    }

    public void addListenerOnButton() {


        //Initialize button
        CodeBtn = (Button) findViewById(R.id.Btn_Code_id);

        //Listener-Event - Show the Code
        CodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(DoToast.this);
                builder.setTitle("Code");
                builder.setMessage("Toast.makeText(getApplicationContext(), '" + content.getText() + "' , " + selection + ").show();");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setCancelable(true);
                AlertDialog a=builder.create();
                a.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_do_toast, menu);
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
