package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.pteridofitas;


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
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtapaNomesPteridofitasFragment extends Fragment {


    public EtapaNomesPteridofitasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FotoIdentificacaoModel fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);
        fotoIdentificacaoModel.setSabeONomeDasPteridofitas(FotoIdentificacaoModel.UNDEFINED);

        Button botaoSim = view.findViewById(R.id.button_sim4);
        Button botaoNao = view.findViewById(R.id.button_nao4);

        botaoSim.setOnClickListener(v -> {
            fotoIdentificacaoModel.setSabeONomeDasPteridofitas(FotoIdentificacaoModel.SIM);

            EtapaNomesPteridofitasAFragment etapaNomesPteridofitasAFragment = new EtapaNomesPteridofitasAFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, etapaNomesPteridofitasAFragment)
                    .addToBackStack("Questao 4")
                    .commit();
        });

        botaoNao.setOnClickListener(v -> {
            fotoIdentificacaoModel.setSabeONomeDasPteridofitas(FotoIdentificacaoModel.NAO);

            EtapaNomesPteridofitasBFragment etapaNomesPteridofitasBFragment = new EtapaNomesPteridofitasBFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, etapaNomesPteridofitasBFragment)
                    .addToBackStack("Questao 4")
                    .commit();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_etapa_nomes_pteridofitas, container, false);

    }

}
