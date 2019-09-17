package jordean.profbio.ufpb.mestrado.investigacaodeplantas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;


public class AtividadesAdapter extends ArrayAdapter<String> {

    private String[] titulosDasAtividades;
    private Integer[] thumbnails;
    private Activity context;

    public AtividadesAdapter(Activity context, String[] titulosDasAtividades, Integer[] thumbnails) {
        super(context, R.layout.item_lista_atividades, titulosDasAtividades);
        this.titulosDasAtividades = titulosDasAtividades;
        this.thumbnails = thumbnails;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        ViewHolder viewHolder = null;

        if(view == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.item_lista_atividades, null, true);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.imageView.setImageResource(thumbnails[position]);
        viewHolder.textView.setText(titulosDasAtividades[position]);

        return view;
    }

    private class ViewHolder {
        TextView textView;
        ImageView imageView;

        ViewHolder(View view) {
            textView = view.findViewById(R.id.titulo_item_atividades);
            imageView = view.findViewById(R.id.imagem_item_atividades);
        }
    }
}
