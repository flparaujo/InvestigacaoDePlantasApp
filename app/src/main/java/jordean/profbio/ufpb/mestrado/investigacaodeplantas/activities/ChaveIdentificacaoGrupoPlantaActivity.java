package jordean.profbio.ufpb.mestrado.investigacaodeplantas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade2.DescricaoAtividade2Fragment;

public class ChaveIdentificacaoGrupoPlantaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chave_identificacao_grupo_planta);


        if(findViewById(R.id.fragment_container1) != null) {
            if (savedInstanceState != null) {
                return;
            }

            DescricaoAtividade2Fragment descricaoAtividade2Fragment = new DescricaoAtividade2Fragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container1, descricaoAtividade2Fragment)
                    .commit();
        }

    }
}
