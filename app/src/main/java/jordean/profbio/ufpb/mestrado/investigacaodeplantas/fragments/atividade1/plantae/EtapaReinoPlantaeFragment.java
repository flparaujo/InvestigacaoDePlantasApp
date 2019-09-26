package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.plantae;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtapaReinoPlantaeFragment extends Fragment {

    public EtapaReinoPlantaeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        FotoIdentificacaoModel fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);

        fotoIdentificacaoModel.setExistemOrganismosDoReinoPlantae(FotoIdentificacaoModel.UNDEFINED);

        Button botaoSim = view.findViewById(R.id.button_sim);
        Button botaoNao = view.findViewById(R.id.button_nao);

        Log.i("TEM?", fotoIdentificacaoModel.isExistemOrganismosDoReinoPlantae()+"");

        botaoSim.setOnClickListener(v -> {
            fotoIdentificacaoModel.setExistemOrganismosDoReinoPlantae(FotoIdentificacaoModel.SIM);

            EtapaReinoPlantaeAFragment etapaReinoPlantaeAFragment = new EtapaReinoPlantaeAFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.fragment_container, etapaReinoPlantaeAFragment)
                    .addToBackStack("Questao 1")
                    .commit();
        });

        botaoNao.setOnClickListener(v -> {
            fotoIdentificacaoModel.setExistemOrganismosDoReinoPlantae(FotoIdentificacaoModel.NAO);

            EtapaReinoPlantaeBFragment etapaReinoPlantaeBFragment = new EtapaReinoPlantaeBFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.fragment_container, etapaReinoPlantaeBFragment)
                    .addToBackStack("Questao 1")
                    .commit();
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_etapa_reino_plantae, container, false);
    }

}
