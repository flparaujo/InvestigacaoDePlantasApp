package jordean.profbio.ufpb.mestrado.investigacaodeplantas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.DescricaoAtividade1Fragment;

public class FotoIdentificacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_identificacao);

        if(findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            DescricaoAtividade1Fragment descricaoAtividade1Fragment = new DescricaoAtividade1Fragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, descricaoAtividade1Fragment)
                    .commit();
        }

    }
}
