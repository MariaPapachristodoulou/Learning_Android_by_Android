package hva.pages;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity2Activity extends ActionBarActivity {

    //Declaration
    private String[] list_items;
    private ListView list;

    private ImageButton Lynda;
    private ImageButton Android;

    private TextView Title;
    private TextView Code;

    private Intent ToastMessageIntent= new Intent(Intent.ACTION_MAIN);
    private Intent PopUpMessageIntent= new Intent(Intent.ACTION_MAIN);
    private Intent OpenAppIntent= new Intent(Intent.ACTION_MAIN);
    private Intent PassDataIntent= new Intent(Intent.ACTION_MAIN);
    private Intent NavigationIntent= new Intent(Intent.ACTION_MAIN);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        //Add Listeners
        addListenerOnListView();
        addLyndaImageButtonListener();
        addAndroidImageButtonListener();
    }

    //Function to Image with Android to redirect user to Android Developer Page
    public void addAndroidImageButtonListener()
    {
        Lynda = (ImageButton) findViewById(R.id.Android_imagebutton_id);
        Lynda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com/training/index.html")));
            }
        });
    }

    //Function to Open Lynda App when click on Lynda Image
    public void addLyndaImageButtonListener(){

    Android = (ImageButton) findViewById(R.id.Lynda_imagebutton_id);
    Android.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String appPackageName = "com.lynda.android.root";
            try {
                //Go to Lynda android application
                Intent intent = getPackageManager().getLaunchIntentForPackage(appPackageName);
                startActivity(intent);
            }
            catch (Exception e){
                //Check if the user wants to install the Lynda application
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2Activity.this);
                builder.setTitle("Warning!");
                builder.setMessage("You don't have lynda.com android application installed. \nDo you want to install it?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            //Go to Marketplace
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            //Go to Google Play
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setCancelable(true);

                AlertDialog alert = builder.create();
                alert.show();
            }
        }
    });
    }


    //Listener on the List
    private void addListenerOnListView()
    {

        //Takes List items from the Resources
       list_items= getResources().getStringArray(R.array.Tutorials_ListView_array);
        //Initialize Listview
        list = (ListView) findViewById(R.id.Tutorials_ListView_id);

        //Adapter which sets which is the list and how it will be shown
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_simple, list_items);

        //Set Adapter
        list.setAdapter(adapter);

        //Listener on the List
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Clicked Item
                String selected_item = (String) (list.getItemAtPosition(position));

                switch (selected_item) {
                    case "Toast Message": {
                        //Go to Toast page
                        ToastMessageIntent = new Intent(getApplicationContext(), DoToast.class);
                        startActivity(ToastMessageIntent);

                        break;
                    }
                    case "Pop-up Message": {
                        //Go to Pop up message page
                        PopUpMessageIntent = new Intent(getApplicationContext(), DoDialog.class);
                        startActivity(PopUpMessageIntent);

                        break;
                    }
                    case "Pass Data": {
                        //Go to Pass Data page
                        PassDataIntent = new Intent(getApplicationContext(), PassData.class);
                        startActivity(PassDataIntent);
                        break;
                    }
                    case "Open App": {
                        //Go to Open App page
                        OpenAppIntent = new Intent(getApplicationContext(), OpenApps.class);
                        startActivity(OpenAppIntent);
                        break;
                    }
                    case "Navigation": {
                        //go to Navigation page
                        NavigationIntent = new Intent(getApplicationContext(), Activity1.class);
                        startActivity(NavigationIntent);
                        break;
                    }
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
