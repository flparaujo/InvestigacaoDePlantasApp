package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.plantasdesconhecidas;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.FinalizacaoAtividade1Fragment;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtapaPlantaDesconhecidaFragment extends Fragment {


    public EtapaPlantaDesconhecidaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FotoIdentificacaoModel fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);
        fotoIdentificacaoModel.setExistePlantaSemGrupoIdentificado(FotoIdentificacaoModel.UNDEFINED);

        Button botaoSim = view.findViewById(R.id.button_sim7);
        Button botaoNao = view.findViewById(R.id.button_nao7);

        botaoSim.setOnClickListener(v -> {
            fotoIdentificacaoModel.setExistePlantaSemGrupoIdentificado(FotoIdentificacaoModel.SIM);

            EtapaPlantaDesconhecidaAFragment etapaPlantaDesconhecidaAFragment = new EtapaPlantaDesconhecidaAFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, etapaPlantaDesconhecidaAFragment)
                    .addToBackStack("Questao 7")
                    .commit();
        });

        botaoNao.setOnClickListener(v -> {
            fotoIdentificacaoModel.setExistePlantaSemGrupoIdentificado(FotoIdentificacaoModel.NAO);

            FinalizacaoAtividade1Fragment finalizacaoAtividade1Fragment = new FinalizacaoAtividade1Fragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, finalizacaoAtividade1Fragment)
                    .addToBackStack("Questao 7")
                    .commit();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_etapa_planta_desconhecida, container, false);

    }

}
