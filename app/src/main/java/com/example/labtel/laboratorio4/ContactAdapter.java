package com.example.labtel.laboratorio4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.labtel.laboratorio4.Contacto;
import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by front-team on 11/2/16.
 */

public class ContactAdapter extends BaseAdapter{
    private Context mContext;
    private ArrayList<Contacto> contactArrayList = new ArrayList<Contacto>();

    public ContactAdapter(Context oContext, ArrayList<Contacto> oContractArrayList) {
        this.mContext = oContext;
        this.contactArrayList = oContractArrayList;
    }

    @Override
    public int getCount() {
        return this.contactArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.contactArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class Contact {
        TextView name;
        TextView number;
        TextView email;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact contact = new Contact();
        View row;
        row = LayoutInflater.from(mContext).inflate(R.layout.contact_layout, parent, false);
        contact.name = (TextView) row.findViewById(R.id.contact_name);
        contact.number = (TextView) row.findViewById(R.id.contact_number);
        contact.email = (TextView) row.findViewById(R.id.contact_email);

        contact.name.setText(contactArrayList.get(position).getNombre());
        contact.email.setText(contactArrayList.get(position).getCorreo());
        contact.number.setText(contactArrayList.get(position).getNumero());


        return row;
    }
}
