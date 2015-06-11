package hva.pages;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ListItemAdapter extends ArrayAdapter<ListItem> {

        Context context;
        int layoutResourceId;
        ListItem data[] = null;

public ListItemAdapter(Context context, int layoutResourceId, ListItem[] data)
{
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ListItemHolder holder = null;

        final Intent OpenEmailAppIntent= new Intent(Intent.ACTION_MAIN);
        final Intent OpenGalleryAppIntent= new Intent(Intent.ACTION_MAIN);
        final Intent OpenMessageAppIntent= new Intent(Intent.ACTION_MAIN);
        final Intent OpenCalculatorAppIntent= new Intent(Intent.ACTION_MAIN);
        final Intent OpenCalendarAppIntent= new Intent(Intent.ACTION_MAIN);
        final Intent OpenContactsAppIntent= new Intent(Intent.ACTION_MAIN);
        final Intent OpenMarketAppIntent= new Intent(Intent.ACTION_MAIN);
        final Intent OpenMusicAppIntent= new Intent(Intent.ACTION_MAIN);



        if (row == null) {
                //LayoutInflater inflater = ((Activity)context).getLayoutInflater()
                LayoutInflater inflater = LayoutInflater.from(context);
                row = inflater.inflate(layoutResourceId, parent, false);

                holder = new ListItemHolder();
                holder.imgIcon = (TextView) row.findViewById(R.id.imgIcon);
                holder.txtTitle = (TextView) row.findViewById(R.id.txtTitle);

                row.setTag(holder);
        }
        else
        {
                holder = (ListItemHolder) row.getTag();
        }

        final ListItem list_item = data[position];
        holder.txtTitle.setText(list_item.title);
        holder.imgIcon.setText(list_item.icon);

        final ListItemHolder finalHolder = holder;
        holder.txtTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        String selected_item = finalHolder.txtTitle.getText().toString();
                        //take the word i want from the selected_item
                        switch (selected_item) {
                                case "Email": {
                                        OpenEmailAppIntent.addCategory(Intent.CATEGORY_APP_EMAIL);
                                        OpenEmailAppIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(OpenEmailAppIntent);
                                        break;
                                }
                                case "Message": {
                                        OpenMessageAppIntent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                                        OpenMessageAppIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(OpenMessageAppIntent);
                                        break;
                                }
                                case "Gallery": {
                                        OpenGalleryAppIntent.addCategory(Intent.CATEGORY_APP_GALLERY);
                                        OpenGalleryAppIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(OpenGalleryAppIntent);
                                        break;
                                }
                                case "Calculator": {
                                        OpenCalculatorAppIntent.addCategory(Intent.CATEGORY_APP_CALCULATOR);
                                        OpenCalculatorAppIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(OpenCalculatorAppIntent);
                                        break;
                                }
                                case "Calendar": {
                                        OpenCalendarAppIntent.addCategory(Intent.CATEGORY_APP_CALENDAR);
                                        OpenCalendarAppIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(OpenCalendarAppIntent);
                                        break;
                                }
                                case "Contacts": {
                                        OpenContactsAppIntent.addCategory(Intent.CATEGORY_APP_CONTACTS);
                                        OpenContactsAppIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(OpenContactsAppIntent);
                                        break;
                                }

                                case "Market": {
                                        OpenMarketAppIntent.addCategory(Intent.CATEGORY_APP_MARKET);
                                        OpenMarketAppIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(OpenMarketAppIntent);
                                        break;
                                }
                                case "Music": {
                                        OpenMusicAppIntent.addCategory(Intent.CATEGORY_APP_MUSIC);
                                        OpenMusicAppIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(OpenMusicAppIntent);
                                        break;
                                }

                        }
                }
        });


        return row;


}


static class ListItemHolder
{
    TextView imgIcon;
    TextView txtTitle;
}
}