package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.plantae;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtapaReinoPlantaeDFragment extends Fragment {

    public EtapaReinoPlantaeDFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FotoIdentificacaoModel fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);
        fotoIdentificacaoModel.setTiposDeAtividadeAmbiente(null);

        EditText tiposDeAtividade = view.findViewById(R.id.tipos_de_atividades_ambiente);


        Button proxima = view.findViewById(R.id.button_next1d);

        proxima.setOnClickListener(v -> {
            fotoIdentificacaoModel.setTiposDeAtividadeAmbiente(tiposDeAtividade.getText().toString());

            EtapaReinoPlantaeEFragment etapaReinoPlantaeEFragment = new EtapaReinoPlantaeEFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.fragment_container, etapaReinoPlantaeEFragment)
                    .addToBackStack("Questao 1d")
                    .commit();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_etapa_reino_plantae_d, container, false);

    }

}
