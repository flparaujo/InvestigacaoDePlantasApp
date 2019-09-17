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
public class EtapaReinoPlantaeBFragment extends Fragment {

    private FotoIdentificacaoModel fotoIdentificacaoModel;

    public EtapaReinoPlantaeBFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);
        fotoIdentificacaoModel.setMotivoNaoTerOrganismos(null);

        EditText motivoNaoTerPlantae = view.findViewById(R.id.motivo_nao_ter_plantae);

        Button proxima = view.findViewById(R.id.button_next1b);

        proxima.setOnClickListener(v -> {
            fotoIdentificacaoModel.setMotivoNaoTerOrganismos(motivoNaoTerPlantae.getText().toString());

            EtapaReinoPlantaeDFragment etapaReinoPlantaeDFragment = new EtapaReinoPlantaeDFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, etapaReinoPlantaeDFragment)
                    .addToBackStack("Questao 1b")
                    .commit();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_etapa_reino_plantae_b, container, false);

    }

}
