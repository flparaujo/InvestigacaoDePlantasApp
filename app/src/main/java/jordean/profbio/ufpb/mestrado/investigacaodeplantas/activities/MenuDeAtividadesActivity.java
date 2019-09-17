package jordean.profbio.ufpb.mestrado.investigacaodeplantas.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.adapter.AtividadesAdapter;

public class MenuDeAtividadesActivity extends AppCompatActivity {

    ListView listView;
    String[] titulosDasAtividades = {"Fotoidentificação de plantas", "Chave simplificada para identificação de plantas"};
    Integer[] thumbnails = {R.drawable.taking_pic, R.drawable.atividade2_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_de_atividades);

        Toolbar toolbar = findViewById(R.id.menu_atividades_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.lista_atividades);

        AtividadesAdapter atividadesAdapter = new AtividadesAdapter(this, titulosDasAtividades, thumbnails);
        listView.setAdapter(atividadesAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0:
                    startActivity(new Intent(MenuDeAtividadesActivity.this, FotoIdentificacaoActivity.class));
                    finish();
                    break;
                case 1:
                    startActivity(new Intent(MenuDeAtividadesActivity.this, ChaveIdentificacaoGrupoPlantaActivity.class));
                    finish();
                    break;
                default:
                    break;
            }
        });
    }
}
