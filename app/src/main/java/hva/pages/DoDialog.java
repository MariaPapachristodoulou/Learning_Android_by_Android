package hva.pages;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DoDialog extends ActionBarActivity {

    //Declaration of the Components and the GestureDetector
    private EditText title;
    private EditText content;
    private Button dialog_show;
    private Button CodeBtn;
    private ScaleGestureDetector scaleGestureDetector;


    //String which contains the code to be shown
    String d_code = "AlertDialog.Builder builder = new AlertDialog.Builder(<class>.this); \n"
            + "\n"
            + "builder.setMessage(R.string.DialogMessage); \n"
            + "builder.setTitle(R.string.DialogTitle); \n"
            + "builder.setPositiveButton(\"OK\", new DialogInterface.OnClickListener() \n"
            + "{ \n"
            + "   @Override \n"
            + "   public void onClick(DialogInterface dialog, int which) \n"
            + "   { \n"
            + "       dialog.dismiss(); \n"
            + "   } \n"
            + "}); \n"
            + "\n"
            + "builder.setCancelable(true); \n"
            + "\n"
            + "AlertDialog alertDialog = builder.create(); \n"
            + "alertDialog.show();";


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_dialog);


    //Initialization
        title = (EditText) findViewById(R.id.dialog_title_id);
        content = (EditText) findViewById(R.id.dialog_content_id);
        dialog_show = (Button) findViewById(R.id.show_dialog_id);

    //Button Event to show the custom Dialog
        dialog_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Custom Dialog;Title and Content input by the user
                AlertDialog.Builder builder = new AlertDialog.Builder(DoDialog.this);
                String Dialog_title = title.getText().toString();
                String Dialog_message = content.getText().toString();

                //Check if the user input title
                if (Dialog_title != null)
                {
                    builder.setTitle(Dialog_title);
                }
                else //If not set a default title
                {
                    builder.setTitle("My Dialog");
                }

                //Check if the user input message
                if (Dialog_message != null)
                {
                    builder.setMessage(Dialog_message);
                }
                else //If not set a default message
                {
                    builder.setMessage("You didn't input the content of the Dialog!");
                }

                //Set OK button in the dialog
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                builder.setCancelable(true);

                //Create and show dialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        //Listener to the button to show the Code
        addListenerOnButton();

            }

    public void addListenerOnButton() {
        //Initialize Button
        CodeBtn = (Button) findViewById(R.id.Btn_Code_id);

        //Listener-Event - Show the Code
        CodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(DoDialog.this);
                builder.setTitle("Code");
                builder.setMessage(d_code);
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
        getMenuInflater().inflate(R.menu.menu_do_dialog, menu);
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
