package jordean.profbio.ufpb.mestrado.investigacaodeplantas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;

public class PlantasAdapter extends BaseAdapter {

    private int[] imagens;
    private LayoutInflater inflater;

    public PlantasAdapter(Context applicationContext, int[] imagens) {
        this.imagens = imagens;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return imagens.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.plantas_spinner, null);
        ImageView icon = convertView.findViewById(R.id.imagem_planta);
        icon.setImageResource(imagens[position]);
        return convertView;
    }
}
