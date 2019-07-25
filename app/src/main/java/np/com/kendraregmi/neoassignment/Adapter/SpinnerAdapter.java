package np.com.kendraregmi.neoassignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import np.com.kendraregmi.neoassignment.R;

public class SpinnerAdapter extends BaseAdapter {

    Context context;
    int[] flags;
    String[] countryName;

    public SpinnerAdapter(Context context, int[] flags, String[] countryName){
        this.context=context;
        this.flags=flags;
        this.countryName=countryName;

    }
    @Override
    public int getCount() {
        return countryName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.custom_spinner,null);
        ImageView icon= view.findViewById(R.id.flag);
        TextView name= view.findViewById(R.id.countryName);
        icon.setImageResource(flags[i]);
        name.setText(countryName[i]);
        return null;
    }
}
