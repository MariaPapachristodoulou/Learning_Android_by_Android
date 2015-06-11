package hva.pages;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;



public class OpenApps extends ActionBarActivity {


    //Declaration
    private String[] list_items;
    private ListView list;

    private Intent OpenEmailAppIntent= new Intent(Intent.ACTION_MAIN);
    private Intent OpenGalleryAppIntent= new Intent(Intent.ACTION_MAIN);
    private Intent OpenMessageAppIntent= new Intent(Intent.ACTION_MAIN);
    private Intent OpenCalculatorAppIntent= new Intent(Intent.ACTION_MAIN);
    private Intent OpenCalendarAppIntent= new Intent(Intent.ACTION_MAIN);
    private Intent OpenContactsAppIntent= new Intent(Intent.ACTION_MAIN);
    private Intent OpenMarketAppIntent= new Intent(Intent.ACTION_MAIN);
    private Intent OpenMusicAppIntent= new Intent(Intent.ACTION_MAIN);

    private TextView CodeTextView;
    private TextView TitleCodeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_apps);

        //Populate List
        Populate();
        //Add Listener on ListView
        addListenerOnListView();
    }

    //Function to populate the list with the items
    public void Populate(){

        //Initialize Listview
        list = (ListView) findViewById(R.id.AppsList_ListView_id);
        ListItem List_items1[]= new ListItem[]
                {
                        new ListItem("</>","Email"),
                        new ListItem("</>","Message"),
                        new ListItem("</>","Gallery"),
                        new ListItem("</>","Calculator"),
                        new ListItem("</>","Calendar"),
                        new ListItem("</>","Contacts"),
                        new ListItem("</>","Market"),
                        new ListItem("</>","Music")
                };


        //Adapter which sets which is the list and how it will be shown
        ListItemAdapter adapter= new ListItemAdapter(getApplicationContext(), R.layout.list_item, List_items1);

        //Set Adapter
        list.setAdapter(adapter);


    }
    private void addListenerOnListView()
    {

        //Initialize
        list = (ListView) findViewById(R.id.AppsList_ListView_id);

        //Array with Items
        ListItem List_items1[]= new ListItem[]
                {
                        new ListItem("</>","Email"),
                        new ListItem("</>","Message"),
                        new ListItem("</>","Gallery"),
                        new ListItem("</>","Calculator"),
                        new ListItem("</>","Calendar"),
                        new ListItem("</>","Contacts"),
                        new ListItem("</>","Market"),
                        new ListItem("</>","Music")
                };


        //Adapter which sets which is the list and how it will be shown
        ListItemAdapter adapter= new ListItemAdapter(getApplicationContext(), R.layout.list_item, List_items1);

        //Set Adapter
        list.setAdapter(adapter);

        //Listener on the List
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int selected_item= position;


                switch(selected_item)
                {
                    case 0:
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(OpenApps.this);
                        builder.setTitle("Code");
                        builder.setMessage("Intent OpenEmailAppIntent= new Intent(Intent.ACTION_MAIN);\n \n...\n \nOpenEmailAppIntent.addCategory(Intent.CATEGORY_APP_EMAIL);\n" +
                                "                        startActivity(OpenEmailAppIntent);");

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                                @Override
                                           public void onClick(DialogInterface dialog, int which)
                                           {
                                               dialog.dismiss();
                                           }
                                        });
                                         builder.setCancelable(true);
                                AlertDialog a = builder.create();
                        a.show();
                        break;
                    }
                    case 1:
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(OpenApps.this);
                        builder.setTitle("Code");
                        builder.setMessage("Intent OpenMessageAppIntent= new Intent(Intent.ACTION_MAIN);\n \n...\n \nOpenMessageAppIntent.addCategory(Intent.CATEGORY_APP_MESSAGING);\n" +
                                "                        startActivity(OpenMessageAppIntent);");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.setCancelable(true);
                        AlertDialog a = builder.create();
                        a.show();

                        break;
                    }
                    case 2:
                    {

                        AlertDialog.Builder builder = new AlertDialog.Builder(OpenApps.this);
                        builder.setTitle("Code");
                        builder.setMessage("Intent OpenGalleryAppIntent= new Intent(Intent.ACTION_MAIN);\n \n...\n \nOpenGalleryAppIntent.addCategory(Intent.CATEGORY_APP_GALLERY);\n" +
                                "                        startActivity(OpenGalleryAppIntent);");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.setCancelable(true);
                        AlertDialog a=builder.create();
                        a.show();

                        break;
                    }
                    case 3:
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(OpenApps.this);
                        builder.setTitle("Code");
                        builder.setMessage("Intent OpenCalculatorAppIntent= new Intent(Intent.ACTION_MAIN);\n \n...\n \nOpenCalculatorAppIntent.addCategory(Intent.CATEGORY_APP_CALCULATOR);\n" +
                                "                        startActivity(OpenCalculatorAppIntent);");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.setCancelable(true);
                        AlertDialog a=builder.create();
                        a.show();
                        break;
                    }
                    case 4:
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(OpenApps.this);
                        builder.setTitle("Code");
                        builder.setMessage("Intent OpenCalendarAppIntent= new Intent(Intent.ACTION_MAIN);\n \n...\n \nOpenCalendarAppIntent.addCategory(Intent.CATEGORY_APP_CALENDAR);\n" +
                                "                        startActivity(OpenCalendarAppIntent);");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.setCancelable(true);
                        AlertDialog a=builder.create();
                        a.show();
                        break;
                    }
                    case 5:
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(OpenApps.this);
                        builder.setTitle("Code");
                        builder.setMessage("Intent OpenContactsAppIntent= new Intent(Intent.ACTION_MAIN);\n \n...\n \nOpenContactsAppIntent.addCategory(Intent.CATEGORY_APP_CONTACTS);\n" +
                                "                        startActivity(OpenContactsAppIntent);");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.setCancelable(true);
                        AlertDialog a=builder.create();
                        a.show();
                        break;
                    }

                    case 6:
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(OpenApps.this);
                        builder.setTitle("Code");
                        builder.setMessage("Intent OpenMarketAppIntent= new Intent(Intent.ACTION_MAIN);\n \n...\n \nOpenMarketAppIntent.addCategory(Intent.CATEGORY_APP_MARKET);\n" +
                                "                        startActivity(OpenMarketAppIntent);");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.setCancelable(true);
                        AlertDialog a=builder.create();
                        a.show();
                        break;
                    }
                    case 7:
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(OpenApps.this);
                        builder.setTitle("Code");
                        builder.setMessage("Intent OpenMusicAppIntent= new Intent(Intent.ACTION_MAIN);\n \n...\n \nOpenMusicAppIntent.addCategory(Intent.CATEGORY_APP_MUSIC);\n" +
                                "                        startActivity(OpenMusicAppIntent);");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.setCancelable(true);
                        AlertDialog a=builder.create();
                        a.show();

                        break;
                    }

                }
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_open_apps, menu);
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
